package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.pages.GoBackPage;

public class Page15 extends GoBackPage {
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
