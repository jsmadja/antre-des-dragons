package fr.jsmadja.antredesdragons.core.chapters;

import fr.jsmadja.antredesdragons.core.entities.Pip;

public abstract class DeadlyChapter extends Chapter {
    @Override
    public Execution execute(Pip pip) {
        return pip.goTo(ChapterNumber.chapter(14));
    }
}
