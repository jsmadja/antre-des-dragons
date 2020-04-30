package fr.jsmadja.antredesdragons.pages.types;

import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.pages.content.PageNumber;

public abstract class DeadlyPage extends Page {
    @Override
    public Execution execute(Pip pip) {
        return pip.goToPage(PageNumber.of(14));
    }
}