package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.chapters.GoNextChapter;

public class Chapter121 extends GoNextChapter {
    @Override
    public int getNextChapter() {
        return 10;
    }

    @Override
    public String getText() {
        return "Aussitôt le couvercle du cercueil se rabat et une mince silhouette d'une mortelle pâleur " +
                "en tenue de soirée et longue cape noire en bondit avec une effrayante célérité. Cette " +
                "créature a des yeux roses et ses canines supérieures chevauchent sa lèvre inférieure. " +
                "Qui plus est, elle a l'air furieux. — Vous ne savez pas ? hurle Nosférax. En voilà une " +
                "reponse ! Tout le monde sait que l'une de ses pattes se ressemble ! " +
                "Là-dessus, il referme violemment le couvercle de son cercueil et vous ne réussirez " +
                "jamais à le persuader de sortir de nouveau.\n" +
                "Reprenez la carte du village de la Pierre-qui-Mue et poursuivez votre exploration.";
    }
}
