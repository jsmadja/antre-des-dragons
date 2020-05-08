package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.chapters.DreamChapter;
import fr.jsmadja.antredesdragons.chapters.Execution;
import fr.jsmadja.antredesdragons.entities.Foe;
import fr.jsmadja.antredesdragons.entities.Pip;

import static fr.jsmadja.antredesdragons.chapters.ChapterNumber.chapter;

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
        Foe foe = Foe.builder()
                .name("Vampire")
                .build();
        if (foe.roll2Dices().getValue() - pip.roll2Dices().getValue() >= 5) {
            return pip.goTo(chapter(14));
        }
        return super.execute(pip);
    }
}
