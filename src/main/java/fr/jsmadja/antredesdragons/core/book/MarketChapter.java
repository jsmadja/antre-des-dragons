package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.Answer;
import fr.jsmadja.antredesdragons.core.chapters.Chapter;
import fr.jsmadja.antredesdragons.core.entities.Pip;
import fr.jsmadja.antredesdragons.core.execution.Action;
import fr.jsmadja.antredesdragons.core.execution.Execution;
import fr.jsmadja.antredesdragons.core.market.MarketItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static fr.jsmadja.antredesdragons.core.book.Book.START;
import static fr.jsmadja.antredesdragons.core.chapters.ChapterNumber.chapter;
import static java.lang.Integer.parseInt;

public class MarketChapter extends Chapter {

    @Override
    public Execution execute(Pip pip) {
        List<Action> actions = new ArrayList<>();
        actions.add(leaveMarketAction());
        insertItemActions(pip, actions);
        return Execution.builder().logEntries(pip.getCurrentChapterLogEntries()).actions(actions).build();
    }

    public void insertItemActions(Pip pip, List<Action> actions) {
        List<Action> itemActions = Arrays.stream(MarketItem.values())
                .filter(i -> pip.has(i.getPrice()) && !pip.has(i.getItem()))
                .map(this::toAction)
                .collect(Collectors.toList());
        actions.addAll(itemActions);
    }

    @Override
    public Execution execute(Pip pip, String questionId, Answer answer) {
        List<Action> actions = new ArrayList<>();
        actions.add(leaveMarketAction());
        if (questionId != null) {
            if (questionId.equals("QM") && answer.isYes()) {
                return super.execute(pip);
            }
            MarketItem itemToBuy = getItem(parseInt(questionId));
            if (pip.has(itemToBuy.getPrice())) {
                pip.buy(itemToBuy);
            }
        }
        insertItemActions(pip, actions);
        return Execution.builder().logEntries(pip.getCurrentChapterLogEntries()).actions(actions).build();
    }

    public Action leaveMarketAction() {
        return Action.builder()
                .question("Quitter le marché")
                .chapter(chapter(START))
                .build();
    }

    public Action toAction(MarketItem i) {
        return Action.builder().chapter(chapter(-11)).suffix("/questions/" + i.ordinal() + "/yes").question("Acheter " + i.toString()).build();
    }

    private MarketItem getItem(int ordinal) {
        return Arrays.stream(MarketItem.values()).collect(Collectors.toMap(MarketItem::ordinal, p -> p)).get(ordinal);
    }

    @Override
    public String getText() {
        return "";
    }

}
