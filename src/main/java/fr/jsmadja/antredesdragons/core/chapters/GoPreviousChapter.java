package fr.jsmadja.antredesdragons.core.chapters;

import fr.jsmadja.antredesdragons.core.entities.Pip;
import fr.jsmadja.antredesdragons.core.execution.Execution2;

import java.util.List;

import static fr.jsmadja.antredesdragons.core.execution.Action.goChapter;

public abstract class GoPreviousChapter extends Chapter {

    protected abstract void beforeGoBack(Pip pip);

    @Override
    public Execution2 execute2(Pip pip) {
        this.beforeGoBack(pip);
        return Execution2.builder()
                .logEntries(pip.getCurrentChapterLogEntries())
                .actions(List.of(goChapter(pip.getPreviousChapter())))
                .build();
    }
}
