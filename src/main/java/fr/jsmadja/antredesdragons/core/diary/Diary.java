package fr.jsmadja.antredesdragons.core.diary;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fr.jsmadja.antredesdragons.core.chapters.Chapter;
import fr.jsmadja.antredesdragons.core.chapters.ChapterNumber;
import fr.jsmadja.antredesdragons.core.dices.Roll;
import fr.jsmadja.antredesdragons.core.inventory.HealingItem;
import fr.jsmadja.antredesdragons.core.inventory.Item;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

import static fr.jsmadja.antredesdragons.core.diary.LogEntry.Type.CHAPTER;
import static fr.jsmadja.antredesdragons.core.diary.LogEntry.Type.HEALING_ITEM;
import static fr.jsmadja.antredesdragons.core.diary.LogEntry.Type.ITEM;
import static fr.jsmadja.antredesdragons.core.diary.LogEntry.Type.ROLL;

public class Diary {
    @Getter
    private List<DiaryPage> pages = new ArrayList<>();

    public Diary() {
        openNewPage();
    }

    public void log(String author, Roll roll) {
        addToCurrentPage(withAuthor(author)
                .roll(roll)
                .type(ROLL)
                .build());
    }

    public LogEntry.LogEntryBuilder withAuthor(String author) {
        return LogEntry.builder()
                .author(author);
    }

    public void log(String author, HealingItem healingItem) {
        addToCurrentPage(withAuthor(author)
                .healingItem(healingItem)
                .type(HEALING_ITEM)
                .build());
    }

    public DiaryPage getCurrentPage() {
        return pages.get(pages.size() - 1);
    }

    public void openNewPage() {
        pages.add(new DiaryPage());
    }

    public void log(String author, Chapter chapter) {
        addToCurrentPage(withAuthor(author)
                .chapterNumber(ChapterNumber.chapter(chapter.getNumber()))
                .chapterTitle(chapter.getTitle())
                .type(CHAPTER)
                .build());
    }

    public void log(String author, LogEntry.Type type, String message) {
        addToCurrentPage(withAuthor(author).type(type).message(message).build());
    }

    public void log(String author, Item item) {
        addToCurrentPage(withAuthor(author)
                .item(item)
                .type(ITEM)
                .build());
    }

    @JsonIgnore
    public LogEntries getLogEntries() {
        return this.pages.stream().map(DiaryPage::getLogEntries).reduce(LogEntries::add).orElse(new LogEntries());
    }

    private void addToCurrentPage(LogEntry logEntry) {
        getCurrentPage().add(logEntry);
    }

}
