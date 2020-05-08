package fr.jsmadja.antredesdragons.stuff;

import fr.jsmadja.antredesdragons.dices.Dice;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HealingPotionTest {

    @Test
    public void should_have_6_doses() {
        Dice dice = new Dice();
        HealingPotion healingPotion = new HealingPotion(dice);
        assertThat(healingPotion.isUsable()).isTrue();
        for (int i = 0; i < 6; i++) {
            HealthPoints healthPoints = healingPotion.use();
            assertThat(healthPoints.getValue()).isBetween(1, 13);
        }
        assertThat(healingPotion.isUsable()).isFalse();
    }
}
