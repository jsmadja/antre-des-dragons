package fr.jsmadja.antredesdragons.market;

import fr.jsmadja.antredesdragons.ui.Events;
import fr.jsmadja.antredesdragons.ui.Prompt;
import fr.jsmadja.antredesdragons.entities.Pip;

import java.util.Arrays;
import java.util.stream.Collectors;

import static java.text.MessageFormat.format;

public class Market {
    public void enter(Pip pip) {
        Prompt.YesNoAnswer wantBuyAnswer = Prompt.question("Souhaitez-vous acheter un article");
        if (wantBuyAnswer.isNo()) {
            this.leave();
        } else {
            showItems();
            Prompt.NumberAnswer itemAnswer = Prompt.question("Quel article souhaitez-vous acheter", Arrays.stream(MarketItem.values()).map(Enum::ordinal).collect(Collectors.toList()));
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

    private void leave() {

    }

    private void showItems() {
        System.out.println("\n------- Liste de cours de Pip -------\n");
        Arrays.stream(MarketItem.values()).forEach(x -> System.out.println(format("{0} - {1}", x.ordinal(), x)));
    }
}
