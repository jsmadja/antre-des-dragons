package fr.jsmadja.antredesdragons;

import fr.jsmadja.antredesdragons.dices.Dice;
import fr.jsmadja.antredesdragons.entities.Entity;
import fr.jsmadja.antredesdragons.entities.Foe;
import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.fight.PhysicalAttack;
import fr.jsmadja.antredesdragons.stuff.Armory;
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
        when(dice.roll(2)).thenReturn(10);
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
        Entity target = Foe.builder().name("Foe").dice(mock(Dice.class)).initialHealthPoints(10).build();
        PhysicalAttack physicalAttack = pip.attacks(target);
        assertEquals(physicalAttack.getStatus(), PhysicalAttack.Status.TOUCHED);
        assertEquals(4, physicalAttack.getDamagePoints());
    }

    @Test
    void should_not_do_damage_if_roll_is_lesser_or_equal_than_6() {
        when(dice.roll(2)).thenReturn(1);
        Entity target = Foe.builder().name("Foe").dice(mock(Dice.class)).initialHealthPoints(10).build();
        PhysicalAttack physicalAttack = pip.attacks(target);
        assertEquals(physicalAttack.getStatus(), PhysicalAttack.Status.MISSED);
        assertEquals(physicalAttack.getDamagePoints(), 0);
    }

    @Test
    void should_set_touch_cap_to_4_when_EJ_is_equiped() {
        pip.setSword(Armory.getExcaliburJunior());
        assertEquals(4, pip.getAdjustedHitRollRange().getMin());
    }

    @Test
    void should_set_additional_damage_points_to_5_when_EJ_is_equiped() {
        pip.setSword(Armory.getExcaliburJunior());
        assertEquals(5, pip.getAdditionalDamagePoints());

        when(dice.roll(2)).thenReturn(10);
        Entity target = Foe.builder().name("Foe").dice(mock(Dice.class)).initialHealthPoints(10).build();
        PhysicalAttack physicalAttack = pip.attacks(target);
        assertEquals(11, physicalAttack.getDamagePoints());
    }

    @Test
    void should_sleep_well_and_restore_health_points() {
        pip.wounds(10);
        assertEquals(30, pip.getHealthPoints());

        when(dice.roll()).thenReturn(5);
        when(dice.roll(2)).thenReturn(10);

        pip.sleep();

        assertEquals(40, pip.getHealthPoints());
    }

}
