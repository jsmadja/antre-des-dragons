package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.ChapterNumber;
import fr.jsmadja.antredesdragons.core.chapters.DiceWay;
import fr.jsmadja.antredesdragons.core.chapters.RollAndGoChapter;
import fr.jsmadja.antredesdragons.core.entities.Pip;

import java.util.List;

public class Chapter31 extends RollAndGoChapter {
    @Override
    public String getText() {
        return "Rien à faire, encore perdu. Lancez les dés de nouveau.\n" +
                "SI VOUS faites :\n" +
                "de 2 à 6 : rendez-vous au [17].\n" +
                "de 7 à 12 : rendez-vous au [73].";
    }

    @Override
    protected List<DiceWay> getDiceWays(Pip pip) {
        return List.of(
                new DiceWay(2, 6, ChapterNumber.chapter(17)),
                new DiceWay(7, 12, ChapterNumber.chapter(73))
        );
    }
}
