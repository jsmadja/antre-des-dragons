package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.Answer;
import fr.jsmadja.antredesdragons.core.chapters.ChapterNumber;
import fr.jsmadja.antredesdragons.core.chapters.DiceWay;
import fr.jsmadja.antredesdragons.core.chapters.RollAndGoChapter;
import fr.jsmadja.antredesdragons.core.chapters.YesOrNoQuestion;
import fr.jsmadja.antredesdragons.core.entities.Pip;
import fr.jsmadja.antredesdragons.core.execution.Action;
import fr.jsmadja.antredesdragons.core.execution.Execution;

import java.util.ArrayList;
import java.util.List;

import static fr.jsmadja.antredesdragons.core.chapters.ChapterNumber.chapter;

public class Chapter27 extends RollAndGoChapter {
    @Override
    public String getText() {
        return "Allez-vous réussir cette descente vertigineuse? La falaise est extrêmement abrupte. " +
                "Et même avec des cordes et des crampons, il faut être un peu inconscient pour s'y " +
                "aventurer. Si vous hésitez, VOUS pouvez retourner immédiatement au [7] pour réfléchir " +
                "de nouveau aux choix qui s'offrent à vous. Mais si vous décidez de tenter l'aventure, " +
                "lancez deux dés.\n" +
                "Si vous faites :\n" +
                "de 2 à 8 : rendez-vous au [49].\n" +
                "de 9 à 12 : rendez-vous au [59].";
    }

    @Override
    public Execution execute(Pip pip, String questionId, Answer answer) {
        if (questionId == null) {
            YesOrNoQuestion question = YesOrNoQuestion.question("Q27", "Retourner au 7");
            List<Action> actions = new ArrayList<>(question.toActionsForChapter(chapter(27)));
            return Execution.builder().logEntries(pip.getCurrentChapterLogEntries()).actions(actions).build();
        }
        if (questionId.equals("Q27") && answer.isYes()) {
            return pip.goTo(ChapterNumber.chapter(7));
        }
        return super.execute(pip);
    }

    @Override
    public List<DiceWay> getDiceWays(Pip pip) {
        return List.of(new DiceWay(2, 8, ChapterNumber.chapter(49)), new DiceWay(9, 12, ChapterNumber.chapter(59)));
    }
}
