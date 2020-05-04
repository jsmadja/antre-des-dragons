package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.pages.GoPage;

import static fr.jsmadja.antredesdragons.stuff.Item.PARTIAL_MAP_OF_THE_DRAGONS_LAIR;

public class Page106 extends GoPage {
    @Override
    public int getNextPage() {
        return 10;
    }

    @Override
    protected void beforeLeavingPage(Pip pip) {
        pip.add(PARTIAL_MAP_OF_THE_DRAGONS_LAIR);
        super.beforeLeavingPage(pip);
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
