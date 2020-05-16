package fr.jsmadja.antredesdragons.core.chapters;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ChapterTest {

    @Test
    public void should_return_chapter_number_as_title_when_there_is_no_title() {
        Chapter chapter = new Chapter() {
            @Override
            public String getText() {
                return "text";
            }
        };
        chapter.withNumber(5);
        assertThat(chapter.getTitle()).isEqualTo("5");
    }

    @Test
    public void should_return_chapter_title_as_title_when_there_is_a_title() {
        Chapter chapter = new Chapter() {
            @Override
            public String getText() {
                return "text";
            }
        };
        chapter.withNumber(5).withTitle("Title");
        assertThat(chapter.getTitle()).isEqualTo("Title");
    }

}
