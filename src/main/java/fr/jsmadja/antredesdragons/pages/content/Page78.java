package fr.jsmadja.antredesdragons.pages.content;

import fr.jsmadja.antredesdragons.dices.DiceWay;
import fr.jsmadja.antredesdragons.pages.types.RollAndGoPage;

import java.util.List;

public class Page78 extends RollAndGoPage {
    @Override
    public String getText() {
        return "La chance vous sourit, Pip. Ce corps-là nage comme un poisson, comme une otarie ! " +
                "Les remous glacés vous malmènent, vous submergent, vous projettent contre des " +
                "rochers invisibles... mais vous continuez à nager ! Le courant vous ramène en arrière, " +
                "vous entraîne en avant... mais vous nagez. Votre adresse et votre détermination — " +
                "sans parler de vos muscles endurcis par toutes vos aventures — vous assurent la " +
                "victoire. Vous arrivez de l'autre côté sain et sauf.\n" +
                "Maintenant il ne reste plus qu'un petit problème : la paroi verticale de la falaise qui se " +
                "dresse devant vous... C'est le moment de sortir votre matériel d'escalade et de lancer " +
                "deux dés, Pip. Voyons si vous allez réussir à franchir le dernier obstacle.\n" +
                "Si vous faites :\n" +
                "de 2 à 9 : rendez-vous au [85].\n" +
                "de 10 à 12 : rendez-vous au [76].";
    }

    @Override
    public List<DiceWay> getDiceWays() {
        return List.of(new DiceWay(2, 9, PageNumber.of(85)), new DiceWay(10, 12, PageNumber.of(76)));
    }
}
