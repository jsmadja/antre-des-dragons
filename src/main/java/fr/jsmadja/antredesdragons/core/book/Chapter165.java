package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.ManualChoiceChapter;
import fr.jsmadja.antredesdragons.core.entities.Pip;

public class Chapter165 extends ManualChoiceChapter {
    @Override
    public Paths getPossiblesPath(Pip pip) {
        return new Paths(
                Path.builder().description("Attaquer les Formes").chapter(157).build(),
                Path.builder().description("Attendre").chapter(168).build()
        );
    }

    @Override
    public String getText() {
        return "Oh, oh. Des petites Formes noires s'envolent du coffre. De toutes petites créatures de " +
                "la taille d'une main d'homme, peut-être même plus petites. Six en tout, qui volètent " +
                "comme des chauves-souris ou des papillons. Mais il ne s'agit ni de chauves-souris ni " +
                "de papillons. Ni d'oiseaux, d'insectes volants ou de quoi que ce soit du même genre. " +
                "Impossible d'en décrire l'apparence ! Elles ressemblent, eh bien tout simplement à des " +
                "ombres. Peut-être sont-elles dépourvues de réalité ? Elles sont sans doute inoffensives, " +
                "et ne valent pas que l'on s'en inquiète. N'empêche qu'elles volètent dans votre direction " +
                "!\n" +
                "Si vous décidez d'attaquer les Formes, rendez-vous au [157].\n" +
                "Si vous préférez attendre pour voir si les Formes sont bien disposées à votre égard, " +
                "rendez-vous au [168].\n";
    }
}
