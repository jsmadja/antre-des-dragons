package fr.jsmadja.antredesdragons.pages.content;

import fr.jsmadja.antredesdragons.pages.types.GoPage;

public class Page12 extends GoPage {
    @Override
    protected int getNextPage() {
        return 23;
    }

    @Override
    public String getText() {
        return "Bravo, Pip, la magie devrait opérer, à condition que vous vous y preniez correctement. Rendez-vous au [23].";
    }
}
