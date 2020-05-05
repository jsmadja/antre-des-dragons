package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.pages.ManualChoicePage;

public class Page107 extends ManualChoicePage {
    @Override
    public Paths getPossiblesPath(Pip pip) {
        return new Paths(
                Path.builder().description("C'est une énigme stupide").page(116).build(),
                Path.builder().description("Je ne sais pas").page(121).build(),
                Path.builder().description("L'une de ses pattes se ressemble").page(122).build()
        );
    }

    @Override
    public String getText() {
        return "L'interieur de la crypte est tendu de magnifiques draperies de velours noir et le sol, les " +
                "murs et le plafond, sont du marbre blanc le plus fin. Au centre est dressee une petite " +
                "estrade sur laquelle repose un cercueil en ébène incrusté de cuivre étincelant. Sur " +
                "l'estrade, une inscription déclare :\n" +
                "Recru de lassitude\n" +
                "Dans la désespérance\n" +
                "Ici vous êtes parvenu\n" +
                "Dans un ultime effort\n" +
                "Et l'espoir d'y trouver\n" +
                "Un être cher ou bien la mort.\n" +
                "La médiocrité de ce texte vous concerne (mais VOUS vous rappelez néanmoins que, s'il " +
                "s'agit vraiment de Nosférax le Poète vous devrez prendre grand soin de vanter sa " +
                "poésie lorsqu'il se réveillera) et vous montez sur l'estrade. Bien entendu, sur le " +
                "couvercle du cercueil une plaque de cuivre porte l'inscription suivante :\n" +
                "Pour réveiller Nosférax, prononcez à voix haute la réponse à cette énigme :\n" +
                "QUELLE EST LA DIFFÉRENCE ENTRE UN CANARD ?\n" +
                "Donnez votre réponse à voix haute maintenant.\n" +
                "Si vous répondez : « C'est une énigme stupide ». rendez-vous au [116].\n" +
                "Si vous répondez : « Je ne sais pas », rendez-vous au [121].\n" +
                "Si vous répondez : « L'une de ses pattes se ressemble », rendez-vous au [122].";
    }
}
