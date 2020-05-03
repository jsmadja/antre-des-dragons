package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.pages.ManualChoicePage;

public class Page43 extends ManualChoicePage {
    @Override
    public Paths getPossiblesPath(Pip pip) {
        return new Paths(
                Path.builder().description("Franchir la porte").page(92).build(),
                Path.builder().description("Retourner à la carte").page(10).build()
        );
    }

    @Override
    public String getText() {
        return "Ah, il semble que nous progressions ! Il existe une porte de derrière à cette chaumière. " +
                "Si vous décidez de franchir la porte du fond, rendez- vous au [92]. " +
                "Si vous préférez vous en abstenir, retournez à votre carte et reprenez votre exploration.";
    }
}
