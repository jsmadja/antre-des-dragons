package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.pages.GoPage;

public class Page77 extends GoPage {
    @Override
    protected int getNextPage() {
        return 21;
    }

    @Override
    public String getText() {
        return "Bien jugé, Pip. Rendez-vous au [21].";
    }
}
