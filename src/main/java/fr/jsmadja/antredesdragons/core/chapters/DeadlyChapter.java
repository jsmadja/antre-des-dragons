package fr.jsmadja.antredesdragons.core.chapters;

import fr.jsmadja.antredesdragons.core.entities.Pip;

import java.util.List;

import static fr.jsmadja.antredesdragons.core.chapters.ChapterNumber.chapter;
import static fr.jsmadja.antredesdragons.core.execution.Action.goChapter;

public abstract class DeadlyChapter extends Chapter {
    @Override
    public Execution execute(Pip pip) {
        return Execution.builder()
                .logEntries(pip.getCurrentChapterLogEntries())
                .actions(List.of(goChapter(chapter(14))))
                .build();
    }
}
