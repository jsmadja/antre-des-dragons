package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.DreamChapter;
import fr.jsmadja.antredesdragons.core.entities.Pip;
import fr.jsmadja.antredesdragons.core.execution.Execution;

import static fr.jsmadja.antredesdragons.core.dices.Roll.roll;

public class DreamChapter4 extends DreamChapter {
    @Override
    public String getText() {
        return "Vous êtes dans la grande salle de banquet d'un château. Cette salle est déserte. Sur la " +
                "table, devant vous, sont posés deux calices. L'un de cristal, l'autre de bronze. Dans l'un, " +
                "il y a du vin, dans l'autre du poison, mais vous n'avez aucun moyen de les distinguer " +
                "l'un de l'autre, et vous êtes obligé de boire le contenu de l'un d'eux. Tentez donc votre " +
                "chance en lançant deux dés. Si vous obtenez plus de six, vous avez assez de chance " +
                "pour choisir le bon calice. En revanche, si le chiffre que vous obtenez est inférieur ou  " +
                "égal à 6, vous avez bu le poison, auquel cas vous devez lancer encore deux dés et " +
                "soustraire ce que vous obtiendrez de votre total de POINTS DE VIE.";
    }

    @Override
    public Execution execute(Pip pip) {
        if (pip.roll2Dices().isLesserThan(roll(7))) {
            pip.wounds(pip.roll2Dices().toHealthPoints());
        }
        return super.execute(pip);
    }
}
