package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.ManualChoiceChapter;
import fr.jsmadja.antredesdragons.core.entities.Pip;

public class StartChapter extends ManualChoiceChapter {

    @Override
    public String getText() {
        return "";
    }

    @Override
    public Paths getPossiblesPath(Pip pip) {
        return new Paths(
                Path.builder().chapter(21).build(),
                Path.builder().chapter(58).build(),
                Path.builder().chapter(65).build(),
                Path.builder().chapter(155).build());
    }
}
