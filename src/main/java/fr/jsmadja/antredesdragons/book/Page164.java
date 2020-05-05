package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.pages.Execution;
import fr.jsmadja.antredesdragons.pages.Page;

public class Page164 extends Page {
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
            return pip.goToPage(14);
        }
        return pip.goToPage(169);
    }
}
