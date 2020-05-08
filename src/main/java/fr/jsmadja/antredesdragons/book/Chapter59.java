package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.chapters.ChapterNumber;
import fr.jsmadja.antredesdragons.chapters.DiceWay;
import fr.jsmadja.antredesdragons.chapters.RollAndGoChapter;
import fr.jsmadja.antredesdragons.entities.Pip;

import java.util.List;

public class Chapter59 extends RollAndGoChapter {
    @Override
    public String getText() {
        return "Un vent violent se lève et vous avez de plus en plus de mal à rester cramponné contre " +
                "la paroi de la falaise. Même avec votre matériel, il faudrait être un grimpeur " +
                "expérimenté pour effectuer cette descente. Des rafales s'engouffrent dans vos " +
                "vêtements, vous secouent menaçant de vous arracher à vos prises et de vous envoyer " +
                "vous fracasser plus bas. Mais vous mobilisez toute l'énergie et toute la volonté que " +
                "vous possédez et vous vous agrippez farouchement. Vous avez les muscles noués par " +
                "l'effort, les membres douloureux. Mais votre détermination farouche et vos doigts " +
                "d'acier finissent par l'emporter... Du beau travail, vraiment, Pip ! Vous vous retrouvez " +
                "au fond du gouffre. Il ne reste plus maintenant qu'un petit problème à résoudre : " +
                "comment franchir le torrent furieux qui coule maintenant devant vous ? Vous " +
                "considérez la rive d'en face, vous rappelant peut-être pour la première fois que vous " +
                "ignorez si le corps de Pip que vous occupez a jamais appris à nager. Et votre seule " +
                "solution ici, c'est de traverser à la nage. Plongez courageusement dans les eaux " +
                "glacées, Pip, puis lancez les dés pour savoir ce qui va se passer.\n" +
                "Si vous faites :\n" +
                "de 2 à 6 : rendez-vous au 68.\n" +
                "de 7 à 12 : rendez-vous au 78.";
    }

    @Override
    protected List<DiceWay> getDiceWays(Pip pip) {
        return List.of(
                new DiceWay(2, 6, ChapterNumber.chapter(68)),
                new DiceWay(7, 12, ChapterNumber.chapter(78)));
    }
}
