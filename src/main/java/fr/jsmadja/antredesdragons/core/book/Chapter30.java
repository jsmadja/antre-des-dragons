package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.ChapterNumber;
import fr.jsmadja.antredesdragons.core.chapters.DiceWay;
import fr.jsmadja.antredesdragons.core.chapters.RollAndGoChapter;
import fr.jsmadja.antredesdragons.core.entities.Pip;

import java.util.List;

public class Chapter30 extends RollAndGoChapter {
    @Override
    public String getText() {
        return "On dirait les vestiges d'une tour de guet en pierre. Très, très ancienne. En ruine " +
                "maintenant, bien entendu. La presque totalité de la tour s'est écroulée et le sol est " +
                "jonché de pierres et de gravats. Vous pourriez perdre votre temps ici indéfiniment, " +
                "vous tordant les chevilles sur les cailloux. Pourquoi ne pas lancer deux dés pour voir " +
                "ce que le sort réserve à un intrépide aventurier dans cet endroit.\n" +
                "Si vous faites :\n" +
                "de 2 à 6 : rendez-vous au [80].\n" +
                "de 7 à 12 : rendez-vous au [88].";
    }

    @Override
    protected List<DiceWay> getDiceWays(Pip pip) {
        return List.of(new DiceWay(2, 6, ChapterNumber.chapter(80)), new DiceWay(7, 12, ChapterNumber.chapter(88)));
    }
}
