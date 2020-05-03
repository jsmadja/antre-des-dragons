package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.pages.GoPage;

public class Page125 extends GoPage {
    @Override
    protected int getNextPage() {
        return 10;
    }

    @Override
    public String getText() {
        return "Rendez-vous au 10.";
    }
}
