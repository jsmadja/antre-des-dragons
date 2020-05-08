package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.ManualChoiceChapter;
import fr.jsmadja.antredesdragons.core.entities.Pip;

import static fr.jsmadja.antredesdragons.core.stuff.Item.MINOTAUR_KEY;

public class Chapter134 extends ManualChoiceChapter {
    @Override
    public Paths getPossiblesPath(Pip pip) {
        Paths paths = new Paths(
                Path.builder().description("Poussez les trois leviers vers le haut").chapter(142).build(),
                Path.builder().description("Rabattez tous les leviers vers le bas").chapter(145).build(),
                Path.builder().description("Poussez un levier vers le haut et deux vers le bas").chapter(148).build(),
                Path.builder().description("Poussez deux leviers vers le haut et un vers le bas").chapter(149).build()
        );
        if (pip.has(MINOTAUR_KEY)) {
            paths.add(
                    Path.builder().description("Mettre la clef et poussez les trois leviers vers le haut").chapter(139).build(),
                    Path.builder().description("Mettre la clef et rabattez les trois leviers vers le bas").chapter(141).build(),
                    Path.builder().description("Mettre la clef et poussez un levier vers le haut et deux vers le bas").chapter(144).build(),
                    Path.builder().description("Mettre la clef et poussez deux leviers vers le haut et un vers le bas").chapter(147).build()
            );
        }
        return paths;
    }

    @Override
    public String getText() {
        return "Enjambant avec soin les cadavres des Nains, vous arrivez devant le panneau de " +
                "contrôle sur le mur nord. Une plaque de métal bleu est encastrée dans le sol en métal " +
                "luisant sous vos pieds. Vous la tâtez avec précaution, mais il semble qu'on puisse se " +
                "tenir dessus sans danger. Devant vous se trouvent trois grands leviers, surmontés d'une " +
                "notice en rouge dont les termes sont les suivants :\n" +
                "GLISSEZ LA CLEF DANS LA FENTE\n" +
                "AVANT D'ACTIONNER LES LEVIERS\n" +
                "A côté de la notice, vous distinguez une fente assez large pour qu'on puisse y loger " +
                "une grande clef. Les leviers sont numérotés 1, 2 et 3. Vous constatez que chacun " +
                "d'entre eux peut être poussé vers le haut ou rabattu vers le bas. Réfléchissez bien " +
                "avant de décider ce que vous allez faire avec ces leviers car, de toute évidence, ils vont " +
                "déterminer le cours futur de votre aventure. Divers choix s'offrent à vous : " +
                "Si vous avez une clef à glisser dans la fente, voilà les résultats que vous pouvez " +
                "obtenir :\n" +
                "Poussez les trois leviers vers le haut et rendez-vous au [139].\n" +
                "Rabattez les trois leviers vers le bas et rendez-vous au [141].\n" +
                "Poussez un levier vers le haut et deux vers le bas et rendez-vous au [144].\n" +
                "Poussez deux leviers vers le haut et un vers le bas et rendez-vous au [147].\n" +
                "Si vous ne possédez pas de clef à glisser dans la fente, voici les résultats que vous " +
                "pouvez obtenir :\n" +
                "Poussez les trois leviers vers le haut et rendez-vous au [142].\n" +
                "Rabattez tous les leviers vers le bas et rendez-vous au [145].\n" +
                "Poussez un levier vers le haut et deux vers le bas et rendez-vous au [148].\n" +
                "Poussez deux leviers vers le haut et un vers le bas et rendez-vous au [149].";
    }
}
