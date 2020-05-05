package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.pages.DiceWay;
import fr.jsmadja.antredesdragons.pages.RollAndGoPage;

import java.util.List;

public class Page94 extends RollAndGoPage {
    @Override
    protected List<DiceWay> getDiceWays(Pip pip) {
        return List.of(
                DiceWay.builder().from(2).to(4).pageNumber(PageNumber.page(115)).build(),
                DiceWay.builder().from(5).to(8).pageNumber(PageNumber.page(119)).build(),
                DiceWay.builder().from(9).to(12).pageNumber(PageNumber.page(106)).build()
        );
    }

    @Override
    public String getText() {
        return "Avant que le roi Arthur n'ait chassé les Romains, un dicton courait dans le royaume " +
                "d'Avalon (qui, à cette époque, ne s'appelait pas, bien entendu, Avalon), qui disait : « " +
                "Au Vainqueur, les Dépouilles. » Ad victor spoilarum, ou une autre absurdité de ce " +
                "genre en latin.) Voilà un dicton qui s'applique parfaitement à vous, maintenant, car " +
                "vous avez sans aucun doute remporté une victoire en sabrant ces Moines macabres.\n" +
                "Alors, ne perdez pas un instant de plus : entrez dans l'abbaye, et fouillez, fouillez, " +
                "fouillez ! Lancez deux dés pour savoir ce que vous avez découvert. Si toutefois vous " +
                "avez découvert quelque chose.\n" +
                "Si vous faites : " +
                "de 2 à 4 : rendez-vous au [115].\n" +
                "de 5 à 8 : rendez-vous au [119].\n" +
                "de 9 à 12 : rendez-vous au [106].";
    }
}
