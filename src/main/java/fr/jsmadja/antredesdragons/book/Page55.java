package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.pages.ManualChoicePage;

public class Page55 extends ManualChoicePage {
    @Override
    public Paths getPossiblesPath() {
        return new Paths(
                Path.builder().description("J'ai traversé le Château des Ténèbres du Magicien Ansalom").page(96).build(),
                Path.builder().description("Battre en retraite").page(10).build(),
                Path.builder().description("Défier le chevalier").page(118).build()
        );
    }

    @Override
    public String getText() {
        return "— Halte, Manant ! Comment oses-tu troubler mes méditations ?\n" +
                "Vous ne vous attendiez pas à entendre ce genre de propos en pénétrant dans une " +
                "chaumière, à la campagne, mais vos oreilles ne vous ont pas trompé. Et ces mots " +
                "sortent de la bouche d'un personnage couvert des pieds à la tête d'une armure aussi " +
                "noire que le jais. Serait-ce le célèbre (et très redoutable) Chevalier Noir dont le nom " +
                "n'est prononcé qu'à voix basse à Avalon ?\n" +
                "Si VOUS avez déjà traversé précédemment le Château des Ténèbres du Magicien " +
                "Ansalom, rendez-vous au [96].\n" +
                "Si vous voulez vous adresser poliment au personnage en armure, vous pouvez le faire, " +
                "avant de battre prudemment en retraite. Reprenez ensuite votre carte, et explorez une " +
                "autre partie du village. Si vous voulez vous faire une réputation en défiant le Chevalier " +
                "Noir, rendez-vous au [118].";
    }
}
