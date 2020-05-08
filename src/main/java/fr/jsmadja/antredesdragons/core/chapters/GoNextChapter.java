package fr.jsmadja.antredesdragons.core.chapters;

import fr.jsmadja.antredesdragons.core.entities.Pip;

public abstract class GoNextChapter extends Chapter {

    @Override
    public Execution execute(Pip pip) {
        beforeLeavingChapter(pip);
        return pip.goTo(ChapterNumber.chapter(getNextChapter()));
    }

    protected void beforeLeavingChapter(Pip pip) {
    }

    public abstract int getNextChapter();

}
