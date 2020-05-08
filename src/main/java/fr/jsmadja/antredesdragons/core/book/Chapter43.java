package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.ManualChoiceChapter;
import fr.jsmadja.antredesdragons.core.entities.Pip;

public class Chapter43 extends ManualChoiceChapter {
    @Override
    public Paths getPossiblesPath(Pip pip) {
        return new Paths(
                Path.builder().description("Franchir la porte").chapter(92).build(),
                Path.builder().description("Retourner à la carte").chapter(10).build()
        );
    }

    @Override
    public String getText() {
        return "Ah, il semble que nous progressions ! Il existe une porte de derrière à cette chaumière. " +
                "Si vous décidez de franchir la porte du fond, rendez- vous au [92]. " +
                "Si vous préférez vous en abstenir, retournez à votre carte et reprenez votre exploration.";
    }
}
