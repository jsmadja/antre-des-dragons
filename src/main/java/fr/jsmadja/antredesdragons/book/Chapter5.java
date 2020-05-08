package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.chapters.ChapterNumber;
import fr.jsmadja.antredesdragons.chapters.DiceWay;
import fr.jsmadja.antredesdragons.chapters.RollAndGoChapter;
import fr.jsmadja.antredesdragons.entities.Pip;

import java.util.List;

public class Chapter5 extends RollAndGoChapter {
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
    protected List<DiceWay> getDiceWays(Pip pip) {
        return List.of(new DiceWay(2, 6, ChapterNumber.chapter(31)),
                new DiceWay(7, 12, ChapterNumber.chapter(17)));
    }
}
