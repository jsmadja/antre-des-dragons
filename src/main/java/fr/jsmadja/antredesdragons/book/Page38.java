package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.pages.ManualChoicePage;

public class Page38 extends ManualChoicePage {
    @Override
    public Paths getPossiblesPath() {
        return new Paths(
                Path.builder().description("Franchir la porte").page(92).build(),
                Path.builder().description("Explorer un autre endroit").page(10).build());
    }

    @Override
    public String getText() {
        return "On dirait une chaumière, ressemblant à n'importe quelle chaumière. Murs blanchis à " +
                "la chaux, toit de chaume. Elle est construite contre la palissade, bien sûr. de même " +
                "que plusieurs autres comme vous l'avez remarqué, sans aucun doute. Vous entrez " +
                "néanmoins, puisque vous êtes venu jusque-là. Et la porte étant entrebâillée, vous y " +
                "pénétrez sans probleme. " +
                "La chaumière est déserte. Assez propre, et en ordre, mais il y règne cette étrange odeur " +
                "de moisi indiquant que personne n'a vécu ici depuis des années. la maison semble " +
                "avoir été habitée autrefois. Il y a encore quelques meubles çà et là, des bibelots sur la " +
                "tablette de la cheminée et des tableaux (des paysages) aux murs. Et il y a une porte de " +
                "derrière ! S'il y a une porte de derrière, cela signifie qu'on doit pouvoir franchir la " +
                "palissade !\n" +
                "Si vous voulez franchir cette porte, rendez-vous au [92].\n" +
                "Si vous préférez vous attarder encore un moment dans le village, reprenez votre carte " +
                "et allez explorer un autre endroit.";
    }
}
