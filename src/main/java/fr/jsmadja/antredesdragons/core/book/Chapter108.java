package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.ManualChoiceChapter;
import fr.jsmadja.antredesdragons.core.entities.Pip;

public class Chapter108 extends ManualChoiceChapter {
    @Override
    public Paths getPossiblesPath(Pip pip) {
        return new Paths(
                Path.builder().description("Aller vers l'issue de gauche").chapter(98).build(),
                Path.builder().description("Aller vers l'issue de droite").chapter(99).build(),
                Path.builder().description("Aller vers l'issue centrale").chapter(102).build()
        );
    }

    @Override
    public String getText() {
        return "Vous vous trouvez à l'intérieur d'une grotte naturelle, dont le sol est littéralement " +
                "jonché d'ossements et de crânes. La plupart proviennent d'animaux, certains, " +
                "d'humains, plusieurs de créatures non identifiables. Rien ne bouge ici. Vous n'avez " +
                "conscience que du silence. Il y a trois issues dans la paroi nord de cette grotte. " +
                "Laquelle allez vous choisir ? " +
                "L'issue de gauche ? Rendez-vous au [98].\n" +
                "L\"issue de droite ? Rendez-vous au [99].\n" +
                "L'issue centrale ? Rendez-vous au [102].\n" +
                "Un  dernier avertissement, Pip. Les tunnels sont étroits. En les examinant à la lumière " +
                "vacillante de votre torche, vous constatez qu'ils tournent et s'infléchissent dans tous les " +
                "sens. Tout au fond de vous-même, vous savez que vous risquez de faire un choix fatal. " +
                "Car, dans cette partie de votre aventure, vous ne pourrez revenir en arrière. En avant " +
                "donc ! Vers la gloire... ou la mort !";
    }
}
