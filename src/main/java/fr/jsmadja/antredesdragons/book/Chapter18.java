package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.chapters.DiceWay;
import fr.jsmadja.antredesdragons.chapters.RollAndGoChapter;

import java.util.List;

public class Chapter18 extends RollAndGoChapter {
    @Override
    public String getText() {
        return "Eh bien, voilà ! Vous rassemblez votre matériel et vous reculez le long du sentier pour " +
                "prendre le plus d'élan possible. Vous faites une profonde aspiration, vous touchez du " +
                "bois, (ce n'est pas ça qui manque dans la forêt) et vous foncez à toute allure vers le " +
                "gouffre. Lancez deux dés pour savoir si vous atterrissez sain et sauf de l'autre côté. (Et " +
                "bonne chance).\n" +
                "\n" +
                "Si vous faites :\n" +
                "de 2 à 6 : rendez-vous au [14].\n" +
                "de 7 à 12 : rendez-vous au [85].";
    }

    @Override
    protected List<DiceWay> getDiceWays(Pip pip) {
        return List.of(new DiceWay(2, 6, ChapterNumber.chapter(14)),
                new DiceWay(7, 12, ChapterNumber.chapter(85)));
    }
}
