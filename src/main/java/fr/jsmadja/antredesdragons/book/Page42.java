package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.pages.ManualChoicePage;

public class Page42 extends ManualChoicePage {

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
                Path.builder().page(21).build(),
                Path.builder().page(65).build(),
                Path.builder().page(58).build(),
                Path.builder().page(155).build());
    }
}
