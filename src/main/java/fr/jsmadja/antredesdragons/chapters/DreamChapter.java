package fr.jsmadja.antredesdragons.chapters;

import fr.jsmadja.antredesdragons.entities.Pip;

public abstract class DreamChapter {

    public abstract String getText();

    public Execution execute(Pip pip) {
        pip.setSleeping(false);
        return pip.goToPreviousChapter();
    }
}
