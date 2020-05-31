package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.Answer;
import fr.jsmadja.antredesdragons.core.chapters.ChapterNumber;
import fr.jsmadja.antredesdragons.core.entities.Pip;
import fr.jsmadja.antredesdragons.core.execution.Action;
import fr.jsmadja.antredesdragons.core.execution.Execution;
import org.junit.jupiter.api.Test;

import static fr.jsmadja.antredesdragons.core.book.Book.START;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

class MarketChapterTest {

    @Test
    public void should_exit_market() {
        MarketChapter marketChapter = new MarketChapter();
        Pip pip = mock(Pip.class);
        Execution execution = marketChapter.execute(pip, "QM", Answer.Yes);
        assertThat(execution.getActions()).containsExactly(
                Action.builder()
                        .chapter(ChapterNumber.chapter(START))
                        .question("Quitter le marché")
                        .build()
        );
    }

    public Action goChapter(int chapter) {
        return Action.builder().chapter(ChapterNumber.chapter(chapter)).build();
    }

}
