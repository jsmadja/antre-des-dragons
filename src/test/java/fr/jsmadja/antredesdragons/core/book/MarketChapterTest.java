package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.Answer;
import fr.jsmadja.antredesdragons.core.chapters.ChapterNumber;
import fr.jsmadja.antredesdragons.core.entities.Pip;
import fr.jsmadja.antredesdragons.core.execution.Action;
import fr.jsmadja.antredesdragons.core.execution.Execution;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

class MarketChapterTest {

    @Test
    public void should_exit_market() {
        MarketChapter marketChapter = new MarketChapter();
        Pip pip = mock(Pip.class);
        Execution execution = marketChapter.execute(pip, "QM", Answer.Yes);
        assertThat(execution.getActions()).containsExactly(
                goChapter(21),
                goChapter(58),
                goChapter(65),
                goChapter(155));
    }

    public Action goChapter(int chapter) {
        return Action.builder().chapter(ChapterNumber.chapter(chapter)).build();
    }

}
