package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.pages.ManualChoicePage;

public class Page47 extends ManualChoicePage {
    @Override
    public Paths getPossiblesPath() {
        return new Paths(
                Path.builder().description("Pénétrer dans la Crypte de Nosférax").page(107).build(),
                Path.builder().description("Retourner à la carte").page(10).build()
        );
    }

    @Override
    public String getText() {
        return "Le Comte Dracula disait volontiers que lorsqu'on avait vu une crypte, on les avait " +
                "toutes vues. Mais quoi qu'il en soit, cette crypte-là semble vraiment tout à fait " +
                "spéciale. Pour commencer, elle est toute entière en marbre rose. Et, en plus, sur une " +
                "plaque en cuivre ornant la lourde porte de bois sont gravés les vers suivants : \n" +
                "Oh, voyageur lassé aux pieds si douloureux,\n" +
                "Aux pieds si poussiéreux,\n" +
                "Aux cheveux pleins de poux,\n" +
                "Entre ici pour y prendre un peu de répit.\n" +
                "Moi, de ma poésie, je vais te régaler.\n" +
                "Franchis ce seuil, voyageur esseulé\n" +
                "Et partage avec moi ce toit si doux.\n" +
                "Une seule créature au monde pourrait écrire un poème aux rimes si désastreuses. Sa " +
                "renommée est telle que tout le monde, ou presque, à Avalon a entendu parler de lui à " +
                "un moment ou à un autre S'agirait-il de... Mais oui ! En dessous du poème se trouve " +
                "une autre plaque, en fer celle-là, portant les mots : \n" +
                "CRYPTE DE NOSFÉRAX (Prière de frapper).\n" +
                "Ne perdez plus une seconde ! Ceci sera certainement dangereux, mais le jeu devrait en " +
                "valoir la chandelle Entrez ! Entrez !\n" +
                "Si vous décidez de pénétrer dans la Crypte de Nosférax, rendez-vous au [107]. " +
                "Sinon, retournez à votre carte et explorez une autre partie du village.";
    }
}
