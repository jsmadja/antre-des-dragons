package fr.jsmadja.antredesdragons;

import fr.jsmadja.antredesdragons.chapters.ChapterNumber;
import fr.jsmadja.antredesdragons.dices.Roll;
import fr.jsmadja.antredesdragons.entities.Pip;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static fr.jsmadja.antredesdragons.stuff.HealthPoints.hp;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SleepTest {

    @Test
    public void should_good_sleeping_when_roll_is_5_or_6() {
        Pip pip = mock(Pip.class);

        Sleep sleep = new Sleep(pip);

        IntStream.range(1, 5)
                .mapToObj(v -> when(pip.roll1Dice()).thenReturn(Roll.roll(v)))
                .forEach(r -> assertThat(sleep.isGood()).isFalse());

        IntStream.range(5, 7)
                .mapToObj(v -> when(pip.roll1Dice()).thenReturn(Roll.roll(v)))
                .forEach(r -> assertThat(sleep.isGood()).isTrue());
    }

    @Test
    public void should_restore_health_when_sleep_is_good() {
        Pip pip = mock(Pip.class);

        Sleep sleep = new Sleep(pip);

        when(pip.roll1Dice()).thenReturn(Roll.roll(5));
        assertThat(sleep.isGood()).isTrue();

        when(pip.roll2Dices()).thenReturn(Roll.roll(10));
        assertThat(sleep.getHealthPoints()).isEqualTo(hp(10));
    }

    @Test
    public void should_get_dream_chapter_number() {
        Pip pip = mock(Pip.class);

        Sleep sleep = new Sleep(pip);

        when(pip.roll2Dices()).thenReturn(Roll.roll(5));

        ChapterNumber dreamChapterNumber = sleep.getDreamChapterNumber();
        assertThat(dreamChapterNumber).isEqualTo(ChapterNumber.chapter(5));
    }

}
