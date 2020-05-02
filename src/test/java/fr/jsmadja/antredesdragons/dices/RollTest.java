package fr.jsmadja.antredesdragons.dices;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RollTest {

    @Test
    public void should_test_between() {
        assertTrue(Roll.of(5).isBetween(4, 6));
        assertFalse(Roll.of(5).isBetween(7, 8));
    }

    @Test
    public void should_test_isGreaterThan() {
        assertTrue(Roll.of(5).isGreaterThan(Roll.of(4)));
        assertFalse(Roll.of(5).isGreaterThan(Roll.of(9)));
    }

}
