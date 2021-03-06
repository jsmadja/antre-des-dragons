package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.ChapterNumber;
import fr.jsmadja.antredesdragons.core.chapters.DiceWay;
import fr.jsmadja.antredesdragons.core.chapters.RollAndGoChapter;
import fr.jsmadja.antredesdragons.core.entities.Pip;

import java.util.List;

public class Chapter58 extends RollAndGoChapter {
    @Override
    public String getText() {
        return "Il semble que vous approchiez d'une ville. Ou plutôt d'un village. La première chose " +
                "que vous remarquez, c'est le clocher de l'église puis, tandis que vous poursuivez " +
                "péniblement votre chemin, apparaissent les toits de chaume des chaumières. Le seul " +
                "problème, c'est que vous avez beau marcher, marcher, le village, pourtant bien visible, " +
                "reste toujours aussi éloigné. Il y a vraiment de la magie dans l'air. Mieux vaut lancer " +
                "dès maintenant vos dés, pour savoir s'il y a un moyen d'atteindre ce village." +
                "Si vous faites :\n" +
                "de 2 à 4 : rendez-vous au 9.\n" +
                "de 5 à 8 : rendez-vous au 13.\n" +
                "de 9 à 12 : rendez-vous au 19.";
    }

    @Override
    protected List<DiceWay> getDiceWays(Pip pip) {
        return List.of(
                new DiceWay(2, 4, ChapterNumber.chapter(9)),
                new DiceWay(5, 8, ChapterNumber.chapter(13)),
                new DiceWay(9, 12, ChapterNumber.chapter(19)));
    }
}
