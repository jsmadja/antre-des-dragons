package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.pages.GoPage;

public class Page119 extends GoPage {
    @Override
    public int getNextPage() {
        return 10;
    }

    @Override
    public String getText() {
        return "Rien. Vous ne trouvez strictement rien. Au diable les stupides dictons romains sur les " +
                "vainqueurs et les dépouilles. Nihil ad victor, comme disaient les Romains les plus " +
                "sensés : du vent pour le Vainqueur ! En maugréant, vous consultez une fois de plus la " +
                "carte du village pour décider où vous allez maintenant porter vos pas.";
    }
}
