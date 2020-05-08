package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.GoNextChapter;

public class Chapter173 extends GoNextChapter {
    @Override
    public String getText() {
        return "La gigantesque carcasse du redoutable Dragon de Bronze gît à vos pieds, encore " +
                "palpitante. Vous vous dirigez vivement vers l'étincelante boule de cristal rouge et, d'un " +
                "revers de main, vous la faites tomber du piédestal. Elle se brise en mille morceaux sur " +
                "le sol rocheux.\n" +
                "Un silencieux éclair lumineux ! Devant vous, en robe souillée et déchirée, son épée à " +
                "double tranchant glissée à la ceinture, se dresse un moine corpulent et barbu, aux yeux " +
                "bruns luisants, aux sourcils broussailleux, aux cheveux hirsutes d'un noir de jais. — " +
                "Par l'orteil sacré de saint Paul, j'étais vraiment à l'étroit là-dedans ! grommelle-t-il. " +
                "Puis, s'inclinant légèrement, il se présente : Ethelbert, Moine Guerrier et fidèle " +
                "serviteur d'Arturus Rex, fils de Uthur Pendragon et légitime Suzerain du Royaume " +
                "d'Avalon, à votre service.\n" +
                "Il hésite, jette un coup d'oeil au Dragon de Bronze. —En somme, si je comprends bien, " +
                "tu n'as guère besoin de mes services aujourd'hui, Pip l'Aventurier, alors que j'ai mille " +
                "raisons de t'être reconnaissant de celui que tu m'as rendu. Mais du moins... Il hausse " +
                "les épaules et rajuste plus confortablement son épée à sa hanche. Je peux t'indiquer le " +
                "moyen de sortir d'ici afin que nous regagnions Camelot ensemble pour annoncer que le " +
                "Dragon de Bronze a cessé de menacer le royaume.";
    }

    @Override
    public int getNextChapter() {
        return 200;
    }
}
