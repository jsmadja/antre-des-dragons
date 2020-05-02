package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.pages.DiceWay;
import fr.jsmadja.antredesdragons.pages.RollAndGoPage;

import java.util.List;

public class Page17 extends RollAndGoPage {
    @Override
    protected List<DiceWay> getDiceWays() {
        return List.of(
                DiceWay.builder().from(2).to(6).pageNumber(PageNumber.page(73)).build(),
                DiceWay.builder().from(7).to(12).pageNumber(PageNumber.page(82)).build()
        );
    }

    @Override
    public String getText() {
        return "Désolé, mais vous semblez toujours complètement perdu. Lancez les dés de nouveau.\n" +
                "Si vous faites :\n" +
                "de 2 à 6 : rendez-vous au [73].\n" +
                "de 7 à 12 : rendez-vous au [82].";
    }
}
