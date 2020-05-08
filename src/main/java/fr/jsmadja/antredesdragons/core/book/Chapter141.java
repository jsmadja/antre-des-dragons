package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.SingleFightChapter;
import fr.jsmadja.antredesdragons.core.entities.Foe;
import fr.jsmadja.antredesdragons.core.entities.Pip;
import fr.jsmadja.antredesdragons.core.stuff.Item;

import static fr.jsmadja.antredesdragons.core.stuff.HealthPoints.hp;

public class Chapter141 extends SingleFightChapter {
    @Override
    protected int getSuccessChapter() {
        return 152;
    }

    @Override
    protected Foe getFoe() {
        Foe foe = Foe.builder()
                .name("Monstre")
                .initialHealthPoints(hp(80))
                .build();
        foe.addAndEquip(Item.MONSTER_CLAW);
        return foe;
    }

    @Override
    protected void onBeforeFight(Pip pip) {
        super.onBeforeFight(pip);
        pip.loseInitiative();
    }

    @Override
    public String getText() {
        return "Obscurité totale. Et, dans cette obscurité, quelque chose se jette sur vous. Une énorme " +
                "créature très agressive, et semble-t-il velue. Des crocs claquent à vous frôler la gorge. " +
                "Des griffes vous labourent la poitrine. Des grondements féroces vous font vibrer les " +
                "tympans. En somme, vous voilà avec un autre combat sur les bras. " +
                "Le Monstre (quoi d'autre?) dispose de 80 POINTS DE VIE. Il porte le premier coup " +
                "contre vous, et il lui suffit de faire 5, au minimum, pour vous toucher Chacun de ses " +
                "coups vous infligera 2 Points de Dommage supplémentaires. Défendez-vous, Pip !\n" +
                "Si le Monstre remporte le combat, rendez-vous au [14].\n" +
                "Si vous êtes vainqueur, rendez-vous au [152].";
    }
}
