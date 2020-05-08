package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.chapters.ChapterNumber;
import fr.jsmadja.antredesdragons.chapters.DiceWay;
import fr.jsmadja.antredesdragons.chapters.RollAndGoChapter;
import fr.jsmadja.antredesdragons.entities.Pip;

import java.util.List;

public class Chapter100 extends RollAndGoChapter {
    @Override
    protected List<DiceWay> getDiceWays(Pip pip) {
        return List.of(
                DiceWay.builder().from(2).to(6).chapterNumber(ChapterNumber.chapter(97)).build(),
                DiceWay.builder().from(7).to(12).chapterNumber(ChapterNumber.chapter(109)).build()
        );
    }

    @Override
    public String getText() {
        return "Vous avez un peu mal au ventre à présent. Et ça ne fait que s'aggraver. Vous n'auriez " +
                "peut-être pas dû ingurgiter autant de beignets. Ou tous ces gâteaux A moins que la " +
                "nourriture ne soit empoisonnée Aïe ! Elle est empoisonnée, en effet ! Vous sentez le " +
                "poison se répandre dans vos veines, envahir chaque cellule, chaque fibre de votre " +
                "corps. Cela n'a rien de drôle. Sortez vite vos dés pour savoir si vous allez être renvoyé " +
                "au fatidique [14].\n" +
                "Si vous faites :\n" +
                "de 2 à 6 : rendez-vous au [97].\n" +
                "de 7 à 12 : rendez-vous au [109].";
    }
}
