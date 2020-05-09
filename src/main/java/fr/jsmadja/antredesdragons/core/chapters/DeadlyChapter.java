package fr.jsmadja.antredesdragons.core.chapters;

import fr.jsmadja.antredesdragons.core.entities.Pip;
import fr.jsmadja.antredesdragons.core.execution.Execution2;

import java.util.List;

import static fr.jsmadja.antredesdragons.core.chapters.ChapterNumber.chapter;
import static fr.jsmadja.antredesdragons.core.execution.Action.goChapter;

public abstract class DeadlyChapter extends Chapter {
    @Override
    public Execution2 execute2(Pip pip) {
        return Execution2.builder()
                .logEntries(pip.getCurrentChapterLogEntries())
                .actions(List.of(goChapter(chapter(14))))
                .build();
    }
}
