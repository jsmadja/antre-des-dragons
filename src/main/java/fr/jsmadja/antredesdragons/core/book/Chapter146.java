package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.Answer;
import fr.jsmadja.antredesdragons.core.chapters.ManualChoiceChapter;
import fr.jsmadja.antredesdragons.core.chapters.YesOrNoQuestion;
import fr.jsmadja.antredesdragons.core.entities.Pip;
import fr.jsmadja.antredesdragons.core.execution.Action;
import fr.jsmadja.antredesdragons.core.execution.Execution;

import java.util.ArrayList;
import java.util.List;

import static fr.jsmadja.antredesdragons.core.chapters.ChapterNumber.chapter;

public class Chapter146 extends ManualChoiceChapter {
    @Override
    public Paths getPossiblesPath(Pip pip) {
        return new Paths(
                Path.builder().description("Aller dans le passage 114").chapter(114).build(),
                Path.builder().description("Aller dans le passage 128").chapter(128).build(),
                Path.builder().description("Aller dans le passage 137").chapter(137).build());
    }

    @Override
    public Execution execute(Pip pip, String questionId, Answer answer) {
        if (questionId == null) {
            YesOrNoQuestion question = YesOrNoQuestion.question("Q146", "Avez-vous déchiffré le parchemin");
            List<Action> actions = new ArrayList<>(question.toActionsForChapter(chapter(146)));
            return Execution.builder().logEntries(pip.getCurrentChapterLogEntries()).actions(actions).build();
        }
        if (questionId.equals("Q146") && answer.isYes()) {
            pip.addExperiencePoints(1);
        }
        return super.execute(pip);
    }

    @Override
    public String getText() {
        return "Le coffre n° 2 contient un flacon où se lit clairement l'inscription : Antidote au venin " +
                "de Serpent, qui pourrait se révéler utile en cas de morsure de Serpent. Il y en a " +
                "suffisament pour une dose, qui neutralisera complètement le venin, vous laissant le " +
                "total de POINTS DE VIE dont vous disposiez avant d'être mordu.\n" +
                "Le coffre n° 3 contient un rouleau sur lequel est écrit : " +
                "NPJ, FUIFMCFSU, NPJOF FU, N'FUBON MJF E'BNJUJF BWFD MF NPOTUSF B " +
                "UFUF EF UBVSFBV BGGJSNF RVF TFVMF MB DMFG DPOUFOVF EBOT MF " +
                "DPGGSFU QFVU QFSNFUUSF M'BDDFT B M'BOUSF EFT DSBDIFVST EF " +
                "GFV.\n" +
                "Ce qui n'éclaire guère votre lanterne, à moins que vous ne parveniez à déchiffrer le " +
                "code. (Et encore !) Comme l'avait prédit le Minotaure, les autres coffres ont disparu. " +
                "Les passages pour sortir de la grotte du Minotaure conduisent au 114, au 128 et au " +
                "137. Faites votre choix !";
    }
}
