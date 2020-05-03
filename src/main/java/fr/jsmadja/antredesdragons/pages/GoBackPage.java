package fr.jsmadja.antredesdragons.pages;

import fr.jsmadja.antredesdragons.entities.Pip;

public abstract class GoBackPage extends Page {
    @Override
    public Execution execute(Pip pip) {
        this.beforeGoBack(pip);
        return pip.goToPreviousPage();
    }

    protected abstract void beforeGoBack(Pip pip);
}
