package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.Execution;
import fr.jsmadja.antredesdragons.core.chapters.ManualChoiceChapter;
import fr.jsmadja.antredesdragons.core.dices.Roll;
import fr.jsmadja.antredesdragons.core.entities.Pip;
import fr.jsmadja.antredesdragons.core.inventory.Item;

public class Chapter128 extends ManualChoiceChapter {
    @Override
    public String getText() {
        return "Le cœur léger, vous avancez gaiement le long du passage jusqu'au moment où vous " +
                "tombez dans une fosse. " +
                "lancez deux dés pour déterminer le dommage provoqué par cette chute. Soustrayez le " +
                "résultat des POINTS DE VIE dont vous disposez. Si cela vous tue, rendez-vous au [14]. " +
                "Si vous avez une corde et des crampons dans votre équipement, vous pouvez les " +
                "utiliser pour ressortir de la fosse. Sinon, vous y resterez à jamais. A jamais ? Non ! " +
                "Rendez-vous au [14]. Si vous sortez de la fosse, vous poursuivez votre chemin. Le " +
                "passage dans lequel vous vous trouvez conduit au [120] dans un sens, et au [130] dans " +
                "l'autre.";
    }

    @Override
    public Execution execute(Pip pip) {
        Roll roll = pip.roll2Dices();
        pip.wounds(roll.getValue());
        if (pip.isDead()) {
            return pip.goToChapter(14);
        }
        if (pip.has(Item.ROPE) && pip.has(Item.CLEATS)) {
            return super.execute(pip);
        }
        return pip.goToChapter(14);
    }

    @Override
    public Paths getPossiblesPath(Pip pip) {
        return new Paths(
                Path.builder().description("Le chemin 120").chapter(120).build(),
                Path.builder().description("Le chemin 130").chapter(130).build()
        );
    }
}
