package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.Chapter;
import fr.jsmadja.antredesdragons.core.chapters.Execution;
import fr.jsmadja.antredesdragons.core.entities.Pip;

public class Chapter164 extends Chapter {
    @Override
    public String getText() {
        return "Le couvercle du coffre s'ouvre brusquement. Mais au même instant, le rubis flamboie " +
                "brièvement dans une explosion de lumière rouge sang, puis s'effrite et tombe en " +
                "poussière. L'explosion vous coûte 30 POINTS DE VIE.\n" +
                "Si vous avez perdu la vie, rendez-vous au [14]. Sinon, rendez-vous au [169], pour " +
                "examiner le contenu du coffre.";
    }

    @Override
    public Execution execute(Pip pip) {
        pip.wounds(30);
        if (pip.isDead()) {
            return pip.goToChapter(14);
        }
        return pip.goToChapter(169);
    }
}
