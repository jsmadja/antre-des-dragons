package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.entities.Foe;
import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.fight.Fight;
import fr.jsmadja.antredesdragons.market.GoldenCoins;
import fr.jsmadja.antredesdragons.pages.Execution;
import fr.jsmadja.antredesdragons.pages.ManualChoicePage;

import static fr.jsmadja.antredesdragons.stuff.Item.MEDUSA_WEAPON;

public class Page136 extends ManualChoicePage {

    protected Foe getFoe() {
        Foe foe = Foe.builder()
                .name("Méduse")
                .initialHealthPoints(100)
                .instantKillWithStrikesInARow(2)
                .requiredStrikesToHitInvisible(3)
                .build();
        foe.addAndEquip(MEDUSA_WEAPON);
        return foe;
    }

    @Override
    protected void beforeLeavingPage(Pip pip) {
        pip.add(GoldenCoins.of(200000));
        super.beforeLeavingPage(pip);
    }

    @Override
    public Execution execute(Pip pip) {
        Fight fight = new Fight(pip, getFoe());
        fight.start();
        if (pip.isDead()) {
            return pip.goToPage(14);
        }
        return super.execute(pip);
    }

    @Override
    public String getText() {
        return "Quelle courageuse décision ! Un peu intéressée, peut-être, mais courageuse.\n" +
                "Maintenant, passons aux mauvaises nouvelles. La Méduse dispose de 100 POINTS " +
                "DE VIE. Elle peut vous transformer en pierre chaque fois qu'elle frappe deux " +
                "coups d'affilée contre vous. Il lui faut faire au minimum 8 pour frapper un coup. Si " +
                "vous décidez d'utiliser votre sortilège INVISIBILITÉ durant ce combat, elle peut " +
                "quand même vous vaincre, mais il lui faudra frapper Trois coups d'affilée contre " +
                "vous. Bonne chance !\n" +
                "Si la Méduse vous tue, rendez-vous au [14]. Si vous tuez la Méduse, vous " +
                "constaterez que vous pouvez facilement porter un trésor qui vaut 200 000 Pièces " +
                "d'Or.\n" +
                "Deux passages permettent de sortir de cette grotte. Ils conduisent au [138] et au [128].\n" +
                "Choisissez bien !";
    }

    @Override
    public Paths getPossiblesPath(Pip pip) {
        return new Paths(
                Path.builder().page(138).build(),
                Path.builder().page(128).build()
        );
    }
}
