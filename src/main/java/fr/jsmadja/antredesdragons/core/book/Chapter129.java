package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.Execution;
import fr.jsmadja.antredesdragons.core.chapters.ManualChoiceChapter;
import fr.jsmadja.antredesdragons.core.entities.Pip;

import static fr.jsmadja.antredesdragons.core.ui.Prompt.answerTo;

public class Chapter129 extends ManualChoiceChapter {

    @Override
    public Paths getPossiblesPath(Pip pip) {
        return new Paths(
                Path.builder().description("Aller vers le premier passage").chapter(114).build(),
                Path.builder().description("Aller vers le deuxième passage").chapter(128).build(),
                Path.builder().description("Aller vers le troisième passage").chapter(137).build()
        );
    }

    @Override
    public Execution execute(Pip pip) {
        if (answerTo("Avez-vous déchiffré le parchemin").isYes()) {
            pip.addExperiencePoints(1);
        }
        return super.execute(pip);
    }

    @Override
    public String getText() {
        return "Comme c'est intéressant. La cassette contient une grande clef. Le coffre, en revanche,\n" +
                "ne contient qu'un parchemin. Sur ce parchemin est inscrit :\n" +
                "NPJ, FUIFMCFSU, NPJOF FU, N'FUBON MJF E'BNJUJF BWFD MF NPOTUSF B\n" +
                "UFUF EF UBVSFBV BGGJSNF RVF TFVMF MB DMFG DPOUFOVF EBOT MF \n" +
                "DPGGSFU QFVU QFSNFUUSF M'BDDFT B M'BOUSF EFT DSBDIFVST EF\n" +
                "GFV.\n" +
                "Ce qui n'éclaire guère votre lanterne, à moins que Vous ne réussissiez à déchiffrer le\n" +
                "code. Comme l'avait prédit le Minotaure, les autres coffres ont disparu. Les passages\n" +
                "partant de la grotte du Minotaure conduisent au [114], au [128] et au [137]. Faites votre\n" +
                "choix !";
    }

}
