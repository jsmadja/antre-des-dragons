package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.entities.Foe;
import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.pages.MultipleFightPage;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Page157 extends MultipleFightPage {
    @Override
    protected int getSuccessPage() {
        return 162;
    }

    @Override
    protected List<Foe> getFoes(Pip pip) {
        return IntStream.range(1, 7).mapToObj(
                i -> {
                    Foe foe = Foe.builder()
                            .name("Forme #" + i)
                            .initialHealthPoints(4)
                            .constantHitDamage(15)
                            .build();
                    foe.loseInitiative();
                    return foe;
                }
        ).collect(Collectors.toList());
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
