package fr.jsmadja.antredesdragons.pages;

import fr.jsmadja.antredesdragons.book.PageNumber;
import fr.jsmadja.antredesdragons.entities.Pip;

public abstract class DeadlyPage extends Page {
    @Override
    public Execution execute(Pip pip) {
        return pip.goToPage(PageNumber.page(14));
    }
}
