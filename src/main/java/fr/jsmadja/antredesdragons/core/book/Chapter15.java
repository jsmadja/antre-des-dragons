package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.GoPreviousChapter;
import fr.jsmadja.antredesdragons.core.entities.Pip;

public class Chapter15 extends GoPreviousChapter {
    @Override
    public String getText() {
        return "La décision que vous venez de prendre ne vaut rien dans ces circonstances. Retournez " +
                "d'où vous venez, et faites un nouveau choix. Mais vous perdez votre mordant, si bien " +
                "que c'est votre adversaire qui frappe le premier.";
    }

    @Override
    public void beforeGoBack(Pip pip) {
        pip.loseInitiative();
    }
}
