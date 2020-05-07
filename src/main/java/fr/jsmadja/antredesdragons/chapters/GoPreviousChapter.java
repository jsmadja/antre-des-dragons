package fr.jsmadja.antredesdragons.chapters;

import fr.jsmadja.antredesdragons.entities.Pip;

public abstract class GoPreviousChapter extends Chapter {
    @Override
    public Execution execute(Pip pip) {
        this.beforeGoBack(pip);
        return pip.goToPreviousChapter();
    }

    protected abstract void beforeGoBack(Pip pip);
}
