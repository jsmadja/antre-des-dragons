package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.chapters.GoNextChapter;

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
