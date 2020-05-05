package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.pages.GoPage;

public class Page167 extends GoPage {
    @Override
    public String getText() {
        return "Vous venez de perdre votre arme. Elle est restée prisonnière des toiles d'araignées.\n" +
                "Retournez au [169] et faites une nouvelle tentative.";
    }

    @Override
    protected void beforeLeavingPage(Pip pip) {
        super.beforeLeavingPage(pip);
        if (pip.getEquipedWeapon().isPresent()) {
            pip.remove(pip.getEquipedWeapon().get());
        }
    }

    @Override
    public int getNextPage() {
        return 169;
    }
}
