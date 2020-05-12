package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.ChapterNumber;
import fr.jsmadja.antredesdragons.core.chapters.DreamChapter;
import fr.jsmadja.antredesdragons.core.chapters.Execution;
import fr.jsmadja.antredesdragons.core.entities.Foe;
import fr.jsmadja.antredesdragons.core.entities.Pip;

public class DreamChapter3 extends DreamChapter {
    @Override
    public String getText() {
        return "Vous êtes pourchassé à travers un cimetière par un Vampire. Si l'abominable " +
                "monstre vous attrappe, c'en est fait de vous ! Déjà vos jambes flageolent à cette idée.\n" +
                "Pouvez-vous lui échapper ? Testez la Force du vampire en lançant deux dés. Testez " +
                "ensuite votre propre Force de la même façon. Comparez vos Forces respectives. Si le " +
                "Vampire a une Force de 5 points supérieures à la vôtre... rendez- vous au 14.";
    }

    @Override
    public Execution execute(Pip pip) {
        Foe foe = getFoeFactory().createVampire();
        if (foe.roll2Dices().getValue() - pip.roll2Dices().getValue() >= 5) {
            return pip.goTo(ChapterNumber.chapter(14));
        }
        return super.execute(pip);
    }
}
