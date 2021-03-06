package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.ChapterNumber;
import fr.jsmadja.antredesdragons.core.chapters.DiceWay;
import fr.jsmadja.antredesdragons.core.chapters.RollAndGoChapter;
import fr.jsmadja.antredesdragons.core.entities.Pip;

import java.util.List;

public class Chapter52 extends RollAndGoChapter {
    @Override
    protected List<DiceWay> getDiceWays(Pip pip) {
        return List.of(
                DiceWay.builder().from(2).to(6).chapterNumber(ChapterNumber.chapter(14)).build(),
                DiceWay.builder().from(7).to(12).chapterNumber(ChapterNumber.chapter(10)).build()
        );
    }

    @Override
    public String getText() {
        return "Quelqu'un aime vraiment les plantes vertes. quand vous entrez dans cette chaumière, il " +
                "vous vient aussitôt à l'esprit l'image d'une charmante vieille dame s'affairant dans le " +
                "calme de son logis campagnard. La maison est absolument envahie par la verdure. Des " +
                "fougères... des palmiers nains... des caoutchoucs... des bonsaï... des plantes grimpantes. " +
                "Beaucoup de plantes grimpantes. Il y en a partout et elles bougent ! Elles s'enroulent " +
                "autour de vous. Pip ! Lancez deux dés pour voir si vous pouvez dégager le bras qui " +
                "manie l'épée.\n" +
                "Si vous faites de 2 à 6, vous êtes fermement immobilisé. Incapable de lutter, vous " +
                "serez lentement étranglé et digéré par les plantes grimpantes. Abrégez vos souffrances " +
                "en vous rendant immédiatement au [14] Si vous faites de 7 à 12, vous dégainez votre " +
                "épée. Dès lors, le problème est réglé. Vous hachez menu ces horribles plantes " +
                "grimpantes sans subir le moindre dommage. Ça leur apprendra ! Maintenant reprenez " +
                "votre carte et allez explorer une autre partie du village.";
    }
}
