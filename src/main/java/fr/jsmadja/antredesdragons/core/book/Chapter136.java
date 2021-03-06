package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.ManualChoiceChapter;
import fr.jsmadja.antredesdragons.core.entities.Foe;
import fr.jsmadja.antredesdragons.core.entities.Pip;
import fr.jsmadja.antredesdragons.core.execution.Execution;
import fr.jsmadja.antredesdragons.core.fight.Fight;
import fr.jsmadja.antredesdragons.core.market.GoldenCoins;

public class Chapter136 extends ManualChoiceChapter {

    protected Foe getFoe() {
        return getFoeFactory().createMedusa();
    }

    @Override
    protected void beforeLeavingChapter(Pip pip) {
        pip.add(GoldenCoins.of(200000));
        super.beforeLeavingChapter(pip);
    }

    @Override
    public Execution execute(Pip pip) {
        Fight fight = new Fight(pip, getFoe());
        fight.start();
        if (pip.isDead()) {
            return pip.goToChapter(14);
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
                "quand même vous vaincre, mais il lui faudra frapper trois coups d'affilée contre " +
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
                Path.builder().chapter(138).build(),
                Path.builder().chapter(128).build()
        );
    }
}
