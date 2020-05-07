package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.chapters.ManualChoiceChapter;
import fr.jsmadja.antredesdragons.stuff.Item;

public class Chapter133 extends ManualChoiceChapter {
    @Override
    public Paths getPossiblesPath(Pip pip) {
        return new Paths(
                Path.builder().chapter(114).build(),
                Path.builder().chapter(128).build(),
                Path.builder().chapter(137).build()
        );
    }

    @Override
    protected void beforeLeavingChapter(Pip pip) {
        pip.add(Item.MINOTAUR_MAGICAL_LOCKED_SMALL_CHEST);
        super.beforeLeavingChapter(pip);
    }

    @Override
    public String getText() {
        return "Eh bien, au moins, vous n'êtes pas mort. Un peu estourbi peut-être, mais pas mort. Le " +
                "seul problème, maintenant, c'est qu'il va falloir demander à Merlin de s'occuper de " +
                "cette énorme et stupide tête du Minotaure.\n" +
                "N'oublie pas ta promesse, dit le Minotaure. comme s'il lisait dans vos pensées.\n" +
                "Et la seule façon pour vous de voir Merlin au cours de cette aventure, c'est de vous " +
                "faire tuer. Ce qui est quand même paradoxal, Pip.\n" +
                "Et si... suggérez-vous d'une voix hésitante, si je vous promettais de parler à Merlin de " +
                "votre petit problème la prochaine fois que je le verrai ? Je n'ai guère envie de refaire  " +
                "maintenant tout le voyage en sens inverse, parce que j'ai un Dragon à combattre, si je " +
                "peux le trouver.\n" +
                "Quand espères-tu le voir? demande le Minotaure, soupçonneux.\n" +
                "La prochaine fois que je serai tué, répondez-vous en toute honnêteté.\n" +
                "Cela ne devrait pas prendre bien longtemps dans un endroit pareil, fait remarquer le " +
                "Minotaure. Je suis un monstre compréhensif. J'attendrai.\n" +
                "Je vous remercie, Noble Minotaure, répondez-vous poliment.\n" +
                "Et, ajoute le Minotaure dans un brusque élan de générosité, quand tu l'auras vu, tu " +
                "pourras prendre le contenu de ma cassette. Et d'un geste impulsif, il vous place de " +
                "force la cassette entre les mains.\n" +
                "La cassette refusera de s'ouvrir, malgré tous vos efforts, avant que vous ne vous soyez " +
                "une fois de plus rendu au [14] et que vous ayez vu Merlin. Mais lorsque vous aurez tenu " +
                "votre promesse (et pas avant) vous pourrez vous rendre au [143] (notez le numéro) pour " +
                "savoir ce que contient la cassette, avant de rejoindre le paragraphe auquel vous aurez " +
                "rendez-vous. Vous avez bien compris ? Parfait.\n" +
                "Trois passages peuvent vous permettre de quitter la grotte du Minotaure. Ils conduisent " +
                "au [114], au [128] et au [137]. Faites votre choix.";
    }
}
