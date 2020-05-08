package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.ManualChoiceChapter;
import fr.jsmadja.antredesdragons.core.entities.Pip;

public class Chapter169 extends ManualChoiceChapter {
    @Override
    public Paths getPossiblesPath(Pip pip) {
        return new Paths(
                Path.builder().description("Les balayer d'un revers de la main").chapter(161).build(),
                Path.builder().description("Les écarter à l'aide d'E.J").chapter(158).build(),
                Path.builder().description("Utiliser une autre arme").chapter(167).build(),
                Path.builder().description("Utiliser un sortilège").chapter(159).build()
        );
    }

    @Override
    public String getText() {
        return "Ce coffre n'a pas dû être ouvert depuis de longues années, car un amoncellement de " +
                "toiles d'araignées poussiéreuses recouvre son contenu. Comment allez-vous vous " +
                "débarrasser de ces encombrantes toiles d'araignées ?\n" +
                "Allez-vous les balayer d'un revers de la main? Rendez-vous au [161].\n" +
                "Allez-vous les écarter à l'aide d'E.J. ? Rendez-vous au [158].\n" +
                "Préférez-vous prendre le risque d'utiliser une autre de vos armes pour en venir à bout ? " +
                "Rendez-vous au [167]. Allez-vous essayer de les brûler à l'aide d'une Boule de Feu, ou " +
                "de tout autre sortilège susceptible de se montrer efficace dans ce cas ? Rendez-vous au " +
                "[159].";
    }
}
