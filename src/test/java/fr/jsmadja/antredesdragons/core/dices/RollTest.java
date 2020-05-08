package fr.jsmadja.antredesdragons.core.dices;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RollTest {

    @Test
    public void should_test_between() {
        assertTrue(Roll.roll(5).isBetween(4, 6));
        assertFalse(Roll.roll(5).isBetween(7, 8));
    }

    @Test
    public void should_test_isGreaterThan() {
        assertTrue(Roll.roll(5).isGreaterThan(Roll.roll(4)));
        assertFalse(Roll.roll(5).isGreaterThan(Roll.roll(9)));
    }

}
