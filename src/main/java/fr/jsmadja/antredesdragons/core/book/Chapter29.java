package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.ManualChoiceChapter;
import fr.jsmadja.antredesdragons.core.entities.Pip;

public class Chapter29 extends ManualChoiceChapter {

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
                Path.builder().chapter(21).build(),
                Path.builder().chapter(65).build(),
                Path.builder().chapter(58).build(),
                Path.builder().chapter(155).build());
    }
}
