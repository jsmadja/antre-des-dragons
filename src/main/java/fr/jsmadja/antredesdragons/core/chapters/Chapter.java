package fr.jsmadja.antredesdragons.core.chapters;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fr.jsmadja.antredesdragons.core.entities.FoeFactory;
import fr.jsmadja.antredesdragons.core.entities.Pip;
import fr.jsmadja.antredesdragons.core.execution.Execution;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Chapter {

    private boolean visited;

    @JsonIgnore
    @Getter
    private FoeFactory foeFactory = new FoeFactory();

    public abstract String getText();

    protected void beforeLeavingChapter(Pip pip) {
    }

    public Execution execute(Pip pip) {
        return execute(pip, null, null);
    }

    public Execution execute(Pip pip, String questionId, Answer answer) {
        beforeLeavingChapter(pip);
        return Execution.builder().logEntries(pip.getCurrentChapterLogEntries()).build();
    }

}
