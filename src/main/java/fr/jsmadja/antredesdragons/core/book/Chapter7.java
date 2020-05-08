package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.ManualChoiceChapter;
import fr.jsmadja.antredesdragons.core.entities.Pip;

import static fr.jsmadja.antredesdragons.core.stuff.Item.CLEATS;
import static fr.jsmadja.antredesdragons.core.stuff.Item.ROPE;

public class Chapter7 extends ManualChoiceChapter {
    @Override
    public String getText() {
        return "Et vous décidez d'utiliser votre hache pour abattre un arbre qui pourrait faire un pont convenable en " +
                "travers du gouffre, rendez-vous au [35]. Si vous décidez de vous servir d'une corde ou de crampons pour" +
                " descendre cette falaise verticale, rendez-vous au [27].";
    }

    @Override
    public Paths getPossiblesPath(Pip pip) {
        if (pip.has(ROPE) || pip.has(CLEATS)) {
            return new Paths(
                    Path.builder().chapter(35).description("Utiliser le pont").build(),
                    Path.builder().chapter(27).description("Utiliser une corde").build());
        }
        return new Paths(Path.builder().chapter(35).description("Utiliser le pont").build());
    }
}
