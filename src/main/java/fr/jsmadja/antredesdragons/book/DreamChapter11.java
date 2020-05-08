package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.chapters.DreamChapter;
import fr.jsmadja.antredesdragons.chapters.Execution;
import fr.jsmadja.antredesdragons.entities.Pip;

public class DreamChapter11 extends DreamChapter {
    @Override
    public String getText() {
        return "A la suite d'un désaccord avec le roi Arthur sur la question de savoir si la terre " +
                "était plate ou ronde, vous avez été jeté sans eau ni nourriture au fond d'une sinistre " +
                "oubliette. La durée de votre séjour dans ce cul-de-basse-fosse dépend des résultats de " +
                "votre prochain lancer de dé. (Un seul dé.) Pour chaque point marqué jusqu'à un " +
                "maximum de 6, vous y restez un jour et vous perdez 1 POINT DE VIE avant que la colère " +
                "du Roi ne s'apaise.";
    }

    @Override
    public Execution execute(Pip pip) {
        pip.wounds(pip.roll1Dice().toHealthPoints());
        return super.execute(pip);
    }
}
