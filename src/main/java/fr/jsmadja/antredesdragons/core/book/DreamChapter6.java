package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.DreamChapter;
import fr.jsmadja.antredesdragons.core.entities.Pip;
import fr.jsmadja.antredesdragons.core.execution.Execution;

public class DreamChapter6 extends DreamChapter {
    @Override
    public String getText() {
        return "Vous marchez dans un superbe jardin clos par des murs, savourant la chaleur du " +
                "soleil, quand vous êtes attaqué par un essaim d'abeilles. Chaque piqûre d'abeille vous " +
                "coûte 1 POINT DE VIE. Lancez un dé pour savoir le nombre d'abeilles qui vont " +
                "réussir à vous piquer.";
    }

    @Override
    public Execution execute(Pip pip) {
        pip.wounds(pip.roll1Dice().toHealthPoints());
        return super.execute(pip);
    }
}
