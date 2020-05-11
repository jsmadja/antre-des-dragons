package fr.jsmadja.antredesdragons.core.execution;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import fr.jsmadja.antredesdragons.core.chapters.ChapterNumber;
import lombok.Builder;
import lombok.Data;

import static java.text.MessageFormat.format;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Builder
@Data
public class Action {
    @JsonUnwrapped
    private final ChapterNumber chapter;
    private String question;
    private String suffix;
    private String answer;

    public static Action goChapter(ChapterNumber chapterNumber) {
        return Action.builder().chapter(chapterNumber).build();
    }

    public static Action question(ChapterNumber chapter, String question) {
        return Action.builder().chapter(chapter).question(question).build();
    }

    public String getUrl() {
        return format("/chapter/{0}{1}", chapter, suffix == null ? "" : suffix);
    }
}
