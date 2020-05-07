package fr.jsmadja.antredesdragons.chapters;

import fr.jsmadja.antredesdragons.book.ChapterNumber;
import fr.jsmadja.antredesdragons.entities.Pip;

public abstract class DeadlyChapter extends Chapter {
    @Override
    public Execution execute(Pip pip) {
        return pip.goToChapter(ChapterNumber.chapter(14));
    }
}
