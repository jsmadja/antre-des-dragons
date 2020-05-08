package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.SingleFightChapter;
import fr.jsmadja.antredesdragons.core.entities.Foe;
import fr.jsmadja.antredesdragons.core.entities.Pip;
import fr.jsmadja.antredesdragons.core.market.GoldenCoins;
import fr.jsmadja.antredesdragons.core.stuff.Item;

import static fr.jsmadja.antredesdragons.core.stuff.HealthPoints.hp;

public class Chapter50 extends SingleFightChapter {
    @Override
    protected int getSuccessChapter() {
        return 10;
    }

    @Override
    protected Foe getFoe() {
        Foe foe = Foe.builder().name("Loup").initialHealthPoints(hp(31)).build();
        foe.addAndEquip(Item.WOLF_SKIN);
        return foe;
    }

    @Override
    protected void onBeforeFight(Pip pip) {
        pip.loseInitiative();
        super.onBeforeFight(pip);
    }

    @Override
    protected void onAfterSuccessfulFight(Pip pip) {
        pip.add(GoldenCoins.of(100));
        super.onAfterSuccessfulFight(pip);
    }

    @Override
    public String getText() {
        return "Grrrrrr !\n" +
                "Quel bruit affreux à entendre quand vous ouvrez la porte d'une chaumière, Pip. Il fait " +
                "sombre à l'intérieur, et pendant un moment, vous ne distinguez que deux yeux rouges " +
                "aux reflets sauvages. Le Loup vous saute alors à la gorge ! Il est gigantesque — 31 " +
                "POINTS DE VIE — et ses crocs infligent 3 Points de Dommage. Bénéficiant de l'effet de " +
                "surprise, il frappe également le premier. En outre, son épaisse fourrure lui tient lieu " +
                "d'armure en un sens, ce qui retire 1 point à tous les Points de Dommage que vous " +
                "pouvez lui infliger. Lancez les dès. Vous avez un autre combat sur les bras. " +
                "si le Loup vous tue, rendez-vous au [14]. Si vous tuez le Loup, vous aller trouver dans la " +
                "chaumière un coffret contenant 100 Pièces d'Or, prenez-le, retournez à votre carte et " +
                "explorez une autre section du village";
    }
}
