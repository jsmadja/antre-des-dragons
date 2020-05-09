package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.SingleFightChapter;
import fr.jsmadja.antredesdragons.core.entities.Foe;
import fr.jsmadja.antredesdragons.core.entities.Pip;
import fr.jsmadja.antredesdragons.core.execution.Execution2;
import fr.jsmadja.antredesdragons.core.skills.InstantKillWithStrikesInARowSpecialSkill;

import static fr.jsmadja.antredesdragons.core.chapters.ChapterNumber.chapter;
import static fr.jsmadja.antredesdragons.core.inventory.Item.RAMPANT_TONGUE;
import static fr.jsmadja.antredesdragons.core.stuff.HealthPoints.hp;

public class Chapter153 extends SingleFightChapter {

    @Override
    public Execution2 execute2(Pip pip) {
        if (pip.roll2Dices().isBetween(9, 12)) {
            pip.die();
            return pip.goToChapter2(chapter(14));
        }
        return super.execute2(pip);
    }

    @Override
    protected int getSuccessChapter() {
        return 154;
    }

    @Override
    protected Foe createFoe() {
        Foe foe = Foe.builder()
                .name("Rampant")
                .initialHealthPoints(hp(20))
                .build();
        foe.addAndEquip(RAMPANT_TONGUE);
        foe.add(new InstantKillWithStrikesInARowSpecialSkill(1));
        return foe;
    }

    @Override
    public String getText() {
        return "Un court passage, orienté vers le sud-est, aboutit brusquement au sommet d'une volée " +
                "de marches. Taillées grossièrement, — très grossièrement — elles sont maintenant " +
                "lisses et usées comme si d'innombrables pieds les avaient foulées durant des éternités. " +
                "Mais quels pieds ? Certainement pas ceux d'aventuriers, car seul un aventurier robuste, " +
                "courageux et intelligent a pu survivre assez longtemps pour parvenir jusqu'ici ; ces " +
                "êtres-là sont rares. Non, Pip. Ces marches ont été usées par quelque créature des " +
                "cavernes, par quelque maléfique créature des ténèbres. Avez-vous perçu un son, audessous de vous? Un son ténu, sinistre. Un frôlement... La créature qui monte en " +
                "rampant le long des marches a plus de deux mètres de long. Verte, les yeux rouge " +
                "sang, elle darde furieusement devant elle une langue effilée, une très longue langue " +
                "palpitante, qui se termine par un bulbe. Clac ! La langue se détend comme un fouet " +
                "dans votre direction. Lancez deux dés pour savoir si vous êtes assez rapide pour " +
                "l'éviter.\n" +
                "Si vous faites :\n" +
                "de 2 à 8 : vous avez réussi à l'éviter, de 9 à 12 : la langue s'enroule autour de vous, et " +
                "vous attire inéluctablement vers une gueule béante. Prenez le temps d'être digéré, puis " +
                "rendez-vous au [14].\n" +
                "Même si vous avez échappé à la langue du monstre, vous n'êtes pas pour autant sorti " +
                "de l'auberge ! Cela vous donne simplement l'occasion de combattre le Rampant (le " +
                "propriétaire de la langue). La créature ne possède pas plus de 20 POINTS DE VIE, " +
                "mais si elle réussit à frapper un seul coup, vous êtes pris au piège, et digéré. Le " +
                "Rampant réussit à porter un coup s'il sort, au minimum, un 8... Si vous perdez la vie au " +
                "cours du combat, rendez-vous au [14].\n" +
                "Si vous tuez le Rampant (et bon débarras, si vous y parvenez), rendez-vous au [154].";
    }
}
