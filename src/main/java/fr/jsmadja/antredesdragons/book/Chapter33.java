package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.chapters.GoNextChapter;

public class Chapter33 extends GoNextChapter {
    @Override
    public int getNextChapter() {
        return 125;
    }

    @Override
    public String getText() {
        return "Le village disparaît et la route s'étend à l'infini devant vous. Vous faites demi-tour, " +
                "mais le porche a disparu lui aussi. Il n'est plus question de revenir sur vos pas " +
                "maintenant. La seule solution, c'est de continuer votre chemin. Vous marchez jusqu'à " +
                "ce que vos jambes s'alourdissent de fatigue, et que le soleil se couche, et vous installez " +
                "votre campement comme vous le pouvez : demain, il fera jour. Naturellement, il pleut " +
                "! Rendez-vous au [125].";
    }
}
