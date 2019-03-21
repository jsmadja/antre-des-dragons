package fr.jsmadja.antredesdragons;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PipTest {

    private Dice dice;
    private Pip pip;

    @BeforeEach
    void setUp() {
        dice = mock(Dice.class);
        pip = new Pip(dice);
    }

    @Test
    void should_initialize_pip_hp() {
        when(dice.roll(2)).thenReturn(10);
        pip = new Pip(dice);
        assertEquals(40, pip.getInitialHealthPoints());
    }

    @Test
    void should_do_damage_if_roll_is_greather_than_6() {
        when(dice.roll(2)).thenReturn(10);
        Attack attack = pip.attacks();
        assertEquals(attack.getStatus(), Attack.Status.TOUCHED);
        assertEquals(attack.getDamagePoints(), 4);
    }

    @Test
    void should_not_do_damage_if_roll_is_lesser_or_equal_than_6() {
        when(dice.roll(2)).thenReturn(1);
        Attack attack = pip.attacks();
        assertEquals(attack.getStatus(), Attack.Status.MISSED);
        assertEquals(attack.getDamagePoints(), 0);
    }

    @Test
    void should_set_touch_cap_to_4_when_EJ_is_equiped() {
        Pip pip = new Pip(dice);
        pip.setSword(Armory.getExcaliburJunior());
        assertEquals(4, pip.getTouchCap());
    }

}
