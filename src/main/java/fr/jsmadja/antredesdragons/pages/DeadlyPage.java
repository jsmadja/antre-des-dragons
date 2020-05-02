package fr.jsmadja.antredesdragons.pages;

import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.book.PageNumber;

public abstract class DeadlyPage extends Page {
    @Override
    public Execution execute(Pip pip) {
        return pip.goToPage(PageNumber.page(14));
    }
}
