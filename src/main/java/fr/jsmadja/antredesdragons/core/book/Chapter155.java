package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.GoPreviousChapter;
import fr.jsmadja.antredesdragons.core.entities.Pip;

public class Chapter155 extends GoPreviousChapter {
    @Override
    protected void beforeGoBack(Pip pip) {

    }

    @Override
    public String getText() {
        return "C'est une impasse ! Auriez-vous cru quelqu'un capable de vous jouer un tour pareil !\n" +
                "Tracer sur une carte un itinéraire qui aboutit à une impasse ! Vous qui avez peiné " +
                "durant des kilomètres pour arriver Là ! il est à craindre que la seule solution soit de " +
                "refaire tout ce trajet en sens inverse, et d'essayer un autre itinéraire.";
    }
}
