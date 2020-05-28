package fr.jsmadja.antredesdragons.core.chapters;

import fr.jsmadja.antredesdragons.core.diary.LogEntries;
import fr.jsmadja.antredesdragons.core.entities.Foe;
import fr.jsmadja.antredesdragons.core.entities.Pip;
import fr.jsmadja.antredesdragons.core.execution.Execution;

import java.util.List;

import static fr.jsmadja.antredesdragons.core.chapters.ChapterNumber.chapter;
import static fr.jsmadja.antredesdragons.core.execution.Action.goChapter;

public abstract class SingleFightChapter extends Chapter {

    @Override
    public Execution execute(Pip pip) {
        onBeforeFight(pip);
        Foe foe = createFoe();
        pip.fight(List.of(foe));
        LogEntries foeLogEntries = foe.getLogEntries();
        if (pip.isDead()) {
            return pip.goToChapter(chapter(14))
                    .withFoes(List.of(foe))
                    .add(foeLogEntries.add(pip.getCurrentChapterLogEntries()));
        }
        onAfterSuccessfulFight(pip);
        return Execution.builder()
                .logEntries(foeLogEntries.add(pip.getCurrentChapterLogEntries()))
                .foes(List.of(foe))
                .actions(List.of(goChapter(chapter(getSuccessChapter()))))
                .build();
    }

    protected void onBeforeFight(Pip pip) {
        if (!pip.hasBeenInitialized()) {
            throw new RuntimeException("Pip has not been initialized");
        }
    }

    protected void onAfterSuccessfulFight(Pip pip) {

    }

    protected abstract int getSuccessChapter();

    protected abstract Foe createFoe();

}
