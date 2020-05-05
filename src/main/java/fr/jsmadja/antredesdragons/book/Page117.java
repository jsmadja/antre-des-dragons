package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.pages.DiceWay;
import fr.jsmadja.antredesdragons.pages.RollAndGoPage;

import java.util.List;

public class Page117 extends RollAndGoPage {
    @Override
    protected List<DiceWay> getDiceWays(Pip pip) {
        return List.of(
                DiceWay.builder().from(2).to(4).pageNumber(PageNumber.page(124)).build(),
                DiceWay.builder().from(5).to(12).pageNumber(PageNumber.page(132)).build());
    }

    @Override
    public String getText() {
        return "Vous montez à bord du canot, vous repêchez les rames dans l'eau croupie, au fond de " +
                "la coque, vous les glissez dans les tolets, et vous vous écartez du rivage. L'eau sombre " +
                "absorbe la lumière de la torche que vous avez fixée à l'avant de votre embarcation, et " +
                "vous avez l'impression de ramer dans une nuit éternelle. L'eau qui s'infiltre dans le " +
                "bateau par de multiples fissures clapote déjà autour de vos chevilles, alors que vous " +
                "pesez sur les avirons pour essayer de gagner l'autre rive avant que cette vieille coque " +
                "de noix ne coule à pic. Lancez deux dés pour savoir si vous traverserez le lac sain et " +
                "sauf.\n" +
                "Si vous faites :\n" +
                "de 2 à 4 : rendez-vous au [124].\n" +
                "de 5 à 12 : rendez-vous au [132].";
    }
}
