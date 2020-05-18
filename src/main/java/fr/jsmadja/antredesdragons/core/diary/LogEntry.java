package fr.jsmadja.antredesdragons.core.diary;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import fr.jsmadja.antredesdragons.core.chapters.ChapterNumber;
import fr.jsmadja.antredesdragons.core.dices.Roll;
import fr.jsmadja.antredesdragons.core.inventory.HealingItem;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Getter
@ToString(exclude = {"id", "date"})
public class LogEntry implements Comparable<LogEntry> {
    private final Date date;
    private final Type type;
    private final String author;
    private static int IDS = 0;
    @JsonUnwrapped
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Roll roll;
    private HealingItem healingItem;
    @JsonUnwrapped
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ChapterNumber chapterNumber;
    @JsonUnwrapped
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String chapterTitle;
    private String message;
    private final Integer id;

    @Builder
    public LogEntry(Type type, Roll roll, String author, HealingItem healingItem, ChapterNumber chapterNumber, String message, String chapterTitle) {
        this.id = IDS++;
        this.type = type;
        this.roll = roll;
        this.author = author;
        this.healingItem = healingItem;
        this.chapterNumber = chapterNumber;
        this.chapterTitle = chapterTitle;
        this.message = message;
        this.date = new Date();
    }

    @Override
    public int compareTo(LogEntry logEntry) {
        return this.date.compareTo(logEntry.date) == 0 ? this.id.compareTo(logEntry.id) : this.date.compareTo(logEntry.date);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogEntry logEntry = (LogEntry) o;
        return id.equals(logEntry.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public enum Type {HEALING_ITEM, CHAPTER, ROLL, ITEM, SPELL, MISC, FIGHT}
}
