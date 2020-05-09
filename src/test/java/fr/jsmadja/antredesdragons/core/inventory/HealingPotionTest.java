package fr.jsmadja.antredesdragons.core.inventory;

import fr.jsmadja.antredesdragons.core.dices.Dice;
import fr.jsmadja.antredesdragons.core.stuff.HealthPoints;
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
            assertThat(healthPoints.getHealthPoints()).isBetween(1, 13);
        }
        assertThat(healingPotion.isUsable()).isFalse();
    }
}
