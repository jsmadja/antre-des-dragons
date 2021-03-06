package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.ChapterNumber;
import fr.jsmadja.antredesdragons.core.chapters.DiceWay;
import fr.jsmadja.antredesdragons.core.chapters.RollAndGoChapter;
import fr.jsmadja.antredesdragons.core.entities.Pip;
import fr.jsmadja.antredesdragons.core.execution.Execution;
import fr.jsmadja.antredesdragons.core.spellcasting.SpellBook;
import fr.jsmadja.antredesdragons.core.spellcasting.SpellEffectResult;

import java.util.List;

import static fr.jsmadja.antredesdragons.core.skills.Skill.SWIMMING;
import static fr.jsmadja.antredesdragons.core.spellcasting.SpellEffectResult.SUCCESS;

public class Chapter132 extends RollAndGoChapter {
    @Override
    protected List<DiceWay> getDiceWays(Pip pip) {
        return List.of(
                DiceWay.builder().from(11).to(12).chapterNumber(ChapterNumber.chapter(124)).build(),
                DiceWay.builder().from(2).to(10).chapterNumber(ChapterNumber.chapter(14)).build()
        );
    }

    @Override
    public Execution execute(Pip pip) {
        if (pip.hasSpell(SpellBook.AEP) && pip.canUse(SpellBook.AEP)) {
            SpellEffectResult result = pip.use(SpellBook.AEP);
            if (result == SUCCESS) {
                return pip.goToChapter(124);
            }
            return execute(pip);
        }

        int roll = pip.roll2Dices().getValue() * 4;
        if (roll > pip.getInitialHealthPoints()) {
            pip.setInitialHealthPoints(roll);
            pip.add(SWIMMING);
            return pip.goToChapter(124);
        }

        return super.execute(pip);
    }

    @Override
    public String getText() {
        return "GLOU... Glou... Glou... Glou... C'est vous qui faites ces bruits. En vous noyant. Vous " +
                "voulez les entendre à nouveau ? " +
                "Glou... Glou... Glou... Glou... " +
                "Si vous vous noyez, c'est parce que le canot vient de " +
                "couler. Que pouvez-vous faire, maintenant ? " +
                "Votre sortilège AEP (si vous l'avez toujours, et si vous savez vous en servir) fera naître " +
                "autour de vous une bulle suffisamment remplie d'air pour vous permettre de survivre " +
                "assez longtemps pour gagner la rive. Rendez-vous au [124].\n" +
                "Par ailleurs, vous avez une vague chance d'apprendre à nager en un temps record " +
                "(certains apprennent vite, lorsque la nécessité les y contraint). Lancez les dé " +
                "exactement de la même façon que vous les avez lancés pour acquérir votre total de " +
                "départ de POINTS DE VIE. Si le nombre que vous obtenez est supérieur a votre total de " +
                "départ actuel, vous pouvez, d'une part le considérer dorénavant comme votre total de " +
                "départ de POINTS DE VIE et, d'autre part, vous pouvez ajouter la natation sur la liste de " +
                "vos multiples talents car, miracle, vous nagez comme un poisson.\n" +
                "Enfin, vous pouvez faire appel à la chance : lancez deux dés. Si vous faites 11 ou 12, " +
                "vous réussissez à gagner la rive en pataugeant tant bien que mal (vous pouvez utiliser " +
                "une Pierre de Chance, si vous en possédez une).\n" +
                "Si vous avez réussi à survivre à ce désastre par l'une ou l'autre de ces trois possibilités, " +
                "rendez-vous au [124]. Sinon, le [14], bien sûr.";
    }
}
