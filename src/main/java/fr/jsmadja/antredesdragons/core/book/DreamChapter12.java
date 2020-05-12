package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.DreamChapter;
import fr.jsmadja.antredesdragons.core.chapters.Execution;
import fr.jsmadja.antredesdragons.core.dices.Roll;
import fr.jsmadja.antredesdragons.core.entities.Foe;
import fr.jsmadja.antredesdragons.core.entities.Pip;

public class DreamChapter12 extends DreamChapter {
    @Override
    public String getText() {
        return "Vous vous trouvez sur le sommet d'une haute montagne en pleine bataille magique " +
                "avec un malfaisant Sorcier qui occupe, lui, le sommet d'une montagne voisine. Dans " +
                "cette bataille, vous émettez l'un contre l'autre de puissantes ondes magiques de feu " +
                "bleuâtres. Tant que vous êtes deux à pratiquer ce bombardement réciproque d'ondes, " +
                "un effet magique les neutralise et les rend inoffensives. Mais, tôt ou tard, l'un de vous " +
                "va se trouver à court d'ondes. Lancez donc un dé pour savoir combien il reste d'ondes " +
                "au Sorcier votre ennemi, et un dé pour savoir combien il vous en reste à vous. Celui " +
                "des deux qui détient le plus grand nombre d'ondes divise par deux le total de POINTS " +
                "DE VIE de son adversaire et gagne la bataille.";
    }

    @Override
    public Execution execute(Pip pip) {
        Foe foe = getFoeFactory().createWickedSorcerer();
        Roll pipRoll = pip.roll1Dice();
        Roll sorcererRoll = foe.roll1Dice();
        if (pipRoll.isLesserThan(sorcererRoll)) {
            pip.wounds(pip.getCurrentHealthPoints() / 2);
        }
        return super.execute(pip);
    }
}
