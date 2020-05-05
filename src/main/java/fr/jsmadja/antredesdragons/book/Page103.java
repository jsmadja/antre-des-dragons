package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.pages.DiceWay;
import fr.jsmadja.antredesdragons.pages.RollAndGoPage;

import java.util.List;

public class Page103 extends RollAndGoPage {
    @Override
    protected List<DiceWay> getDiceWays(Pip pip) {
        return List.of(
                DiceWay.builder().from(2).to(9).pageNumber(PageNumber.page(98)).build(),
                DiceWay.builder().from(10).to(12).pageNumber(PageNumber.page(99)).build()
        );
    }

    @Override
    public String getText() {
        return "Lancez deux dés. Si vous faites :\n" +
                "de 2 à 9 : les Trolls, très agressifs de nature demeurent inaccessibles à tout " +
                "raisonnement. Retournez au [98] et refaites votre choix, de 10 à 12 : les Trolls vous " +
                "laissent passer. Rendez-vous au [99].";
    }
}
