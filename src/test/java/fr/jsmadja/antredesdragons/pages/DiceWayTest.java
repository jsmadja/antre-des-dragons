package fr.jsmadja.antredesdragons.pages;

import fr.jsmadja.antredesdragons.dices.Roll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DiceWayTest {

    @Test
    public void shoud_verify_roll_matching() {
        DiceWay diceWay = DiceWay.builder().from(2).to(4).build();
        assertThat(diceWay.matches(Roll.of(1))).isFalse();
        assertThat(diceWay.matches(Roll.of(2))).isTrue();
        assertThat(diceWay.matches(Roll.of(3))).isTrue();
        assertThat(diceWay.matches(Roll.of(4))).isTrue();
        assertThat(diceWay.matches(Roll.of(5))).isFalse();
    }
}
