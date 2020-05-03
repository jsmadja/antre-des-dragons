package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.pages.ManualChoicePage;

public class Page13 extends ManualChoicePage {
    @Override
    public String getText() {
        return "Qu'est-ce que c'est ? On dirait une brume de chaleur, mais il ne fait pas chaud à ce " +
                "point. Et une brume de chaleur ne se manifeste pas comme cela. Une sorte de " +
                "vibration anime l'air devant vous. Mais une vibration bien délimitée de deux mètres de " +
                "haut de plus d'un mètre de large. On dirait une porte. Un porche vibratoire. Derrière, " +
                "se profile le village, toujours aussi éloigné.\n" +
                "Allez-vous franchir ce porche vibratoire? Si oui rendez-vous au [10].\n" +
                "Préférez-vous prudemment le contourner ? Rendez-vous alors au [33].";
    }

    @Override
    public Paths getPossiblesPath(Pip pip) {
        return new Paths(
                Path.builder().description("Franchir le porche").page(10).build(),
                Path.builder().description("Contourner le porche").page(33).build()
        );
    }
}
