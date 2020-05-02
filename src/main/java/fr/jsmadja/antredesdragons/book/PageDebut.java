package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.pages.GoPage;

import static fr.jsmadja.antredesdragons.book.Pages.MERLIN;

public class PageDebut extends GoPage {
    @Override
    protected int getNextPage() {
        return MERLIN;
    }

    @Override
    public String getText() {
        return "l' Antre du Dragon est le deuxième volume de la serie intitulée La Quête du Graal. Un\n" +
                "livre dont vOUS êtes le héros. Dans quelques pages, vous allez etre précipité à\n" +
                "l'époque du roi Arthur, et des Chevaliers de la Table Ronde, dans le fabuleux\n" +
                "Royaume d' Avalon terrorisé par des monstres épouvantables, sorciers aux pouvoirs\n" +
                "immenses et des êtres malfaisants aux formes les plus répugnantes. C'est de camelot,\n" +
                "où siège le roi Arthur entouré de sa cour, que partent les Chevaliers de la Table Ronde\n" +
                "en quete de hauts faits à accomplir. Pourtant, c'est\n" +
                "- VOUS qui avez été choisi pour entreprendre la mission la plus périlleuse de\n" +
                "toutes : poursuivre et faire disparaître à tout jamais un gigantesque Dragon qui ravage\n" +
                "le pays, semant sur son chemin la destruction et la mort. Mais votre route est semée\n" +
                "d'embûches et de pièges, et vous rencontrerez des créatures infâmes que vous devrez\n" +
                "combattre et détruire, au péril de votre vie.\n" +
                "pour progresser dans ce livre d'aventures, vous avez besoin de deux dés, d'un crayon et\n" +
                "d'une gomme. Dressez une carte au fur et à mesure de vos découvertes et de vos\n" +
                "rencontres, notez tous les détails de votre mission sur la Feuille d'Aventure que vous\n" +
                "trouverez en pages 34 et 35. Et si le personnage que vous allez bientôt rencontrer vous\n" +
                "semble quelque peu étourdi et confus, la Règle des Combats que vous trouverez en fin\n" +
                "de volume vous sera d'un grand secours. Bonne chance !";
    }
}
