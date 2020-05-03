package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.pages.ManualChoicePage;

import static fr.jsmadja.antredesdragons.stuff.Item.CLEATS;
import static fr.jsmadja.antredesdragons.stuff.Item.ROPE;

public class Page7 extends ManualChoicePage {
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
                    Path.builder().page(35).description("Utiliser le pont").build(),
                    Path.builder().page(27).description("Utiliser une corde").build());
        }
        return new Paths(Path.builder().page(35).description("Utiliser le pont").build());
    }
}
