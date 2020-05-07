package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.chapters.GoNextChapter;

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
