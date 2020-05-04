package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.pages.GoPage;

public class Page8 extends GoPage {
    @Override
    public int getNextPage() {
        return 42;
    }

    @Override
    public String getText() {
        return "Toujours perdu dans le brouillard, Pip. Continuez à errer jusqu'à ce que vous arriviez au [42]";
    }
}
