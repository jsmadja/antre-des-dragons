package fr.jsmadja.antredesdragons.core.chapters;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EqualsAndHashCode
@Getter
public class ChapterNumber {
    private final Integer chapter;

    public static ChapterNumber chapter(Integer chapter) {
        return new ChapterNumber(chapter);
    }

    @Override
    public String toString() {
        return chapter.toString();
    }
}
