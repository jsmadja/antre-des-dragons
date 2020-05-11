package fr.jsmadja.antredesdragons.core.chapters;

import fr.jsmadja.antredesdragons.core.diary.LogEntries;
import fr.jsmadja.antredesdragons.core.entities.Foe;
import fr.jsmadja.antredesdragons.core.entities.Pip;
import fr.jsmadja.antredesdragons.core.execution.Execution2;

import java.util.List;

import static fr.jsmadja.antredesdragons.core.chapters.ChapterNumber.chapter;
import static fr.jsmadja.antredesdragons.core.execution.Action.goChapter;

public abstract class SingleFightChapter extends Chapter {

    @Override
    public Execution2 execute2(Pip pip) {
        onBeforeFight(pip);
        Foe foe = createFoe();
        pip.fight(List.of(foe));
        LogEntries foeLogEntries = foe.getLogEntries();
        if (pip.isDead()) {
            return pip.goToChapter2(chapter(14))
                    .add(foeLogEntries);
        }
        onAfterSuccessfulFight(pip);
        return Execution2.builder()
                .logEntries(foeLogEntries)
                .foes(List.of(foe))
                .actions(List.of(goChapter(chapter(getSuccessChapter()))))
                .build();
    }

    protected void onBeforeFight(Pip pip) {
    }

    protected void onAfterSuccessfulFight(Pip pip) {

    }

    protected abstract int getSuccessChapter();

    protected abstract Foe createFoe();

}
