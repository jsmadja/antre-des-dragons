package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.chapters.Execution;
import fr.jsmadja.antredesdragons.chapters.Chapter;

public class Chapter85 extends Chapter {
    @Override
    public String getText() {
        return "Vous avez réussi ! Après toutes ces épreuves, vous avez réussi ! Vous avez franchi " +
                "l'abîme, sain et sauf. Rendez-vous au [16].";
    }

    @Override
    public Execution execute(Pip pip) {
        return pip.goToChapter(ChapterNumber.chapter(16));
    }
}
