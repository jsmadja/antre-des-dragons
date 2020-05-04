package fr.jsmadja.antredesdragons.pages;

import fr.jsmadja.antredesdragons.book.PageNumber;
import fr.jsmadja.antredesdragons.entities.Pip;

public abstract class GoPage extends Page {

    @Override
    public Execution execute(Pip pip) {
        beforeLeavingPage(pip);
        return pip.goToPage(PageNumber.page(getNextPage()));
    }

    protected void beforeLeavingPage(Pip pip) {
    }

    public abstract int getNextPage();

}
