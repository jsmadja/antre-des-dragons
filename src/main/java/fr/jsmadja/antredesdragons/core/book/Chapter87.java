package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.Chapter;
import fr.jsmadja.antredesdragons.core.chapters.Execution;
import fr.jsmadja.antredesdragons.core.entities.Pip;
import fr.jsmadja.antredesdragons.core.inventory.Item;

public class Chapter87 extends Chapter {
    @Override
    public String getText() {
        return "Voilà un Fantôme qui est bel et bien mort ! D'ici que cette aventure soit terminée, tout " +
                "le monde vous appellera Pip le Pourfendeur de Fantômes. Si vous n'êtes pas " +
                "surnommé, bien entendu, Pip le Pourfendeur de Dragons. Peut-être même secouera-ton la tête en disant : « Ce pauvre vieux Pip. Il s'est bien défendu, mais les monstres ont " +
                "fini par en venir à bout. » Mais en voilà assez. Il faut fouiller cette église. Et vous y " +
                "allez de bon cœur, mais il n'y a pas la moindre pièce de bronze, d'argent ou d'or à trouver, même dans le tronc. Le Fantôme, néanmoins, porte un anneau au doigt, et vous le " +
                "lui enlevez avec des gestes prudents pour le glisser à votre propre doigt. Il émet un " +
                "tintement quand vous le manipulez. Un tintement ! Serait-ce un anneau magique ? " +
                "Vous n'avez aucun moyen de le vérifier. Réjouissez- vous simplement de le posséder " +
                "et espérez qu'il vous sera utile par la suite. (Cela vaudrait mieux, à vrai dire car vous " +
                "ne pouvez plus le retirer de votre doigt.) Continuez votre chemin, Pip ! Continuez ! " +
                "retournez à votre carte, et explorez une autre partie du village.";
    }

    @Override
    public Execution execute(Pip pip) {
        pip.add(Item.GHOST_RING);
        return pip.goToChapter(10);
    }
}
