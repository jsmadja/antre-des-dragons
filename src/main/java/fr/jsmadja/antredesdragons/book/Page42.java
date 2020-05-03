package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.pages.GoPage;

public class Page42 extends GoPage {
    @Override
    protected int getNextPage() {
        return 10;
    }

    @Override
    public String getText() {
        return "Vous n'allez jamais le croire, Pip. Le soleil brille partout et Wanda la Vagabonde " +
                "vous pousse dans le dos avec son mufle, l'air stupide. Vous avez bouclé la boucle et " +
                "vous vous retrouvez à votre point de départ. Mieux vaut examiner à nouveau la carte " +
                "que Merlin vous a donnée et refaire une tentative ! Vous pouvez choisir n'importe " +
                "laquelle des sections indiquées pour reprendre le départ.";
    }
}
