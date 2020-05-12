package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.Answer;
import fr.jsmadja.antredesdragons.core.chapters.Chapter;
import fr.jsmadja.antredesdragons.core.chapters.Execution;
import fr.jsmadja.antredesdragons.core.chapters.YesOrNoQuestion;
import fr.jsmadja.antredesdragons.core.entities.Foe;
import fr.jsmadja.antredesdragons.core.entities.Pip;
import fr.jsmadja.antredesdragons.core.fight.Fight;

import static fr.jsmadja.antredesdragons.core.chapters.ChapterNumber.chapter;
import static fr.jsmadja.antredesdragons.core.chapters.YesOrNoQuestion.question;

public class Chapter6 extends Chapter {
    @Override
    public String getText() {
        return "Il vous a mordu à la rotule ! Cette sale petite bête a bondi, et elle vous a planté ses " +
                "crocs répugnants dans le genou jusqu'à l'os, vous infligeant une cruelle douleur. Si " +
                "vous voulez combattre cet animal déduisez 2 points à chaque fois que vous lanceriez " +
                "les dés pour vous-même, en raison de votre jambe blessée.\n" +
                "Le Lapin Blanc possède 25 POINTS DE VIE, et des crocs qui lui valent + 3 Points de " +
                "Dommage. Il n'a besoin que d'un minimum de 5 pour attaquer, à condition qu'il frappe " +
                "en dessous d'un mètre de hauteur (ce qu'il fera, car il n'est pas idiot). " +
                "Si vous préférez vous enfuir, rendez-vous au [5]. Si vous combattez le Lapin Blanc, et " +
                "qu'il vous tue, rendez-vous au [14].";
    }

    @Override
    public Execution execute(Pip pip, String questionId, Answer answer) {
        if (answer != null) {
            if (answer.isNo()) {
                return pip.goToChapter2(chapter(getSuccessChapter()));
            }
            pip.setRollMalus(2);
            Fight fight = new Fight(pip, createFoe());
            fight.start();
            if (pip.isDead()) {
                return pip.goToChapter2(chapter(14));
            }
            pip.setRollMalus(0);
            return pip.goToChapter2(chapter(getSuccessChapter()));
        }
        YesOrNoQuestion question = question("Q6", "Voulez-vous combattre le Lapin Blanc");
        return Execution.builder()
                .logEntries(pip.getCurrentChapterLogEntries())
                .actions(question.toActionsForChapter(chapter(6)))
                .build();
    }

    private int getSuccessChapter() {
        return 5;
    }

    private Foe createFoe() {
        return getFoeFactory().createWhiteRabbit();
    }

}
