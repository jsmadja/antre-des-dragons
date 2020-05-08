package fr.jsmadja.antredesdragons.core.chapters;

import fr.jsmadja.antredesdragons.core.entities.Pip;

public abstract class DreamChapter {

    public abstract String getText();

    public Execution execute(Pip pip) {
        pip.setSleeping(false);
        return pip.goToPreviousChapter();
    }
}
