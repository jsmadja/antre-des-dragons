package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.chapters.ManualChoiceChapter;

public class Chapter150 extends ManualChoiceChapter {
    @Override
    public Paths getPossiblesPath(Pip pip) {
        return new Paths(
                Path.builder().description("Aller vers le premier passage").chapter(114).build(),
                Path.builder().description("Aller vers le deuxième passage").chapter(128).build(),
                Path.builder().description("Aller vers le troisième passage").chapter(137).build()
        );
    }

    @Override
    public String getText() {
        return "La cassette contient une grosse clef. A quoi peut-elle bien correspondre ? Le coffre ne " +
                "fournit aucune explication : il contient seulement un flacon avec l'inscription " +
                "clairement indiquée Antidote au venin de Serpent, ce qui, au moins, pourrait se révéler " +
                "utile en cas de morsure de Serpent. Son goût est infect, mais il neutralise totalement le " +
                "venin. Il vous laissera les POINTS DE VIE dont vous disposiez avant d'être mordu. Le " +
                "flacon ne contient qu'une seule dose. Comme le Minotaure l'avait prédit, les autres coffres ont disparu. Trois passages permettent de sortir de cette caverne. Ils conduisent au " +
                "[114], au [137] et au [128]. Faites votre choix !";
    }
}
