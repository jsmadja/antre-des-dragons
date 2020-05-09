package fr.jsmadja.antredesdragons.core.execution;

import fr.jsmadja.antredesdragons.core.diary.LogEntries;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class Execution2 {
    private List<Action> actions;
    private LogEntries logEntries;

    @Builder
    public Execution2(List<Action> actions, LogEntries logEntries) {
        this.actions = actions == null ? List.of() : actions;
        this.logEntries = logEntries == null ? new LogEntries() : logEntries;
    }

    public Execution2 add(LogEntries logEntries) {
        this.logEntries.add(logEntries);
        return this;
    }
}
