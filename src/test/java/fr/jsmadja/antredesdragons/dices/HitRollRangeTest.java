package fr.jsmadja.antredesdragons.dices;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HitRollRangeTest {

    @Test
    public void should_test_contains() {
        assertThat(new HitRollRange(5).contains(1)).isFalse();
        assertThat(new HitRollRange(5).contains(7)).isTrue();
        assertThat(new HitRollRange(5).contains(13)).isFalse();
        assertThat(new HitRollRange(5, 20).contains(13)).isTrue();
    }

}
