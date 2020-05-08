package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.chapters.ChapterNumber;
import fr.jsmadja.antredesdragons.chapters.DiceWay;
import fr.jsmadja.antredesdragons.chapters.RollAndGoChapter;
import fr.jsmadja.antredesdragons.entities.Pip;

import java.util.List;

public class Chapter17 extends RollAndGoChapter {
    @Override
    protected List<DiceWay> getDiceWays(Pip pip) {
        return List.of(
                DiceWay.builder().from(2).to(6).chapterNumber(ChapterNumber.chapter(73)).build(),
                DiceWay.builder().from(7).to(12).chapterNumber(ChapterNumber.chapter(82)).build()
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
