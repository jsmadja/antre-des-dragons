package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.entities.Foe;
import fr.jsmadja.antredesdragons.pages.SingleFightPage;

import static fr.jsmadja.antredesdragons.stuff.Item.STONEMAN_SWORD;

public class Page23 extends SingleFightPage {
    @Override
    protected int getSuccessPage() {
        return 37;
    }

    @Override
    protected Foe getFoe() {
        Foe foe = Foe.builder().initialHealthPoints(28).build();
        foe.addAndEquip(STONEMAN_SWORD);
        return foe;
    }

    @Override
    public String getText() {
        return "L'Homme de Pierre possède 28 POINTS DE VIE. Il n'est pas très agile, et il lui faut donc\n" +
                "obtenir au minimum 8, avec les dés, pour vous frapper de son épée. En revanche, " +
                "cette épée vous infligera 4 Points de Dommage si elle vous touche. Bonne chance !\n" +
                "Si l'Homme de Pierre vous tue, rendez-vous au [14]. Mais si vous êtes vainqueur,\n" +
                "rendez-vous au [37]";
    }
}
