package fr.jsmadja.antredesdragons.core.chapters;

import fr.jsmadja.antredesdragons.core.diary.LogEntries;
import fr.jsmadja.antredesdragons.core.entities.Foe;
import fr.jsmadja.antredesdragons.core.entities.Pip;

import java.util.List;

import static fr.jsmadja.antredesdragons.core.chapters.ChapterNumber.chapter;
import static fr.jsmadja.antredesdragons.core.execution.Action.goChapter;

public abstract class MultipleFightChapter extends Chapter {
    @Override
    public Execution execute(Pip pip) {
        onBeforeFight(pip);
        List<Foe> foes = createFoes(pip);
        pip.fight(foes, getRequiredDeadFoesSize(pip));
        LogEntries foesLogEntries = foes.stream().map(Foe::getLogEntries).reduce(LogEntries::add).orElse(new LogEntries());
        if (pip.isDead()) {
            return pip.goToChapter2(chapter(14))
                    .add(foesLogEntries);
        }
        onAfterSuccessfulFight(pip);
        return Execution.builder()
                .logEntries(foesLogEntries)
                .foes(foes)
                .actions(List.of(goChapter(chapter(getSuccessChapter()))))
                .build();
    }

    protected void onBeforeFight(Pip pip) {
    }

    protected void onAfterSuccessfulFight(Pip pip) {
    }

    protected abstract int getSuccessChapter();

    protected abstract List<Foe> createFoes(Pip pip);

    public int getRequiredDeadFoesSize(Pip pip) {
        return this.createFoes(pip).size();
    }
}
