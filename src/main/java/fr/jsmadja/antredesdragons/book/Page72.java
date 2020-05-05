package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.pages.GoPage;

public class Page72 extends GoPage {
    @Override
    public int getNextPage() {
        return 10;
    }

    @Override
    public String getText() {
        return "C'est un bloc de pierre ! De pierre massive. Cette chaumière n'est pas du tout une " +
                "chaumière : c'est une énorme masse de pierre taillée en forme de chaumière et " +
                "recouverte d'un toit de chaume ! Une curiosité ! Reportez-vous à votre carte et " +
                "explorez une autre partie du village.";
    }
}