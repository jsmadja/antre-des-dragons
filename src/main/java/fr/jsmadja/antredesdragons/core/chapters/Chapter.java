package fr.jsmadja.antredesdragons.core.chapters;

import fr.jsmadja.antredesdragons.core.entities.Pip;
import fr.jsmadja.antredesdragons.core.execution.Execution2;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Chapter {

    private boolean visited;

    public abstract String getText();

    @Deprecated
    public Execution execute(Pip pip) {
        return Execution.empty();
    }

    protected void beforeLeavingChapter(Pip pip) {
    }

    public Execution2 execute2(Pip pip) {
        return Execution2.builder().logEntries(pip.getCurrentChapterLogEntries()).build();
    }

}
