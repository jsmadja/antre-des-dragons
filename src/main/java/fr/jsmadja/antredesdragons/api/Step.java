package fr.jsmadja.antredesdragons.api;

import fr.jsmadja.antredesdragons.core.diary.LogEntry;
import fr.jsmadja.antredesdragons.core.entities.Foe;
import fr.jsmadja.antredesdragons.core.entities.Pip;
import fr.jsmadja.antredesdragons.core.execution.Action;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class Step {
    private final List<Action> actions;
    private final List<LogEntry> logEntries;
    private final Pip pip;
    private final List<Foe> foes;

    @Builder
    public Step(Pip pip, List<Action> actions, List<LogEntry> logEntries, List<Foe> foes) {
        this.pip = pip;
        this.actions = actions == null ? List.of() : actions;
        this.logEntries = logEntries == null ? List.of() : logEntries;
        this.foes = foes;
    }

    public String getChapterText() {
        return this.pip.getCurrentChapter().getText();
    }
}
