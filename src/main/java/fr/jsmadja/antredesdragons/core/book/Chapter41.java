package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.SingleFightChapter;
import fr.jsmadja.antredesdragons.core.entities.Foe;
import fr.jsmadja.antredesdragons.core.entities.Pip;
import fr.jsmadja.antredesdragons.core.execution.Execution;
import fr.jsmadja.antredesdragons.core.market.SilverCoins;

import static fr.jsmadja.antredesdragons.core.chapters.ChapterNumber.chapter;
import static fr.jsmadja.antredesdragons.core.inventory.Item.FOOD;
import static fr.jsmadja.antredesdragons.core.inventory.Item.THATCHED_CREATURE_DAGGERS;

public class Chapter41 extends SingleFightChapter {
    @Override
    protected int getSuccessChapter() {
        return 10;
    }

    @Override
    public Execution execute(Pip pip) {
        if (pip.has(FOOD)) {
            return pip.goToChapter2(chapter(getSuccessChapter()));
        }
        return super.execute(pip);
    }

    @Override
    protected void onAfterSuccessfulFight(Pip pip) {
        pip.add(THATCHED_CREATURE_DAGGERS);
        pip.addSilverCoins(SilverCoins.of(10));
        super.onAfterSuccessfulFight(pip);
    }

    @Override
    protected Foe createFoe() {
        return getFoeFactory().getThatchedCreature();
    }

    @Override
    public String getText() {
        return "Dites-moi, Pip : qu'est-ce qui est vert vif avec des dents rouges, se tient debout sur " +
                "deux jambes, et brandit une dague dans chaque main ? Non, je ne sais pas non plus. " +
                "Mais il existe une créature ainsi forte dans cette chaumière. Elle possède en outre 5 " +
                "POINTS DE VIE, et vous considère d'un air affamé. je suppose que vous n'avez pas " +
                "apporté de provisions de réserve, n'est-ce pas ? Si vous ne disposez que de peu de " +
                "nourriture, mieux vaut ne pas en proposer, car vous vous retrouveriez à un moment ou " +
                "à un autre, le ventre creux. Mais si vous avez un repas de réserve, la créature pourrait " +
                "souffrir d'une telle indigestion, une fois rassasiée, qu'elle ne vous importunerait jamais " +
                "plus. Si vous ne disposez pas de repas de réserve, vous devez, une fois de plus, livrer " +
                "combat. " +
                "Si vous êtes vainqueur, vous pouvez garder les dagues, ainsi que les 10 Pièces d'Argent " +
                "que vous trouverez dans la bourse de la créature (c'est peut etre bien une sorte de " +
                "kangourou vert et rouge porteur de dagues... ou alors un ornithorynque magique... ou " +
                "encore un très vieux nasique... A moins qu'il ne s'agisse d'un joueur de cricket " +
                "australien bizarrement déguisé... On ne le saura jamais). Puis, reprenez la carte du " +
                "village, et partez explorer un autre endroit. Si vous êtes vaincu... le [14] !";
    }
}
