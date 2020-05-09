package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.GoNextChapter;
import fr.jsmadja.antredesdragons.core.entities.Pip;
import fr.jsmadja.antredesdragons.core.inventory.Item;

public class Chapter106 extends GoNextChapter {
    @Override
    public int getNextChapter() {
        return 10;
    }

    @Override
    protected void beforeLeavingChapter(Pip pip) {
        pip.add(Item.PARTIAL_MAP_OF_THE_DRAGONS_LAIR);
        super.beforeLeavingChapter(pip);
    }

    @Override
    public String getText() {
        return "Quelle trouvaille ! Quelle trouvaille ! C'est une carte de Antre du Dragon ! Du " +
                "moins, un fragment de carte. Quand vous atteindrez la caverne, si vous l'atteignez " +
                "jamais, vous pourrez vous reporter à ce document pour trouver votre chemin. Il " +
                "n'indique pas 1’entrée, mais il décrit le labyrinthe et peut en conséquence, vous " +
                "sauver la vie. La carte figure 'sur la page ci-contre. Vous pouvez la consulter à n'importe quel moment après avoir quitté l'abbaye Reprenez maintenant la carte du " +
                "village et poursuivez vos explorations.";
    }
}
