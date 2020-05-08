package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.chapters.Execution;
import fr.jsmadja.antredesdragons.chapters.GoNextChapter;

import static fr.jsmadja.antredesdragons.stuff.Item.TINKLE_RING;

public class Chapter111 extends GoNextChapter {
    @Override
    public int getNextChapter() {
        return 99;
    }

    @Override
    public Execution execute(Pip pip) {
        if (!this.isVisited()) {
            pip.add(TINKLE_RING);
        }
        return super.execute(pip);
    }

    @Override
    public String getText() {
        return "Vous avez trouvé un anneau ! Il s'adapte parfaitement au doigt de votre main gauche. " +
                "Le problème c'est qu'après l'avoir essayé, vous ne pouvez plus le retirer. Et il tinte " +
                "légèrement. Un tintement ? A quoi peut bien rimer ce tintement? Mais peu importe " +
                "pour l'instant. Revenez au [99], et décidez de la direction à prendre.";
    }
}