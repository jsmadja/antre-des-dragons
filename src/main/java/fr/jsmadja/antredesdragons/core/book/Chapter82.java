package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.SingleFightChapter;
import fr.jsmadja.antredesdragons.core.entities.Foe;

import static fr.jsmadja.antredesdragons.core.stuff.HealthPoints.hp;

public class Chapter82 extends SingleFightChapter {
    @Override
    protected int getSuccessChapter() {
        return 11;
    }

    @Override
    protected Foe createFoe() {
        return Foe.builder().name("Loup Siffleur").initialHealthPoints(hp(15)).build();
    }

    @Override
    public String getText() {
        return "Quel est ce bruit ? Quelqu'un siffle, juste derrière cet arbre. Peut-être sait-il comment " +
                "sortir de ce bois stupide. Vivement, vous plongez dans les taillis, et vous rampez en " +
                "direction du sifflement. Vous parvenez au pied d'un arbre, et vous vous redressez à " +
                "l'abri de son tronc. Sapristi, c'est un Loup ! Ce sifflement était celui d'un Loup ! " +
                "Essayez d'obtenir de lui une Réaction Amicale, vite ! Si vous échouez, dégainez E.J., " +
                "(« Se battre si rapidement ? marmonne E.J., tu ne peux pas me laisser un peu en paix " +
                "? ») et, à l'attaque !\n" +
                "Le Loup Siffleur possède 15 POINTS DE VIE, mais ses dents sont émoussées. Il ne" +
                "vous infligera donc pas plus de Points de Dommage que ceux indiqués par les dés.\n" +
                "Si vous gagnez le combat, ou si vous avez obtenu une Réaction Amicale, rendez-vous\n" +
                "au [11]. Sinon vous êtes bon pour le redoutable (et redouté) [14].";
    }
}
