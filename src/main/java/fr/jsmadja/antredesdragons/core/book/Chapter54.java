package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.ManualChoiceChapter;
import fr.jsmadja.antredesdragons.core.entities.Pip;

public class Chapter54 extends ManualChoiceChapter {
    @Override
    public Paths getPossiblesPath(Pip pip) {
        return new Paths(
                Path.builder().description("Retourner à la carte du village").chapter(10).build(),
                Path.builder().description("Explorer le silo à grains").chapter(104).build()
        );
    }

    @Override
    public String getText() {
        return "Quel vaste bâtiment. En y pénétrant, vous constatez que c'est un silo à grains. Mais " +
                "comme tout le reste dans ce village misérable, les grains sentent vraiment le moisi. " +
                "Si vous pensez ne rien y trouver d'intéressant, reprenez votre carte et explorez un autre " +
                "secteur du village.\n" +
                "Si vous voulez explorer plus minutieusement le silo à grains, rendez-vous au [104].";
    }
}
