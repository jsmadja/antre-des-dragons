package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.dices.HitRollRange;
import fr.jsmadja.antredesdragons.entities.Foe;
import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.pages.SingleFightPage;
import fr.jsmadja.antredesdragons.stuff.Item;

public class Page67 extends SingleFightPage {
    @Override
    protected int getSuccessPage() {
        return 10;
    }

    @Override
    protected Foe getFoe() {
        Foe foe = Foe.builder().name("Monstre de Pierre").initialHealthPoints(18).hitRollRange(new HitRollRange(7)).build();
        foe.addAndEquip(Item.STONEMONSTER_ARMOR);
        return foe;
    }

    @Override
    protected void onBeforeFight(Pip pip) {
        getFoe().loseInitiative();
        pip.setForcedMinimumHitRoll(new HitRollRange(8));
        super.onBeforeFight(pip);
    }

    @Override
    protected void onAfterSuccessfulFight(Pip pip) {
        pip.setForcedMinimumHitRoll(null);
        super.onAfterSuccessfulFight(pip);
    }

    @Override
    public String getText() {
        return "— Soyez le bienvenu, déclare le Monstre, qui a manifestement remarqué que vous " +
                "vous transformiez petit à petit en pierre. Nous avons réservé un emplacement de choix " +
                "où nous vous placerons dés que vous serez complètement pétrifié. Là-bas vers le sud, " +
                "où vous aurez bien chaud. Vous n'allez pas supporter ça, n'est-ce pas ? Par un suprême " +
                "effort de volonté, vous dégainez votre épée et vous la brandissez. Vous allez vous " +
                "battre pour vous tirer de là, même si vous devez y laisser la vie. Le Monstre de Pierre " +
                "ne dispose pas de tellement de POINTS DE VIE puisqu'il est déjà à moitié mort : 18 " +
                "seulement pour être exact. Et il a besoin de sortir un 7, ou plus, pour réussir à vous " +
                "frapper. De plus, vos efforts démesurés vous ont donné droit au premier coup. En " +
                "revanche, vous êtes plus ou moins à moitié mort vous aussi, vous n'êtes donc pas dans " +
                "de bonnes conditions pour vous battre. Il vous faut sortir un 8 ou davantage pour " +
                "frapper durant ce combat et, comme le Monstre est en pierre, vous devez déduire 1 " +
                "point de tous les Points de Dommage que vous lui infligerez. Mais enfin, la chance " +
                "peut vous sourire.\n" +
                "Si le Monstre vous tue, rendez-vous au [14]. Si vous réussissez à tuer le Monstre, vous " +
                "pouvez vous traîner hors du jardin de pierre et, à ce moment-là, la paralysie qui vous " +
                "envahissait petit à petit se dissipera. Reprenez votre carte et explorez une partie du " +
                "village moins dangereuse.";
    }
}
