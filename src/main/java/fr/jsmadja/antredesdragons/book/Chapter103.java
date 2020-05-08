package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.chapters.ChapterNumber;
import fr.jsmadja.antredesdragons.chapters.DiceWay;
import fr.jsmadja.antredesdragons.chapters.RollAndGoChapter;
import fr.jsmadja.antredesdragons.entities.Pip;

import java.util.List;

public class Chapter103 extends RollAndGoChapter {
    @Override
    protected List<DiceWay> getDiceWays(Pip pip) {
        return List.of(
                DiceWay.builder().from(2).to(9).chapterNumber(ChapterNumber.chapter(98)).build(),
                DiceWay.builder().from(10).to(12).chapterNumber(ChapterNumber.chapter(99)).build()
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
