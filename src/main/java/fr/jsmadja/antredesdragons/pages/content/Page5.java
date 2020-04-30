package fr.jsmadja.antredesdragons.pages.content;

import fr.jsmadja.antredesdragons.pages.types.Execution;
import fr.jsmadja.antredesdragons.dices.DiceWay;
import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.pages.types.Page;

public class Page5 extends Page {
    @Override
    public String getText() {
        return "Les bois semblent se refermer sur vous quand vous y pénétrez. Au bout de " +
                "quelques instants le sentier disparaît, et vous en êtes réduit à vous frayer un chemin " +
                "de votre mieux parmi les taillis, les buissons et les ronces. La progression est de " +
                "plus en plus difficile , de plus en plus tortueuse, et vous finissez par vous rendre " +
                "compte que vous êtes complètement perdu. Vous vous arrêtez un instant, et vous " +
                "vous grattez le sommet du crâne. Ce geste n'améliorant en rien votre situation, vous " +
                "prenez la seule décision possible : lancer deux dés pour voir si vous pouvez vous " +
                "sortir de là.\n" +
                "Si vous faites :\n" +
                "de 2 à 6 : rendez-vous au [31].\n" +
                "de 7 à 12 : rendez-vous au [17].";
    }

    @Override
    public Execution execute(Pip pip) {
        return pip.rollAndGo(
                new DiceWay(2, 6, PageNumber.of(31)),
                new DiceWay(7, 12, PageNumber.of(17)));
    }
}
