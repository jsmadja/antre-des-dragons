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
import static fr.jsmadja.antredesdragons.core.inventory.Item.FIREBALL;

public class Chapter99 extends ManualChoiceChapter {
    @Override
    public String getText() {
        return "Le passage, qui semble fort fréquenté, débouche quelques deux cents mètres plus loin " +
                "sur une immense caverne, dont la suffocante puanteur vous prend à la gorge. Votre " +
                "torche vous révèle bientôt l'origine de cette odeur : au centre de la caverne est amassé " +
                "un énorme monceau de déjections de Dragons. Vous portez aussitôt la main à la garde " +
                "de votre épée, mais une brève inspection des lieux vous amène à la conclusion qu'il n'y " +
                "a, pour le moment, aucun Dragon dans les parages. Posté au centre de a caverne, tout " +
                "près du tas de fumier, vous constatez qu'il existe trois issues possibles. " +
                "Si vous empruntez le passage ouest, rendez-vous au [98]. " +
                " " +
                "Si vous empruntez le passage nord, rendez-vous au [105]. " +
                "Le passage est presque totalement obstrué par un enorme bloc de rocher. Si vous " +
                "désirez partir dans cette direction, lancez deux dés pour savoir si vous êtes " +
                "suffisamment fort pour déplacer ce rocher. Si vous faites de 2 à 6, il ne bouge pas d'un " +
                "millimètre. Si vous faites de 7 à 12, vous réussissez, malgré son poids, à le déplacer, et " +
                "vous pouvez vous faufiler dans le passage. Rendez-vous au [102]. " +
                "Si vous le désirez, vous pouvez utiliser ici l'une de vos précieuses Boules de Feu. Si " +
                "tout se passe bien, elle pulvérisera le rocher, vous permettant ainsi d'emprunter le " +
                "passage. Rendez-vous au [102]. Enfin, vous pouvez farfouiller dans le tas de déjections " +
                "(perspective révoltante !) pour voir s'il ne cache pas quelque chose d'intéressant, avant " +
                "de quitter la caverne. Rendez-vous dans ce cas au [111].";
    }

    @Override
    public Execution execute(Pip pip, String questionId, Answer answer) {
        if (questionId == null) {
            List<Action> actions = new ArrayList<>();
            actions.addAll(YesOrNoQuestion.question("Q99-1", "Voulez vous déplacer le rocher").toActionsForChapter(chapter(99)));
            if (pip.has(FIREBALL)) {
                actions.addAll(YesOrNoQuestion.question("Q99-2", "Voulez-vous utiliser une boule de feu").toActionsForChapter(chapter(99)));
            }
            return Execution.builder().logEntries(pip.getCurrentChapterLogEntries()).actions(actions).build();
        }

        if (questionId.equals("Q99-1") && answer.isYes()) {
            if (pip.roll2Dices().isBetween(7, 12)) {
                return pip.goToChapter(102);
            }
        }
        if (questionId.equals("Q99-2") && pip.has(FIREBALL) && answer.isYes()) {
            pip.remove(FIREBALL);
            return pip.goToChapter(102);
        }
        return super.execute(pip);
    }

    @Override
    public Paths getPossiblesPath(Pip pip) {
        return new Paths(
                Path.builder().description("Emprunter le passage ouest").chapter(98).build(),
                Path.builder().description("Emprunter le passage nord").chapter(105).build(),
                Path.builder().description("Fouiller les tas de déjections").chapter(111).build()
        );
    }
}
