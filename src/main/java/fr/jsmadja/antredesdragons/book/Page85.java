package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.pages.Execution;
import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.pages.Page;

public class Page85 extends Page {
    @Override
    public String getText() {
        return "Vous avez réussi ! Après toutes ces épreuves, vous avez réussi ! Vous avez franchi " +
                "l'abîme, sain et sauf. Rendez-vous au [16].";
    }

    @Override
    public Execution execute(Pip pip) {
        return pip.goToPage(PageNumber.page(16));
    }
}
