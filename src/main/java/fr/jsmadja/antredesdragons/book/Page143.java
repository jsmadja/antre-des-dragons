package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.dices.Roll;
import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.pages.Execution;
import fr.jsmadja.antredesdragons.pages.ManualChoicePage;

import static fr.jsmadja.antredesdragons.stuff.Item.MINOTAUR_KEY;

public class Page143 extends ManualChoicePage {
    @Override
    public String getText() {
        return "La cassette contient une grosse clef qui pourrait vous être utile si vous survivez à la " +
                "morsure du Serpent lové au fond du coffre n° 3. Lancez deux dés pour savoir si la " +
                "morsure du Serpent est mortelle.\n" +
                "Si vous faites :\n" +
                "de 2 à 5 : rendez-vous au [14].\n" +
                "de 6 à 12 : vous pouvez garder la clef, et vous ne perdez pas de POINTS DE VIE.\n" +
                "Comme l'avait prédit le Minotaure, les autres coffres ont disparu. Trois passages " +
                "permettent de sortir de cette caverne. Ils conduisent au [137], au [114] et au [128].\n" +
                "Choisissez bien !";
    }

    @Override
    public Execution execute(Pip pip) {
        pip.add(MINOTAUR_KEY);

        Roll roll = pip.roll2Dices();
        if (roll.isBetween(2, 5)) {
            return pip.goToPage(14);
        }
        return super.execute(pip);
    }

    @Override
    public Paths getPossiblesPath(Pip pip) {
        return new Paths(
                Path.builder().page(137).build(),
                Path.builder().page(114).build(),
                Path.builder().page(128).build()
        );
    }
}
