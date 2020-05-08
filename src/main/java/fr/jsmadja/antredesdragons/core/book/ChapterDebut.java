package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.GoNextChapter;

public class ChapterDebut extends GoNextChapter {
    @Override
    public int getNextChapter() {
        return Book.MERLIN;
    }

    @Override
    public String getText() {
        return "L'Antre du Dragon est le deuxième volume de la serie intitulée La Quête du Graal. Un " +
                "livre dont VOUS êtes le héros. Dans quelques pages, vous allez etre précipité à " +
                "l'époque du roi Arthur, et des Chevaliers de la Table Ronde, dans le fabuleux " +
                "Royaume d' Avalon terrorisé par des monstres épouvantables, sorciers aux pouvoirs " +
                "immenses et des êtres malfaisants aux formes les plus répugnantes. C'est de camelot, " +
                "où siège le roi Arthur entouré de sa cour, que partent les Chevaliers de la Table Ronde " +
                "en quete de hauts faits à accomplir. Pourtant, c'est " +
                " VOUS qui avez été choisi pour entreprendre la mission la plus périlleuse de " +
                "toutes : poursuivre et faire disparaître à tout jamais un gigantesque Dragon qui ravage " +
                "le pays, semant sur son chemin la destruction et la mort. Mais votre route est semée " +
                "d'embûches et de pièges, et vous rencontrerez des créatures infâmes que vous devrez " +
                "combattre et détruire, au péril de votre vie.\n" +
                "Pour progresser dans ce livre d'aventures, vous avez besoin de deux dés, d'un crayon et " +
                "d'une gomme. Dressez une carte au fur et à mesure de vos découvertes et de vos " +
                "rencontres, notez tous les détails de votre mission sur la Feuille d'Aventure que vous " +
                "trouverez en pages 34 et 35. Et si le personnage que vous allez bientôt rencontrer vous " +
                "semble quelque peu étourdi et confus, la Règle des Combats que vous trouverez en fin " +
                "de volume vous sera d'un grand secours. Bonne chance !";
    }
}
