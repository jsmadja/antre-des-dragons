package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.GoNextChapter;

public class Chapter70 extends GoNextChapter {
    @Override
    public int getNextChapter() {
        return 10;
    }

    @Override
    public String getText() {
        return "La chance vous sourit, Pip. Vous trébuchez en reculant jusqu'à ce que vos pieds " +
                "atteignent la limite du jardin de pierre. Aussitôt le Monstre se fige sur place, alors que " +
                "vous-même, en revanche, cessez de vous transformer en pierre. Vous l'avez échappé " +
                "belle ! Reprenez votre carte et explorez une partie moins dangereuse du village.";
    }
}
