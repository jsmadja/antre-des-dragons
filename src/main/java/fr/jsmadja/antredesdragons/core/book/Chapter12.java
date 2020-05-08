package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.GoNextChapter;

public class Chapter12 extends GoNextChapter {
    @Override
    public int getNextChapter() {
        return 23;
    }

    @Override
    public String getText() {
        return "Bravo, Pip, la magie devrait opérer, à condition que vous vous y preniez correctement. Rendez-vous au [23].";
    }
}
