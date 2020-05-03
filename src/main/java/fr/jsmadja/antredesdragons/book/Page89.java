package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.pages.GoPage;

public class Page89 extends GoPage {
    @Override
    protected int getNextPage() {
        return 41;
    }

    @Override
    public String getText() {
        return "Rendez-vous directement au [41].";
    }
}
