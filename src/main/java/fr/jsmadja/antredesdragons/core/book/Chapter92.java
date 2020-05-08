package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.GoNextChapter;

public class Chapter92 extends GoNextChapter {
    @Override
    public int getNextChapter() {
        return 8;
    }

    @Override
    public String getText() {
        return "Vous franchissez la porte, pour émerger dans le brouillard. Aussitôt, vous faites volteface, mais bien que vous ayez réagi à la vitesse de l'éclair, il est déjà trop tard. La " +
                "porte a disparu. Vous tâtonnez sans succès dans le brouillard. Vous tâtonnez pendant " +
                "très, très longtemps. Rendez-vous au [8].";
    }
}
