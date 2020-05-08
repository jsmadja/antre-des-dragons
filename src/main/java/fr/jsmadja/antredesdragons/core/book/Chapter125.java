package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.GoNextChapter;

public class Chapter125 extends GoNextChapter {
    @Override
    public int getNextChapter() {
        return 10;
    }

    @Override
    public String getText() {
        return "Rendez-vous au 10.";
    }
}
