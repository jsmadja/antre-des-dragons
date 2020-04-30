package fr.jsmadja.antredesdragons.pages.content;

import fr.jsmadja.antredesdragons.pages.types.ManualChoicePage;

public class Page25 extends ManualChoicePage {
    @Override
    public String getText() {
        return "Vous émergez dans un désert volcanique. Vous vous trouvez au milieu de champs de " +
                "lave, de vastes étendues où se dressent en formes grotesques des pierres au profil " +
                "tourmenté, une surface ondulée, creusée de trous, sur laquelle il est difficile d'avancer. " +
                "Vous êtes entouré de falaises aux flancs abrupts se dressant à des hauteurs " +
                "vertigineuses. Espérons que vous n'aurez pas à les escalader : même avec l'équipement " +
                "dont vous disposez, il vous faudrait près d'une année. L'atmosphère est sinistre ; les " +
                "falaises sont si hautes qu'elles arrêtent presque toute la lumière du soleil. Il devrait " +
                "faire froid également, mais en réalité, il règne une chaleur presque tropicale, due sans " +
                "doute à quelque activité volcanique souterraine. En tout cas une odeur acide, " +
                "pénétrante, sulfureuse, flotte dans ce décor, comme si vous étiez arrivé au seuil même " +
                "de l'Enfer. Vous avancez avec circonspection, l'oreille aux aguets. Le sol est en " +
                "général relativement ferme, bien qu'il s'effondre un peu par endroits. De temps à autre, " +
                "un grondement lointain, presque inaudible, roule sous vos pieds, vous mettant les nerfs " +
                "encore plus à vif. Vous n'avez le choix qu'entre deux directions : plein nord, ou nordest. Toutes les autres vous sont barrées par des falaises, ou des flèches rocheuses aux " +
                "lignes chaotiques et torturées.\n" +
                "Si vous décidez de prendre la direction du nord, rendez-vous au [62]. " +
                "Si vous préférez partir en direction du nord-est rendez-vous au [84].";
    }

    @Override
    public Paths getPossiblesPath() {
        return new Paths(Path.builder().description("Aller au nord").page(62).build(), Path.builder().description("Aller au nord-est").page(84).build());
    }

}
