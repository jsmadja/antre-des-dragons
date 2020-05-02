package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.pages.Execution;
import fr.jsmadja.antredesdragons.pages.GoPage;
import fr.jsmadja.antredesdragons.stuff.Item;
import fr.jsmadja.antredesdragons.ui.Events;

import java.util.List;
import java.util.stream.Collectors;

import static fr.jsmadja.antredesdragons.stuff.Item.*;

public class Page73 extends GoPage {
    @Override
    public String getText() {
        return "Voilà qui est un peu mieux, Pip. Guère mieux, mais quand même. Les arbres semblent " +
                "un peu moins denses par ici... Allons bon, voilà que vous tombez sur un Troll. Quel " +
                "vilain petit bonhomme, en plus. Les bois en sont pleins à cette époque de l'année, cela " +
                "n'a donc rien de bien surprenant, mais cela n'en est pas moins fâcheux, les Trolls étant " +
                "ce qu'ils sont. Les Trolls des Bois en tout cas. Ils sont parfaitement immunisés au " +
                "métal, il est donc inutile de les attaquer avec votre épée ou d'autres armes. (« Parfaitement inutile », marmonne E.J.) Mais si vous ne l'attaquez pas, il va vous dépouiller de " +
                "tous vos biens. Il vous volera tout ce que vous possédez, (sauf l'armure et les armes) si " +
                "vous n'intervenez pas rapidement. En fait, vous n'avez le choix qu'entre trois solutions. " +
                "Vous pouvez le noyer dans votre gourde à eau. (Vous en avez bien emporté une, n'est-ce pas ?) L'eau prendra par la suite un goût bizarre mais c'est à prévoir. Ou alors, si " +
                "vous n'avez pas emporté de gourde, vous pouvez l'assommer d'un coup sur la tete avec " +
                "vos bottes de rechange. (Vous avez bien emporté des bottes de rechange, n'est-ce pas " +
                "?) Ou si vous n'avez emporté ni gourde à eau ni bottes de rechange, vous pouvez " +
                "l'ensorceler en jouant du luth ou de la harpe. (Vous avez bien emporté un luth et une" +
                "harpe, n'est-ce pas ?).\n" +
                "Si vous ne possédez pas le matériel nécessaire pour neutraliser le Troll des Bois, vous " +
                "ne possédez plus que vos armes et votre armure. Mettez à jour votre Feuille " +
                "d'Aventure. Dans tous les cas, rendez-vous au [11]";
    }

    @Override
    public Execution execute(Pip pip) {
        if (canAttackTroll(pip)) {
            Events.fightEvent("Vous attaquez le Troll avec votre matériel.");
            pip.addExperiencePoints(1);
        } else {
            getThiefableItems(pip).forEach(pip::removeOne);
        }
        return super.execute(pip);
    }

    private boolean canAttackTroll(Pip pip) {
        return List.of(
                BOTTLE_OF_WATER,
                SPARE_BOOTS,
                LUTH,
                HARP
        ).stream().anyMatch(pip::has);
    }

    private List<Item> getThiefableItems(Pip pip) {
        return pip.getInventory().stream()
                .filter(item -> !item.isWeapon() && !item.isArmor())
                .collect(Collectors.toList());
    }

    @Override
    protected int getNextPage() {
        return 11;
    }
}
