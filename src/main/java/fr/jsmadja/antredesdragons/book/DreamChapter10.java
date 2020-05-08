package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.chapters.FightDreamChapter;
import fr.jsmadja.antredesdragons.entities.Foe;
import fr.jsmadja.antredesdragons.entities.Pip;

import java.util.stream.IntStream;

import static fr.jsmadja.antredesdragons.dices.Roll.roll;
import static fr.jsmadja.antredesdragons.stuff.HealthPoints.hp;
import static fr.jsmadja.antredesdragons.stuff.Item.OGRE_CLUB;

public class DreamChapter10 extends FightDreamChapter {
    @Override
    public String getText() {
        return "Vous chassez le sanglier dans la forêt, armé d'un arc et de sept flèches. Chaque " +
                "flèche vous permet de marquer 10 Points de Dommage si elle frappe sa cible et il vous " +
                "faut obtenir plus de 6 avec deux dés pour l'atteindre. Vous entrez dans une clairière et " +
                "vous y découvrez un Ogre gigantesque sur le point de dévorer une ravissante jeune " +
                "fille. Vous avez le temps de tirer vos sept flèches avant que l'Ogre ne puisse vous " +
                "atteindre. L'Ogre a 40 POINTS DE VIE et il est si fort qu'il inflige 15 Points de " +
                "Dommage supplémentaires à chaque coup qu'il porte de son énorme massue. Vous " +
                "avez donc sept chances de le tuer avant qu'il ne vous touche et, comme il est très lent, " +
                "une chance supplémentaire de l'achever de vos mains nues avant qu'il n'abatte sur vous " +
                "son terrible gourdin.";
    }

    @Override
    protected void onBeforeFight(Pip pip, Foe foe) {
        super.onBeforeFight(pip, foe);
        IntStream.range(0, 7)
                .forEach(i -> {
                    if (pip.roll2Dices().isGreaterThan(roll(6))) {
                        foe.wounds(hp(10));
                    }
                });
        foe.loseInitiative();
    }

    @Override
    protected Foe getFoe() {
        Foe foe = Foe.builder()
                .name("Ogre gigantesque")
                .initialHealthPoints(hp(40))
                .build();
        foe.addAndEquip(OGRE_CLUB);
        return foe;
    }
}
