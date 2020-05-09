package fr.jsmadja.antredesdragons.core.chapters;

import fr.jsmadja.antredesdragons.core.entities.Pip;
import fr.jsmadja.antredesdragons.core.execution.Execution2;

import java.util.List;

import static fr.jsmadja.antredesdragons.core.chapters.ChapterNumber.chapter;
import static fr.jsmadja.antredesdragons.core.execution.Action.goChapter;

public abstract class GoNextChapter extends Chapter {

    protected void beforeLeavingChapter(Pip pip) {
    }

    public abstract int getNextChapter();

    @Override
    public Execution2 execute2(Pip pip) {
        beforeLeavingChapter(pip);
        return Execution2.builder()
                .logEntries(pip.getCurrentChapterLogEntries())
                .actions(List.of(goChapter(chapter(getNextChapter()))))
                .build();
    }
}
