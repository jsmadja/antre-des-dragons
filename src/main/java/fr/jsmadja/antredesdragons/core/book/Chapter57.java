package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.Answer;
import fr.jsmadja.antredesdragons.core.chapters.MultipleFightChapter;
import fr.jsmadja.antredesdragons.core.chapters.YesOrNoQuestion;
import fr.jsmadja.antredesdragons.core.entities.Foe;
import fr.jsmadja.antredesdragons.core.entities.Pip;
import fr.jsmadja.antredesdragons.core.execution.Action;
import fr.jsmadja.antredesdragons.core.execution.Execution;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static fr.jsmadja.antredesdragons.core.chapters.ChapterNumber.chapter;
import static java.util.stream.Collectors.toList;

public class Chapter57 extends MultipleFightChapter {
    @Override
    public String getText() {
        return "De près, le site n'est pas aussi impressionnant qu'il le paraissait de loin. En fait, il n'est " +
                "pas impressionnant du tout. Peut-être était-ce jadis une très belle abbaye, mais il n'en " +
                "reste guère que des ruines. Des murs croulants, ou près de s'écrouler. Et pourtant, les " +
                "lieux, sauf erreur, sont encore habités. venant vers vous, le visage dissimulé derrière le " +
                "volumineux capuchon de leurs volumineuses robes noires, six Moines s'approchent. " +
                "Comptez-les. Celui quj marche en tête porte une bannière brodée fixée au bout d'une " +
                "longue hampe. Vous levez les yeux vers la bannière. Elle est ornée d'une tête de mort " +
                "couleur or. Le suivant porte un encensoir dans lequel il doit brûler des vieilles " +
                "chaussettes, à en juger par la puanteur qui s'en dégage. Ils se tournent dans votre " +
                "direction. Ils psalmodient. Voici ce qu'ils chantent : « Viens avec nous, petit " +
                "aventurier, et reste avec nous à jamais.\n» " +
                "Si vous voulez rester avec eux à jamais, rendez-vous au [110]. " +
                "Si vous prenez vos jambes à votre cou séance tenante, vous pouvez reprendre votre " +
                "carte et explorer une autre partie du village. (Les Moines ne vous suivront pas en " +
                "dehors de leur abbaye.) Si vous vous demandez quelles sont vos chances en cas " +
                "d'échauffourée, sachez, et c'est une bonne nouvelle, que les deux premiers Moines " +
                "s'abstiendront d'intervenir. Les quatre autres, en revanche, sont des Moines Guerriers, " +
                "disposant chacun de 25 POINTS DE VIE. Ils combattent à mains nues, et ils vous " +
                "infligeront 3 Points de Dommage supplémentaires en plus de ceux qu'ils pourront vous  " +
                " " +
                "infliger normalement. Vous les combattrez chacun à leur tour. Mais ils sont si rapides, " +
                "qu'ils vous frapperont une fois tous les quatre avant que vous ne puissiez riposter " +
                "Ensuite, ils ne devront faire que 4 pour vous porter un coup. Maintenant c'est à vous de " +
                "savoir si vous voulez les affronter ou non. Dans le premier cas, si vous êtes vaincu, " +
                "rendez-vous au 14. Si vous êtes vainqueur, rendez-vous au [94].";
    }

    @Override
    public Execution execute(Pip pip, String questionId, Answer answer) {
        if (questionId == null) {
            List<Action> actions = new ArrayList<>();
            actions.addAll(YesOrNoQuestion.question("Q57-1", "Voulez-vous rester avec eux à jamais").toActionsForChapter(chapter(57)));
            actions.addAll(YesOrNoQuestion.question("Q57-2", "Voulez-vous rebrousser chemin").toActionsForChapter(chapter(57)));
            return Execution.builder().logEntries(pip.getCurrentChapterLogEntries()).actions(actions).build();
        }
        if (questionId.equals("Q57-1") && answer.isYes()) {
            return pip.goTo(chapter(110));
        }
        if (questionId.equals("Q57-2") && answer.isYes()) {
            return pip.goToPreviousChapter();
        }
        return super.execute(pip);
    }

    @Override
    protected void onBeforeFight(Pip pip) {
        pip.loseInitiative();
        super.onBeforeFight(pip);
    }

    @Override
    protected int getSuccessChapter() {
        return 94;
    }

    @Override
    protected List<Foe> createFoes(Pip pip) {
        return IntStream.range(1, 4).mapToObj(id -> getFoeFactory().createMonk(id)).collect(toList());
    }

}
