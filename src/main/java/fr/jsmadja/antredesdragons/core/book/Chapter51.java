package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.ManualChoiceChapter;
import fr.jsmadja.antredesdragons.core.entities.Pip;

public class Chapter51 extends ManualChoiceChapter {
    @Override
    public Paths getPossiblesPath(Pip pip) {
        return new Paths(
                Path.builder().description("Explorer le passage secret").chapter(90).build(),
                Path.builder().description("Retourner à la carte du village").chapter(10).build()
        );
    }

    @Override
    public String getText() {
        return "Si vous n'étiez pas un aventurier aussi chevronné, vous auriez pensé qu'il s'agissait " +
                "simplement d'une vieille maison abandonnée. Personne, aucun objet de valeur, " +
                "quelques débris de vieux meubles... Le genre d'endroit qui vous incite à tourner " +
                "aussitôt les talons pour ressortir. Mais vous ne l'avez pas fait, n'est-ce pas ? En " +
                "tâtonnant le long des murs et au-dessus de la cheminée, vous avez trouvé un drôle de " +
                "petit bouton. Quand vous avez tourné ce drôle de petit bouton, une drôle de petite " +
                "porte dérobée s'est ouverte dans le mur, donnant sur un drôle de petit passage secret. " +
                "Evidemment, vous n'êtes pas obligé d'explorer ce passage secret. Vous pouvez " +
                "simplement vous reporter à votre carte du village et en explorer une autre partie. Mais " +
                "si vous voulez en réalité explorer le passage secret, cela vous conduit au 90.";
    }
}
