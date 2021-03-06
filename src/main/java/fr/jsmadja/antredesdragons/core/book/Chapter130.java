package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.Answer;
import fr.jsmadja.antredesdragons.core.chapters.ManualChoiceChapter;
import fr.jsmadja.antredesdragons.core.chapters.YesOrNoQuestion;
import fr.jsmadja.antredesdragons.core.entities.Pip;
import fr.jsmadja.antredesdragons.core.execution.Action;
import fr.jsmadja.antredesdragons.core.execution.Execution;
import fr.jsmadja.antredesdragons.core.spellcasting.SpellEffectResult;

import java.util.ArrayList;
import java.util.List;

import static fr.jsmadja.antredesdragons.core.chapters.ChapterNumber.chapter;
import static fr.jsmadja.antredesdragons.core.spellcasting.SpellBook.INVISIBILITY;
import static fr.jsmadja.antredesdragons.core.spellcasting.SpellEffectResult.SUCCESS;

public class Chapter130 extends ManualChoiceChapter {
    @Override
    public Paths getPossiblesPath(Pip pip) {
        return new Paths(
                Path.builder().description("Aller au 128").chapter(128).build(),
                Path.builder().description("Aller au 138").chapter(138).build()
        );
    }

    @Override
    public Execution execute(Pip pip, String questionId, Answer answer) {
        List<Action> actions = new ArrayList<>();
        if (questionId == null) {
            if (pip.hasSpell(INVISIBILITY)) {
                YesOrNoQuestion question = YesOrNoQuestion.question("Q130-1", "Voulez-vous utiliser le sort d'invisibilité");
                actions.addAll(question.toActionsForChapter(chapter(130)));
            }
            YesOrNoQuestion question = YesOrNoQuestion.question("Q130-2", "Voulez-vous combattre la Méduse");
            actions.addAll(question.toActionsForChapter(chapter(130)));
            return Execution.builder().logEntries(pip.getCurrentChapterLogEntries()).actions(actions).build();
        }
        if (questionId.equals("Q130-1") && answer.isYes()) {
            SpellEffectResult result = pip.use(INVISIBILITY);
            if (result == SUCCESS) {
                return super.execute(pip);
            }
        }
        if (questionId.equals("Q130-2") && answer.isYes()) {
            return pip.goToChapter(136);
        }
        if (pip.roll2Dices().isBetween(2, 6)) {
            return super.execute(pip);
        }
        return pip.goToChapter(14);
    }

    @Override
    public String getText() {
        return "Ouaoh ! Ce doit être votre jour de chance, Pip. Le passage vient de déboucher dans " +
                "une grotte, et votre torche illumine le plus fabuleux amas de joyaux, d'argent, d'or, de " +
                "vermeil, de jade, d'ivoire, d'objets d'art, que vous ayez jamais vu. Il y a là la rançon " +
                "d'un roi, un trésor qui dépasse les rêves les plus fous de l'avare le plus sordide. " +
                "Comparée à cette caverne, la fameuse salle du trésor du Sorcier Ansalom ressemble à " +
                "la guérite du caissier d'un cirque de troisième ordre. Il doit y avoir des millions ici, " +
                "peut- être des milliards. Diamants, rubis, saphirs, émeraudes, zircons, perles... par " +
                "centaines, par milliers, amassés là en un énorme tas, attendant qu'on les enfourne dans " +
                "un sac à dos ! Ce doit être le légendaire Trésor du Dragon, les rançons extorquées " +
                "contre la libération de jeunes filles enlevées, les trésors arrachés aux monastères ou " +
                "aux châteaux mis au pillage, tout le butin rassemblé pendant des siècles par des " +
                "générations de Dragons déchaînés. Tout est là, attendant simplement la venue d'un " +
                "courageux aventurier tel que vous. Voilà qui pourrait changer radicalement votre " +
                "façon de vivre, Pip. Avec ça, vous pourriez vous offrir un château... des douzaines de " +
                "châteaux... Vous pourriez... Mais vous savez parfaitement ce que vous pourriez vous " +
                "offrir Pour mettre la main sur ce trésor, ou du moins tout ce que vous pouvez porter, " +
                "ce qui est déjà énorme, il vous suffit de persuader la dame à l'étrange chevelure de " +
                "vous laisser vous servir. La dame à l'étrange chevelure ? Mais ce n'est pas des cheveux " +
                "qu'elle a sur la tête, mais des serpents ! Serait-ce la Méduse, cette créature mythique " +
                "dont un seul regard vous transforme en pierre ? A ce propos, d'ailleurs, plusieurs " +
                "statutes d'un grand réalisme sont disséminées çà et là autour du trésor. Mais pensez à " +
                "tout ce butin, Pip. Pensez à tout ce qu'il vous permettrai: d'obtenir. " +
                "Pour emporter une partie de ce trésor, vous allez devoir combattre la Méduse. Si vous " +
                "optez pour cette solution, rendez-vous au [136]. " +
                "Si vous estimez que la discrétion est l'essence même du courage (et qui a besoin d'un " +
                "pareil butin, de toute façon ?), vous pouvez utiliser votre sortilège INVISIBILITÉ " +
                "pour sortir de cette grotte sans être vu.\n" +
                "Si vous ne voulez pas utiliser ici votre sortilège, vous pouvez essayer de vous défiler " +
                "sur la pointe des pieds. Pour savoir si vous avez réussi, lancez deux dés. Si vous faites " +
                "de 2 à 6, vous êtes sorti sans avoir été repéré. Si vous faites de 7 à 12, la Méduse jette " +
                "un bref regard dans votre direction. Sans mot dire, vous vous rendez au [14].\n" +
                "Les galeries permettant de sortir de cette caverne mènent au [138], et au [128].";
    }
}
