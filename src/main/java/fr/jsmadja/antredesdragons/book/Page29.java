package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.pages.ManualChoicePage;

public class Page29 extends ManualChoicePage {

    @Override
    public String getText() {
        return "C'est absolument impensable, Pip, et pourtant, c'est bien ce qui est arrivé. Vous avez " +
                "suivi ses directives à la lettre... et maintenant vous vous retrouvez à votre point de " +
                "départ, avec Wanda la Vagabonde qui vous regarde avec stupeur. Pas d'autre solution " +
                "que de sortir votre carte et de repartir à zéro. Mais une partie de l'itinéraire au moins " +
                "vous est maintenant familier, et vous avez peut-être appris à éviter certains des pires " +
                "dangers.";
    }

    @Override
    public Paths getPossiblesPath(Pip pip) {
        return new Paths(
                Path.builder().page(21).build(),
                Path.builder().page(65).build(),
                Path.builder().page(58).build(),
                Path.builder().page(155).build());
    }
}
