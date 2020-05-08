package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.GoNextChapter;

public class Chapter97 extends GoNextChapter {
    @Override
    public int getNextChapter() {
        return 10;
    }

    @Override
    public String getText() {
        return "Ça va mieux maintenant, Pip? Espérons-le. Vous êtes jeune et robuste, doué d'un " +
                "physique avantageux , mais vous semblez en plus immunisé contre ce genre de poison.\n" +
                "Tout de même, veillez donc à ne pas vous bourrer de beignets, sinon vous allez vous " +
                "empâter. Maintenant, reprenez votre carte et continuez à explorer le village de la " +
                "Pierre-qui-Mue. Et cette fois, soyez plus prudent.";
    }
}
