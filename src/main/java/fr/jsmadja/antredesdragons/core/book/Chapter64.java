package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.GoNextChapter;

public class Chapter64 extends GoNextChapter {
    @Override
    public String getText() {
        return "I1 s'est levé ! Le brouillard s'est levé ! Qu'est-ce que vous en dites : votre fameux sens " +
                "de l'orientation n'était pas si mauvais après tout ! Maintenant rendez-vous au [58].";
    }

    @Override
    public int getNextChapter() {
        return 58;
    }
}
