package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.dices.Roll;
import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.pages.Execution;
import fr.jsmadja.antredesdragons.pages.ManualChoicePage;
import fr.jsmadja.antredesdragons.stuff.Item;

import static fr.jsmadja.antredesdragons.stuff.Item.ROPE;

public class Page128 extends ManualChoicePage {
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
            return pip.goToPage(14);
        }
        if (pip.has(ROPE) && pip.has(Item.CLEATS)) {
            return super.execute(pip);
        }
        return pip.goToPage(14);
    }

    @Override
    public Paths getPossiblesPath() {
        return new Paths(
                Path.builder().description("Le chemin 120").page(120).build(),
                Path.builder().description("Le chemin 130").page(130).build()
        );
    }
}
