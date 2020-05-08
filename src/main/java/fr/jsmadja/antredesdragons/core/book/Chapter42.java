package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.ManualChoiceChapter;
import fr.jsmadja.antredesdragons.core.entities.Pip;

public class Chapter42 extends ManualChoiceChapter {

    @Override
    public String getText() {
        return "Vous n'allez jamais le croire, Pip. Le soleil brille partout et Wanda la Vagabonde " +
                "vous pousse dans le dos avec son mufle, l'air stupide. Vous avez bouclé la boucle et " +
                "vous vous retrouvez à votre point de départ. Mieux vaut examiner à nouveau la carte " +
                "que Merlin vous a donnée et refaire une tentative ! Vous pouvez choisir n'importe " +
                "laquelle des sections indiquées pour reprendre le départ.";
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
