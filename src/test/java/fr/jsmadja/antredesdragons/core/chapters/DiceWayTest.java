package fr.jsmadja.antredesdragons.core.chapters;

import fr.jsmadja.antredesdragons.core.dices.Roll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DiceWayTest {

    @Test
    public void shoud_verify_roll_matching() {
        DiceWay diceWay = DiceWay.builder().from(2).to(4).build();
        assertThat(diceWay.matches(Roll.roll(1))).isFalse();
        assertThat(diceWay.matches(Roll.roll(2))).isTrue();
        assertThat(diceWay.matches(Roll.roll(3))).isTrue();
        assertThat(diceWay.matches(Roll.roll(4))).isTrue();
        assertThat(diceWay.matches(Roll.roll(5))).isFalse();
    }
}
