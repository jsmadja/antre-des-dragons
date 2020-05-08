package fr.jsmadja.antredesdragons.core.dices;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class DiceTest {

    @Test
    void should_roll_one_dice_and_get_something_between_one_and_six() {
        Dice dice = new Dice();
        int face = dice.roll();
        assertTrue(1 <= face && face <= 6);
    }

    @Test
    void should_roll_two_dice_and_get_something_between_one_and_twelve() {
        Dice dice = new Dice();
        int face = dice.roll(2).getValue();
        assertTrue(2 <= face && face <= 12);
    }

}
