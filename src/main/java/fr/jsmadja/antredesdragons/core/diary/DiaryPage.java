package fr.jsmadja.antredesdragons.core.diary;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Getter;

import java.util.List;

public class DiaryPage {

    @JsonUnwrapped
    @Getter
    private LogEntries logEntries = new LogEntries();

    public void add(LogEntry logEntry) {
        this.logEntries.add(logEntry);
    }

    public List<LogEntry> toList() {
        return logEntries.toList();
    }

}
