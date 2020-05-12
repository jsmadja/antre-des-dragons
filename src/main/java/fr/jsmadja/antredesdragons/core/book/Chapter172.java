package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.SingleFightChapter;
import fr.jsmadja.antredesdragons.core.entities.Foe;

public class Chapter172 extends SingleFightChapter {
    @Override
    protected int getSuccessChapter() {
        return 173;
    }

    @Override
    protected Foe createFoe() {
        return getFoeFactory().createBronzeDragoon();
    }

    @Override
    public String getText() {
        return "Au moment où vous atteignez le dernier degré, le Dragon de Bronze se dresse " +
                "brusquement. Malgré son corps massif, cette créature se meut avec une agilité " +
                "terrifiante. Il vous domine de toute sa taille, ses yeux d'ambre étincelant de haine... et " +
                "d'intelligence. Dragon peut-être, mais pas de l'espèce ordinaire des lézards cracheurs " +
                "de feu. C'est là un être pétri de force, de puissance, de ruse. Maintenant que vous vous " +
                "trouvez enfin face à face avec lui, vous comprenez que la légende l'ait fait naître en " +
                "Enfer. Une aura de puissance magique l'entoure, une aura maléfique. Toute votre " +
                "force, votre habileté, votre ingéniosité, tous les sortilèges qui vous restent doivent être " +
                "jetés dans le combat qui se prépare si vous voulez avoir la moindre chance de vaincre. " +
                "Le Dragon de Bronze dispose de 150 POINTS DE VIE, beaucoup plus que vous-même. Il frappe s'il obtient au minimum 5 et vous infligera 5 Points de Dommage " +
                "supplémentaires à chaque fois qu'il réussira à vous atteindre d'un croc ou d'une griffe. " +
                "Tous les trois coups, il crache un jet de feu bleu et or qui, s'il vous touche, vous inflige " +
                "10 Points de Dommage. Vous pouvez utiliser tous vos sortilèges contre lui. " +
                "L'INVISIBILITE n'a qu'une efficacité limitée dans la mesure où le Dragon peut quand " +
                "même sentir votre présence, mais il lui faut alors obtenir au minimum 8 pour vous " +
                "frapper pendant que vous demeurez invisible. Allez-y, Pip, et ne vous perdez pas dans " +
                "vos comptes !\n" +
                "Si le Dragon de Bronze vous tue, rendez-vous au [14]. Si vous tuez le Dragon de " +
                "Bronze, rendez-vous au [173].";
    }
}
