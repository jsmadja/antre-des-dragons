package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.chapters.GoPreviousChapter;

public class Chapter81 extends GoPreviousChapter {
    @Override
    public String getText() {
        return "C'est un refuge magique, Pip. Un endroit merveilleux en plus, bien qu'il soit " +
                "impossible à décrire disons simplement qu'une lumière bleue y brille à profusion. " +
                "Baignez-vous dans cette lumière, puis retournez au paragraphe que vous venez de\n" +
                "quitter, ayant récupéré tous vos POINTS DE VIE.";
    }

    @Override
    protected void beforeGoBack(Pip pip) {
        pip.restoreAllHealthPoints();
    }
}
