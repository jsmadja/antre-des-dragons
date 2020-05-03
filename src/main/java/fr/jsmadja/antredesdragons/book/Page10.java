package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.pages.ManualChoicePage;

import java.util.List;
import java.util.stream.Collectors;

public class Page10 extends ManualChoicePage {
    @Override
    public String getText() {
        return "Un clignement de paupières. Un frémissement. Vous êtes dans le village, Pip. Cela ne " +
                "fait aucun doute. En plein village, sans avoir fait un pas de plus. Comme c'est étrange. " +
                "C'est un joli village. Petit mais ravissant. Des maisons au toit de chaume... une pelouse " +
                "une pittoresque petite église en pierre. Et pas une âme en vue. Pas âme qui vive. vous " +
                "vous trouvez sur un sentier de terre battue, un peu boueux et creusé d'ornières, comme " +
                "s'il servait souvent. Une longue bâtisse se dresse au nord-est de l’endroit où vous êtes " +
                "et, vers l'est, s'étend le plus étrange jardin que vous ayez jamais vu. Toutes les plantes " +
                "semblent faites de pierre et il est parsemé de statues de monstres. Au-delà du jardin se " +
                "trouvent les chaumières et, derrière les chaumières, vous apercevez le clocher de " +
                "l'église. Le village tout entier est enclos par une robuste palissade en bois, solidement " +
                "construite et, à en juger par son aspect, extrêmement difficile à escalader. Au sud-est " +
                "se trouvent d'autres chaumières et un grand mur en pierre. Maintenant, reportez-vous à " +
                "la carte du village, que vous trouverez pages 10 et 11. Elle indique le lieu où vous " +
                "vous trouvez actuellement, et vous pouvez constater que tous les bâtiments, ainsi que " +
                "divers endroits du village portent un numéro. Vous pouvez explorer la Pierre-qui-Mue " +
                "à votre guise. Vous êtes libre d'aller où bon vous semble, libre de tout voir. Pour cela, " +
                "il vous suffira de vous rendre au paragraphe portant le numéro que vous aurez choisi " +
                "sur la carte.\n" +
                "Ah. une dernière chose... Avez-vous remarqué qu'il n'y a pas d'issue ?";
    }

    @Override
    public Paths getPossiblesPath(Pip pip) {
        return new Paths(List.of(
                20,
                24,
                30,
                33,
                34,
                38,
                39,
                41,
                43,
                44,
                45,
                47,
                48,
                50,
                51,
                52,
                54,
                55,
                57,
                60,
                61,
                63,
                66,
                69,
                72,
                74,
                79,
                89).stream().map(operand -> Path.builder().page(operand).build()).collect(Collectors.toList()));
    }
}
