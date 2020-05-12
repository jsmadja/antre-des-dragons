package fr.jsmadja.antredesdragons.core.chapters;

import fr.jsmadja.antredesdragons.core.entities.FoeFactory;
import fr.jsmadja.antredesdragons.core.entities.Pip;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Chapter {

    private boolean visited;

    @Getter
    private FoeFactory foeFactory = new FoeFactory();

    public abstract String getText();

    protected void beforeLeavingChapter(Pip pip) {
    }

    public Execution execute(Pip pip) {
        return execute(pip, null, null);
    }

    public Execution execute(Pip pip, String questionId, Answer answer) {
        return Execution.builder().logEntries(pip.getCurrentChapterLogEntries()).build();
    }

}
