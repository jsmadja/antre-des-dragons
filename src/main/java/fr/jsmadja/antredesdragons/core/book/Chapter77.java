package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.GoNextChapter;

public class Chapter77 extends GoNextChapter {
    @Override
    public int getNextChapter() {
        return 21;
    }

    @Override
    public String getText() {
        return "Bien jugé, Pip. Rendez-vous au [21].";
    }
}
