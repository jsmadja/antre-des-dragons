package fr.jsmadja.antredesdragons.pages.content;

import fr.jsmadja.antredesdragons.pages.types.GoPage;

public class Page8 extends GoPage {
    @Override
    protected int getNextPage() {
        return 42;
    }

    @Override
    public String getText() {
        return "Toujours perdu dans le brouillard, Pip. Continuez à errer jusqu'à ce que vous arriviez au [42]";
    }
}
