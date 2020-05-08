package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.SingleFightChapter;
import fr.jsmadja.antredesdragons.core.entities.Foe;
import fr.jsmadja.antredesdragons.core.stuff.Item;

import static fr.jsmadja.antredesdragons.core.stuff.HealthPoints.hp;

public class Chapter104 extends SingleFightChapter {

    @Override
    public String getText() {
        return "On entend des bruissements dans le grain. Des bruissements accentués. Pouah ! ce " +
                "sont des rats ! Il doit y en avoir des centaines à en juger par le bruit. Mais non, pas du " +
                "tout ! Il n'y en a qu'un ! De la taille d'un chien-loup ! Il vous fixe un instant de ses yeux " +
                "roses, luisants, et ses dents sont aiguës comme des poignards. Attention, Pip, il va se " +
                "jeter sur vous ! Lancez rapidement les dés pour savoir si vous réussirez à le transpercer " +
                "de votre épée. Le Rat-Loup dispose de 25 POINTS DE VIE et ses morsures infligent 2 " +
                "Points de Dommage s'il sort un 5 ou davantage.\n" +
                "Si le Rat vous tue, rendez-vous au [14]. Si vous tuez le Rat, reprenez votre carte du " +
                "village de la Pierre-qui- mue et explorez un autre endroit. Mais ATTENTION : la " +
                "morsure du Rat provoque des maladies, et s'il a réussi a gagner un coup contre vous, " +
                "vous devez impérativement vous soigner avant de quitter le village, sinon vous êtes " +
                "condamné. Regardez avec soin dans toutes les chaumières. Il y a certainement " +
                "quelque potion curative rangée quelque part";
    }

    @Override
    protected int getSuccessChapter() {
        return 10;
    }

    @Override
    protected Foe getFoe() {
        Foe foe = Foe.builder()
                .name("Rat-Loup")
                .initialHealthPoints(hp(25))
                .build();
        foe.addAndEquip(Item.RAT_TEETH);
        return foe;
    }
}
