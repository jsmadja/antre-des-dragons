package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.pages.GoPage;

public class Page64 extends GoPage {
    @Override
    public String getText() {
        return "I1 s'est levé ! Le brouillard s'est levé ! Qu'est-ce que vous en dites : votre fameux sens " +
                "de l'orientation n' était pas si mauvais après tout ! Maintenant rendez-vous au [58].";
    }

    @Override
    public int getNextPage() {
        return 58;
    }
}
