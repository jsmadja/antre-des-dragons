package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.ChapterNumber;
import fr.jsmadja.antredesdragons.core.chapters.DiceWay;
import fr.jsmadja.antredesdragons.core.chapters.RollAndGoChapter;
import fr.jsmadja.antredesdragons.core.entities.Pip;

import java.util.List;

public class Chapter53 extends RollAndGoChapter {
    @Override
    protected List<DiceWay> getDiceWays(Pip pip) {
        return List.of(
                DiceWay.builder().from(2).to(6).chapterNumber(ChapterNumber.chapter(73)).build(),
                DiceWay.builder().from(7).to(12).chapterNumber(ChapterNumber.chapter(17)).build()
        );
    }

    @Override
    public String getText() {
        return "Comme aventurier, vous vous posez là. Pas même capable de trouver votre chemin " +
                "pour sortir de... oh. peu importe ! Lancez les dés de nouveau. Et tâchez de vous y " +
                "prendre correctement cette fois !\n" +
                "Si vous faites :\n" +
                "de 2 à 6 : rendez-vous au [73].\n" +
                "de 7 à 12 : rendez-vous au [17].";
    }
}
