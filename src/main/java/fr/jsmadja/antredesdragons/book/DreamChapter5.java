package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.chapters.DreamChapter;
import fr.jsmadja.antredesdragons.chapters.Execution;
import fr.jsmadja.antredesdragons.entities.Pip;

import static fr.jsmadja.antredesdragons.chapters.ChapterNumber.chapter;
import static fr.jsmadja.antredesdragons.dices.Roll.roll;
import static fr.jsmadja.antredesdragons.stuff.HealthPoints.hp;

public class DreamChapter5 extends DreamChapter {
    @Override
    public String getText() {
        return "Vous essayez de vous enfuir de l'échauguette d'une haute tour et vous avez réussi à " +
                "vous glisser dans une étroite fenêtre, dans l'espoir de descendre en escalade la paroi " +
                "extérieure de la tour. En dépit de bonnes prises pour le bout des doigts et des pieds, la " +
                "surface de la pierre est très glissante. Lancez deux dés pour savoir si vous tombez. " +
                "Vous faites moins de 6 et c'est la chute libre ! Pendant que vous tombez, relancez deux " +
                "dés pour savoir si vous allez vous écraser au sol ou plonger dans l'eau des douves. Si " +
                "vous faîtes moins de 6, vous vous écrasez au sol et vous perdez 10 POINTS DE VIE.\n" +
                "Si vous faites 6, ou plus de " +
                "6 : vous tombez dans le fossé sans perdre de POINTS DE VIE, mais vous devez encore " +
                "lancer deux dés pour découvrir si vous savez nager. Si vous obtenez moins de 6, vous " +
                "ne savez pas nager, vous coulez à pic et vous vous rendez au [14].";
    }

    @Override
    public Execution execute(Pip pip) {
        if (pip.roll2Dices().isLesserThan(roll(6))) {
            if (pip.roll2Dices().isLesserThan(roll(6))) {
                pip.wounds(hp(10));
            } else if (pip.roll2Dices().isGreaterThan(roll(5))) {
                return pip.goTo(chapter(14));
            }
        }
        return super.execute(pip);
    }
}
