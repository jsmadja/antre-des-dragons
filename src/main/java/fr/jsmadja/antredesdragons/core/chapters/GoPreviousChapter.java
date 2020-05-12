package fr.jsmadja.antredesdragons.core.chapters;

import fr.jsmadja.antredesdragons.core.entities.Pip;

import java.util.List;

import static fr.jsmadja.antredesdragons.core.execution.Action.goChapter;

public abstract class GoPreviousChapter extends Chapter {

    protected abstract void beforeGoBack(Pip pip);

    @Override
    public Execution execute(Pip pip) {
        this.beforeGoBack(pip);
        return Execution.builder()
                .logEntries(pip.getCurrentChapterLogEntries())
                .actions(List.of(goChapter(pip.getPreviousChapter())))
                .build();
    }
}
