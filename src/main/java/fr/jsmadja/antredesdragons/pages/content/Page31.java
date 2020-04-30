package fr.jsmadja.antredesdragons.pages.content;

import fr.jsmadja.antredesdragons.pages.types.Execution;
import fr.jsmadja.antredesdragons.dices.DiceWay;
import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.pages.types.Page;

public class Page31 extends Page {
    @Override
    public String getText() {
        return "Rien à faire, encore perdu. Lancez les dés de nouveau.\n" +
                "SI VOUS faites :\n" +
                "de 2 à 6 : rendez-vous au [17].\n" +
                "de 7 à 12 : rendez-vous au [73].";
    }

    @Override
    public Execution execute(Pip pip) {
        return pip.rollAndGo(
                new DiceWay(2, 6, PageNumber.of(17)),
                new DiceWay(7, 12, PageNumber.of(73))
        );
    }
}
