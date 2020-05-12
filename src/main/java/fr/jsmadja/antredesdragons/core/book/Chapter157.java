package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.MultipleFightChapter;
import fr.jsmadja.antredesdragons.core.entities.Foe;
import fr.jsmadja.antredesdragons.core.entities.Pip;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;

public class Chapter157 extends MultipleFightChapter {
    @Override
    protected int getSuccessChapter() {
        return 162;
    }

    @Override
    protected List<Foe> createFoes(Pip pip) {
        return range(1, 7).mapToObj(i -> getFoeFactory().createForm(i)).collect(toList());
    }

    @Override
    public String getText() {
        return "Vous voilà bien agressif, n'est-ce pas ? Eh bien, puisque vous avez décidé d'attaquer, " +
                "c'est vous qui frappez en premier ces petites horreurs. Ce qui vaut peut-être mieux pour " +
                "vous.\n" +
                "Chaque Forme ne possède que 4 POINTS DE VIE. Un seul coup peut donc la tuer. " +
                "Mais le problème, c'est que si vous ne vous en débarrassez pas du premier coup, La " +
                "Forme va pénétrer dans votre corps, et s'y fondre lentement, vous faisant perdre 15 " +
                "POINTS DE VIE ! Bien entendu, elle se détruit alors d'elle-même, mais c'est une " +
                "piètre consolation, n'est-ce pas ? Les Formes attaquent à tour de rôle, et n'oubliez pas " +
                "qu'elles sont au nombre de six. Bonne chance !\n" +
                "Si vous sortez vainqueur de ce combat, rendez-vous au [162]. Sinon, rendez-vous au [14].";
    }
}
