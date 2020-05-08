package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.chapters.ChapterNumber;
import fr.jsmadja.antredesdragons.chapters.DiceWay;
import fr.jsmadja.antredesdragons.chapters.Execution;
import fr.jsmadja.antredesdragons.chapters.RollAndGoChapter;
import fr.jsmadja.antredesdragons.entities.Pip;

import java.util.List;

import static fr.jsmadja.antredesdragons.spellcasting.SpellBook.INVISIBILITY;
import static fr.jsmadja.antredesdragons.ui.Prompt.answerTo;

public class Chapter137 extends RollAndGoChapter {
    @Override
    public String getText() {
        return "La caverne dans laquelle vous venez de pénétrer est complètement tapissée de métal ! " +
                "Sol, murs et plafond ! Et le mur nord tout entier est occupé par des rangées et des " +
                "rangées d'énormes machines. Elles ne peuvent en aucun cas être l'œuvre de Dragons ! " +
                "Ou de qui que ce soit d'autre ayant vécu du temps du roi Arthur. Si vous n'étiez pas un " +
                "personnage du vingtième siècle occupant un autre corps, vous seriez peut-être tenté de " +
                "penser qu'il s'agit là de magie. Mais vous venez précisément du vingtième siècle, et " +
                "vous savez très bien que vous avez devant vous une sorte de machine géante. Mais qui " +
                "l'a fabriquée ? Comment est-elle arrivée ici ? Et à quoi sert-elle ? Quel mystère ! " +
                "Quelle énigme ! Quelle glorieuse occasion de fouiner par-ci par-là et de vous attirer " +
                "ainsi les pires ennuis !\n" +
                "Vous seriez sans doute fort tenté de vous diriger tout droit vers ce panneau de contrôle " +
                "du mur nord, si vous n'étiez pas retenu par un petit détail. Douze Nains bossus (pas  " +
                "moins) à la mine menaçante s'affairent autour de toute cette machinerie. Douze ! Un " +
                "aventurier, même de votre réputation et de votre expérience, peut-il les combattre tous " +
                "? Vous seul le savez.\n" +
                "Vous pouvez utiliser votre sortilège INVISIBILITÉ pour filer sain et sauf. Mais cela " +
                "implique que vous repartiez par où vous êtes venu, puisque cet endroit ne comporte " +
                "aucune autre sortie. Vous pouvez essayer de vous esquiver discrètement sur la pointe " +
                "des pieds. Si c'est le cas, lancez deux dés. Si vous faites de 2 à 8, vous vous éclipsez " +
                "sans que les Nains aient remarqué votre présence. Si vous faites de 9 à 12, ils vous ont " +
                "repéré et se jettent sur vous en poussant des cris terrifiants, auquel cas le combat est " +
                "inéluctable. Rendez-vous au [131]. Vous pouvez vous ruer sur les Nains en espérant les " +
                "mettre en pièces. Dans ce cas, rendez-vous au [131].";
    }

    @Override
    public Execution execute(Pip pip) {
        if (pip.canUse(INVISIBILITY) && answerTo("Utiliser le sort d'invisibilité").isYes() && pip.use(INVISIBILITY).withSuccess()) {
            return pip.goToPreviousChapter();
        }
        if (answerTo("Voulez-vous combattre les Nains").isYes()) {
            return pip.goToChapter(131);
        }
        return super.execute(pip);
    }

    @Override
    protected List<DiceWay> getDiceWays(Pip pip) {
        return List.of(
                DiceWay.builder().from(2).to(8).chapterNumber(pip.getPreviousChapter()).build(),
                DiceWay.builder().from(9).to(12).chapterNumber(ChapterNumber.chapter(131)).build()
        );
    }
}
