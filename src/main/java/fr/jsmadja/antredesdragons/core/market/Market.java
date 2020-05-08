package fr.jsmadja.antredesdragons.core.market;

import fr.jsmadja.antredesdragons.core.entities.Pip;
import fr.jsmadja.antredesdragons.core.ui.Events;
import fr.jsmadja.antredesdragons.core.ui.Prompt;

import java.util.Arrays;
import java.util.stream.Collectors;

import static java.text.MessageFormat.format;

public class Market {
    public void enter(Pip pip) {
        Prompt.YesNoAnswer wantBuyAnswer = Prompt.answerTo("Souhaitez-vous acheter un article");
        if (wantBuyAnswer.isYes()) {
            showItems();
            Events.statusEvent(pip.toString());
            Prompt.NumberAnswer itemAnswer = Prompt.answerTo("Quel article souhaitez-vous acheter", Arrays.stream(MarketItem.values()).map(Enum::ordinal).collect(Collectors.toList()));
            MarketItem marketItem = getItem(itemAnswer.getAnswer());
            if (pip.has(marketItem.getPrice())) {
                pip.buy(marketItem);
            } else {
                Events.event("Vous n'avez pas assez d'argent");
            }
            enter(pip);
        }
    }

    private MarketItem getItem(int ordinal) {
        return Arrays.stream(MarketItem.values()).collect(Collectors.toMap(MarketItem::ordinal, p -> p)).get(ordinal);
    }

    private void showItems() {
        Events.event("\n------- Liste de cours de Pip -------\n");
        Arrays.stream(MarketItem.values()).forEach(x -> System.out.println(format("{0} - {1}", x.ordinal(), x)));
    }
}
