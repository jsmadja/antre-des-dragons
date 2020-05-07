package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.chapters.GoNextChapter;

public class Chapter8 extends GoNextChapter {
    @Override
    public int getNextChapter() {
        return 42;
    }

    @Override
    public String getText() {
        return "Toujours perdu dans le brouillard, Pip. Continuez à errer jusqu'à ce que vous arriviez au [42]";
    }
}
