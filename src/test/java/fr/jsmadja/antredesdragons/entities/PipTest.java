package fr.jsmadja.antredesdragons.entities;

import fr.jsmadja.antredesdragons.dices.Dice;
import fr.jsmadja.antredesdragons.fight.PhysicalAttack;
import fr.jsmadja.antredesdragons.stuff.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PipTest {

    private Dice dice;
    private Pip pip;

    @BeforeEach
    void setUp() {
        dice = Mockito.mock(Dice.class);
        Mockito.when(dice.roll(2)).thenReturn(10);
        pip = new Pip(dice);
    }

    @Test
    void should_initialize_pip_hp() {
        Mockito.when(dice.roll(2)).thenReturn(10);
        pip = new Pip(dice);
        Assertions.assertEquals(40, pip.getInitialHealthPoints());
    }

    @Test
    void should_do_damage_if_roll_is_greather_than_6() {
        Mockito.when(dice.roll(2)).thenReturn(10);
        Entity target = Foe.builder().name("Foe").dice(Mockito.mock(Dice.class)).initialHealthPoints(10).build();
        PhysicalAttack physicalAttack = pip.attacks(target);
        Assertions.assertEquals(physicalAttack.getStatus(), PhysicalAttack.Status.TOUCHED);
        Assertions.assertEquals(4, physicalAttack.getDamagePoints());
    }

    @Test
    void should_not_do_damage_if_roll_is_lesser_or_equal_than_6() {
        Mockito.when(dice.roll(2)).thenReturn(1);
        Entity target = Foe.builder().name("Foe").dice(Mockito.mock(Dice.class)).initialHealthPoints(10).build();
        PhysicalAttack physicalAttack = pip.attacks(target);
        Assertions.assertEquals(physicalAttack.getStatus(), PhysicalAttack.Status.MISSED);
        Assertions.assertEquals(physicalAttack.getDamagePoints(), 0);
    }

    @Test
    void should_set_touch_cap_to_4_when_EJ_is_equiped() {
        pip.addAndEquip(Item.EXCALIBUR_JUNIOR);
        Assertions.assertEquals(4, pip.getAdjustedHitRollRange().getMin());
    }

    @Test
    void should_set_additional_damage_points_to_5_when_EJ_is_equiped() {
        pip.addAndEquip(Item.EXCALIBUR_JUNIOR);
        Assertions.assertEquals(5, pip.getAdditionalDamagePoints());

        Mockito.when(dice.roll(2)).thenReturn(10);
        Entity target = Foe.builder().name("Foe").dice(Mockito.mock(Dice.class)).initialHealthPoints(10).build();
        PhysicalAttack physicalAttack = pip.attacks(target);
        Assertions.assertEquals(11, physicalAttack.getDamagePoints());
    }

    @Test
    void should_sleep_well_and_restore_health_points() {
        pip.wounds(10);
        Assertions.assertEquals(30, pip.getCurrentHealthPoints());

        Mockito.when(dice.roll()).thenReturn(5);
        Mockito.when(dice.roll(2)).thenReturn(10);

        pip.sleep();

        Assertions.assertEquals(40, pip.getCurrentHealthPoints());
    }

}
