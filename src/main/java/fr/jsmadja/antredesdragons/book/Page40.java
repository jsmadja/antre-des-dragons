package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.pages.GoPage;

public class Page40 extends GoPage {
    @Override
    public int getNextPage() {
        return 100;
    }

    @Override
    public String getText() {
        return "Voilà qui est mieux ! Une table chargée de beignets, de meringues, de tartes aux " +
                "pommes, de cakes, de brioches, de bombes glacées, de gâteaux aux noix et de " +
                "friandises de toutes sortes. Il y a même un pichet de citronnade fraîche. Et personne en " +
                "vue ! Régalez- vous. Vous avez besoin de prendre des forces quand vous le pouvez " +
                "dans un endroit pareil ! Rendez-vous ensuite au [100].";
    }
}
