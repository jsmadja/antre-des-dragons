package fr.jsmadja.antredesdragons.chapters;

import fr.jsmadja.antredesdragons.entities.Pip;

public abstract class DeadlyChapter extends Chapter {
    @Override
    public Execution execute(Pip pip) {
        return pip.goTo(ChapterNumber.chapter(14));
    }
}
