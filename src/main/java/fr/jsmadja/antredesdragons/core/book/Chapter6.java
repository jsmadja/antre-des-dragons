package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.Chapter;
import fr.jsmadja.antredesdragons.core.chapters.Execution;
import fr.jsmadja.antredesdragons.core.entities.Foe;
import fr.jsmadja.antredesdragons.core.entities.Pip;
import fr.jsmadja.antredesdragons.core.fight.Fight;
import fr.jsmadja.antredesdragons.core.stuff.HealthPoints;
import fr.jsmadja.antredesdragons.core.stuff.Item;
import fr.jsmadja.antredesdragons.core.ui.Prompt;

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
    public Execution execute(Pip pip) {
        if (Prompt.answerTo("Voulez-vous combattre le Lapin Blanc").isNo()) {
            return pip.goToChapter(getSuccessChapter());
        }
        pip.setRollMalus(2);
        Fight fight = new Fight(pip, getFoe());
        fight.start();
        if (pip.isDead()) {
            return pip.goToChapter(14);
        }
        pip.setRollMalus(0);
        return pip.goToChapter(getSuccessChapter());
    }

    private int getSuccessChapter() {
        return 5;
    }

    private Foe getFoe() {
        Foe foe = Foe.builder()
                .name("Lapin Blanc")
                .initialHealthPoints(HealthPoints.hp(25))
                .build();
        foe.addAndEquip(Item.RABBIT_FANGS);
        return foe;
    }
}
