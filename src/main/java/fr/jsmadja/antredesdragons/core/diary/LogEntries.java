package fr.jsmadja.antredesdragons.core.diary;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@ToString
@Getter
public class LogEntries {
    private Set<LogEntry> logEntries = new TreeSet<>();

    public void add(LogEntry logEntry) {
        this.logEntries.add(logEntry);
    }

    public List<LogEntry> toList() {
        return new ArrayList<>(logEntries);
    }

    public LogEntries add(LogEntries logEntries) {
        if (logEntries != null) {
            this.logEntries.addAll(logEntries.logEntries);
        }
        return this;
    }

    public int getSize() {
        return this.logEntries.size();
    }
}
