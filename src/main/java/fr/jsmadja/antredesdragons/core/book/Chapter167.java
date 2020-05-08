package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.GoNextChapter;
import fr.jsmadja.antredesdragons.core.entities.Pip;

public class Chapter167 extends GoNextChapter {
    @Override
    public String getText() {
        return "Vous venez de perdre votre arme. Elle est restée prisonnière des toiles d'araignées.\n" +
                "Retournez au [169] et faites une nouvelle tentative.";
    }

    @Override
    protected void beforeLeavingChapter(Pip pip) {
        super.beforeLeavingChapter(pip);
        if (pip.getEquipedWeapon().isPresent()) {
            pip.remove(pip.getEquipedWeapon().get());
        }
    }

    @Override
    public int getNextChapter() {
        return 169;
    }
}
