package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.Chapter;
import fr.jsmadja.antredesdragons.core.entities.Foe;
import fr.jsmadja.antredesdragons.core.entities.Pip;
import fr.jsmadja.antredesdragons.core.execution.Execution;
import fr.jsmadja.antredesdragons.core.fight.Fight;
import fr.jsmadja.antredesdragons.core.inventory.Item;

import java.util.Optional;

public class Chapter123 extends Chapter {
    @Override
    public String getText() {
        return "Vous vous déshabillez avec soin, et vous faites un paquet de vos vêtements, avant de " +
                "plonger dans les eaux glacées du lac souterrain pour vous retrouver dans la gueule d'un " +
                "énorme Poisson qui rôdait dans les profondeurs ! " +
                "la situation est délicate. Cette brave E.J. est ficelée dans le paquet, et il vous faut " +
                "essayer d'étrangler ce poisson de vos mains nues. Ou de l'assommer, ou d'en venir à " +
                "bout d'une façon quelconque. Il ne possède que 10 POINTS DE VIE et la tâche ne " +
                "devrait pas etre trop difficile ; mais le problème, c'est que vous etes au fond de l'eau, " +
                "autrement dit, il va falloir vous debarrasser du Poisson en trois coups, sinon vous allez " +
                "vous noyer. Pendant ce temps-là, le Poisson s acharnera à vous mordre, ce qui n'est " +
                "guère bénéfique pour vos POINTS DE VIE. " +
                "Si vous réussissez à assommer ou à tuer le Poisson en trois coups, rendez-vous au [124]. " +
                "Sinon, il y a toujours le [14].";
    }

    @Override
    public Execution execute(Pip pip) {
        Optional<Item> weapon = pip.getEquipedWeapon();
        weapon.ifPresent(pip::unequip);
        Foe foe = getFoeFactory().createFish();

        new Fight(pip, foe, 3).start();

        if (pip.isDead()) {
            return pip.goToChapter(14);
        }
        weapon.ifPresent(pip::equip);
        return pip.goToChapter(124);
    }
}
