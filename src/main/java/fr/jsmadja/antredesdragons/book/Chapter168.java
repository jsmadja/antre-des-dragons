package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.entities.Foe;
import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.chapters.MultipleFightChapter;
import fr.jsmadja.antredesdragons.skills.DiesAfterNStrikesSpecialSkill;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Chapter168 extends MultipleFightChapter {
    @Override
    protected int getSuccessChapter() {
        return 162;
    }

    @Override
    protected List<Foe> getFoes(Pip pip) {
        return IntStream.range(1, 6).mapToObj(
                i -> {
                    Foe foe = Foe.builder()
                            .name("Forme #" + i)
                            .constantHitDamage(15)
                            .build();
                    foe.add(new DiesAfterNStrikesSpecialSkill(1));
                    return foe;
                }
        ).collect(toList());
    }

    @Override
    protected void onBeforeFight(Pip pip) {
        super.onBeforeFight(pip);
        pip.wounds(15);
    }

    @Override
    public String getText() {
        return "Les Formes volètent doucement dans votre direction, l'une d'elle précédant les autres. " +
                "Elles s'approchent de plus en plus, ces petites ombres silencieuses ! La Forme qui " +
                "vient en tête est presque sur vous. Elle effleure votre bras, légère, impalpable, puis, " +
                "sans vous causer la moindre douleur, elle pénètre en vous. Vous venez de perdre 15 " +
                "POINTS DE VIE, maladroit ! Et si vous venez de perdre aussi la vie, rendez-vous au " +
                "[14].\n" +
                "Les cinq autres Formes se dirigent vers vous les unes derrière les autres. Impossible " +
                "d'échapper au combat. Mais une bonne nouvelle est qu'il vous suffît de leur infliger 4 " +
                "Points de Dommage pour les tuer. La mauvaise nouvelle, c'est que si vous ne vous en " +
                "débarrassez pas du premier coup, la Forme va pénétrer dans votre corps et s'y fondre " +
                "lentement, vous faisant perdre 15 POINTS DE VIE. Bien entendu, elle se détruit alors " +
                "d'elle-même, mais c'est une piètre consolation, n'est-ce pas ? Les Formes attaquent à " +
                "tour de rôle, et n'oubliez pas qu'elles sont au nombre de six. Bonne chance ! " +
                "Si vous sortez vainqueur de ce combat, rendez-vous au [162]. Sinon, rendez-vous au [14].";
    }
}
