package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.pages.DiceWay;
import fr.jsmadja.antredesdragons.pages.RollAndGoPage;

import java.util.List;

public class Page31 extends RollAndGoPage {
    @Override
    public String getText() {
        return "Rien à faire, encore perdu. Lancez les dés de nouveau.\n" +
                "SI VOUS faites :\n" +
                "de 2 à 6 : rendez-vous au [17].\n" +
                "de 7 à 12 : rendez-vous au [73].";
    }

    @Override
    protected List<DiceWay> getDiceWays() {
        return List.of(
                new DiceWay(2, 6, PageNumber.page(17)),
                new DiceWay(7, 12, PageNumber.page(73))
        );
    }
}
