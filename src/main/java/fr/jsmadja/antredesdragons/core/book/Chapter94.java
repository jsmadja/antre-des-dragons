package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.ChapterNumber;
import fr.jsmadja.antredesdragons.core.chapters.DiceWay;
import fr.jsmadja.antredesdragons.core.chapters.RollAndGoChapter;
import fr.jsmadja.antredesdragons.core.entities.Pip;

import java.util.List;

public class Chapter94 extends RollAndGoChapter {
    @Override
    protected List<DiceWay> getDiceWays(Pip pip) {
        return List.of(
                DiceWay.builder().from(2).to(4).chapterNumber(ChapterNumber.chapter(115)).build(),
                DiceWay.builder().from(5).to(8).chapterNumber(ChapterNumber.chapter(119)).build(),
                DiceWay.builder().from(9).to(12).chapterNumber(ChapterNumber.chapter(106)).build()
        );
    }

    @Override
    public String getText() {
        return "Avant que le roi Arthur n'ait chassé les Romains, un dicton courait dans le royaume " +
                "d'Avalon (qui, à cette époque, ne s'appelait pas, bien entendu, Avalon), qui disait : « " +
                "Au Vainqueur, les Dépouilles. » Ad victor spoilarum, ou une autre absurdité de ce " +
                "genre en latin.) Voilà un dicton qui s'applique parfaitement à vous, maintenant, car " +
                "vous avez sans aucun doute remporté une victoire en sabrant ces Moines macabres.\n" +
                "Alors, ne perdez pas un instant de plus : entrez dans l'abbaye, et fouillez, fouillez, " +
                "fouillez ! Lancez deux dés pour savoir ce que vous avez découvert. Si toutefois vous " +
                "avez découvert quelque chose.\n" +
                "Si vous faites : " +
                "de 2 à 4 : rendez-vous au [115].\n" +
                "de 5 à 8 : rendez-vous au [119].\n" +
                "de 9 à 12 : rendez-vous au [106].";
    }
}
