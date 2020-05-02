package fr.jsmadja.antredesdragons.pages.types;

import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.pages.content.PageNumber;

public abstract class GoPage extends Page {

    @Override
    public Execution execute(Pip pip) {
        return pip.goToPage(PageNumber.page(getNextPage()));
    }

    protected abstract int getNextPage();

}
