package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.pages.ManualChoicePage;

public class Page156 extends ManualChoicePage {
    @Override
    public Paths getPossiblesPath(Pip pip) {
        return new Paths(
                Path.builder().description("Rabattre le moraillon et soulever le couvercle").page(171).build(),
                Path.builder().description("Manœuvrer le rubis").page(165).build(),
                Path.builder().description("Forcer la serrure").page(169).build()
        );
    }

    @Override
    public String getText() {
        return "Le coffre est cerclé de cuivre, et fermé par un moraillon. Un motif décoratif en feuille " +
                "d'or est incrusté dans le couvercle, autour d'un gros rubis. Il semble qu'il y ait " +
                "différentes façons possibles d'ouvrir ce coffre, Pip.\n" +
                "Vous pouvez, par exemple, simplement rabattre le moraillon, et essayer de soulever le " +
                "couvercle. Si vous voulez ouvrir le coffre ainsi, rendez-vous au [171].\n" +
                "Vous pouvez, par ailleurs, estimer qu'un coffre de ce genre, dont le contenu doit revêtir " +
                "une extrême importance, doit posséder une serrure secrète, probablement déclenchée " +
                "par le joyau incrusté dans le couvercle. Si vous voulez essayer de manœuvrer le rubis, " +
                "rendez-vous au [164].\n" +
                "Ou peut-être êtes-vous trop impatient pour vous livrer à des manipulations aussi " +
                "subtiles : vous pouvez vous servir de votre épée pour forcer la serrure Si telle est la " +
                "solution que vous choisissez, rendez-vous au [169].";
    }
}
