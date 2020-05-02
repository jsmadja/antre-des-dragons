package fr.jsmadja.antredesdragons.pages.types;

import fr.jsmadja.antredesdragons.entities.Pip;

public abstract class GoBackPage extends Page {
    @Override
    public Execution execute(Pip pip) {
        this.doSomething(pip);
        return pip.goToPreviousPage();
    }

    protected abstract void doSomething(Pip pip);
}
