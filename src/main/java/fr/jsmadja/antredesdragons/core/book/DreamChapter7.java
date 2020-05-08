package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.DreamChapter;
import fr.jsmadja.antredesdragons.core.chapters.Execution;
import fr.jsmadja.antredesdragons.core.entities.Pip;

import static fr.jsmadja.antredesdragons.core.dices.Roll.roll;
import static fr.jsmadja.antredesdragons.core.stuff.HealthPoints.hp;

public class DreamChapter7 extends DreamChapter {
    @Override
    public String getText() {
        return "L'un des sortilèges de Merlin a échoué et vous a transformé en pied de céleri. Vous " +
                "poussez maintenant tranquillement dans un potager. C'est une existence supportable " +
                "car vous avez à vos côtés des choux et des choux-fleurs à qui parler, mais la chèvre de " +
                "Merlin a enfoncé la clôture et elle se rapproche dangereusement de vous en broutant.\n" +
                "Lancez un dé pour savoir si elle aime le céleri... Si vous faites moins de 6, elle va vous " +
                "grignoter 5 POINTS DE VIE avant de s'attaquer aux carottes de Merlin";
    }

    @Override
    public Execution execute(Pip pip) {
        if (pip.roll1Dice().isLesserThan(roll(6))) {
            pip.wounds(hp(5));
        }
        return super.execute(pip);
    }
}
