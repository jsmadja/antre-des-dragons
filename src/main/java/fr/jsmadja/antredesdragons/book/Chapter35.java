package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.chapters.ChapterNumber;
import fr.jsmadja.antredesdragons.chapters.DiceWay;
import fr.jsmadja.antredesdragons.chapters.RollAndGoChapter;
import fr.jsmadja.antredesdragons.entities.Pip;

import java.util.List;

public class Chapter35 extends RollAndGoChapter {
    @Override
    protected List<DiceWay> getDiceWays(Pip pip) {
        return List.of(
                DiceWay.builder().from(2).to(6).chapterNumber(ChapterNumber.chapter(21)).build(),
                DiceWay.builder().from(7).to(12).chapterNumber(ChapterNumber.chapter(85)).build()
        );
    }

    @Override
    public String getText() {
        return "Lancez deux dés. Si vous faites : " +
                "de 2 à 6 : vous ne voyez aucun arbre qui pourrait faire l'affaire à proximité. Rendez-vous au [21], et faites un nouveau choix," +
                "de 7 à 12 : rendez-vous au [85].";
    }
}
