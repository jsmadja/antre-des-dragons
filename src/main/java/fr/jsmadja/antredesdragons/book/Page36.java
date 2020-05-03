package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.pages.ManualChoicePage;

public class Page36 extends ManualChoicePage {
    @Override
    public Paths getPossiblesPath() {
        return new Paths(
                Path.builder().description("Révéler ma destination").page(56).build(),
                Path.builder().description("Ne rien dire").page(22).build()
        );
    }

    @Override
    public String getText() {
        return "—Très aimable à vous, Votre Honneur, dit le petit homme. Ce sera bien volontiers, " +
                "puisque vous me le proposez. Et il se hisse sur la souche pour s'installer " +
                "confortablement. Pendant qu'il mange (et il a un fameux coup de fourchette pour " +
                "quelqu'un de sa taille), il vous examine, vous, vos vêtements et vos armes. Ai-je raison " +
                "de supposer, finit-il par demander, que vous êtes un voyageur ou un aventurier ? Vous " +
                "acquiescez d'un signe de tête.\n" +
                "— C'est bien ce que je pensais, en vous regardant. Vous ne vous rendez pas, par " +
                "hasard, à l'Antre du Dragon ?\n" +
                "Allez-vous lui révéler votre destination ? Si oui. rendez-vous au [56].\n" +
                "Mais peut-être jugez-vous plus prudent de ne rien lui dire ? Rendez-vous dans ce cas " +
                "au [22].";
    }
}
