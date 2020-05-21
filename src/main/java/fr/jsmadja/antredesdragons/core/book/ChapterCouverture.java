package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.GoNextChapter;

import static fr.jsmadja.antredesdragons.core.book.Book.DEBUT;

public class ChapterCouverture extends GoNextChapter {
    @Override
    public int getNextChapter() {
        return DEBUT;
    }

    @Override
    public String getText() {
        return "";
    }
}
