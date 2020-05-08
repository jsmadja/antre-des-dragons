package fr.jsmadja.antredesdragons.core.chapters;

import fr.jsmadja.antredesdragons.core.entities.Pip;

public abstract class GoPreviousChapter extends Chapter {
    @Override
    public Execution execute(Pip pip) {
        this.beforeGoBack(pip);
        return pip.goToPreviousChapter();
    }

    protected abstract void beforeGoBack(Pip pip);
}
