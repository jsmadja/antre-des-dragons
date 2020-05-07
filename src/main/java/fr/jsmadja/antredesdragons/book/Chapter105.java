package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.chapters.ManualChoiceChapter;

public class Chapter105 extends ManualChoiceChapter {
    @Override
    public Paths getPossiblesPath(Pip pip) {
        return new Paths(Path.builder().description("Pénétrer dans la caverne").chapter(114).build(),
                Path.builder().description("Prendre le couloir de droite").chapter(120).build());
    }

    @Override
    public String getText() {
        return "Vous vous trouvez non loin de l'entrée d'une autre caverne, et vous remarquez sur " +
                "votre droite, l'entree d un nouveau couloir.\n" +
                "Si vous voulez pénétrer dans la caverne, rendez-vous au [114].\n" +
                "Si vous préférez prendre le couloir de droite rendez- vous au [120].";
    }
}
