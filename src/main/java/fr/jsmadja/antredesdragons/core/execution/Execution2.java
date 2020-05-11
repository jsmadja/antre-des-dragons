package fr.jsmadja.antredesdragons.core.execution;

import fr.jsmadja.antredesdragons.core.diary.LogEntries;
import fr.jsmadja.antredesdragons.core.entities.Foe;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class Execution2 {
    private List<Action> actions;
    private LogEntries logEntries;
    private List<Foe> foes;

    @Builder
    public Execution2(List<Action> actions, LogEntries logEntries, List<Foe> foes) {
        this.actions = actions == null ? List.of() : actions;
        this.logEntries = logEntries == null ? new LogEntries() : logEntries;
        this.foes = foes;
    }

    public Execution2 add(LogEntries logEntries) {
        this.logEntries.add(logEntries);
        return this;
    }
}
