package fr.jsmadja.antredesdragons.entities;

import fr.jsmadja.antredesdragons.dices.Dice;
import fr.jsmadja.antredesdragons.fight.Attack;
import fr.jsmadja.antredesdragons.spellcasting.SpellEffectResult;
import fr.jsmadja.antredesdragons.stuff.HealingItem;
import fr.jsmadja.antredesdragons.stuff.HealingPotion;
import fr.jsmadja.antredesdragons.stuff.Ointment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.stream.IntStream;

import static fr.jsmadja.antredesdragons.fight.Attack.Status.MISSED;
import static fr.jsmadja.antredesdragons.fight.Attack.Status.TOUCHED;
import static fr.jsmadja.antredesdragons.spellcasting.SpellBook.AEP;
import static fr.jsmadja.antredesdragons.spellcasting.SpellEffectResult.FAILURE;
import static fr.jsmadja.antredesdragons.spellcasting.SpellEffectResult.SUCCESS;
import static fr.jsmadja.antredesdragons.stuff.Item.EXCALIBUR_JUNIOR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class PipTest {

    private Dice dice;
    private Pip pip;

    @BeforeEach
    void setUp() {
        dice = Mockito.mock(Dice.class);
        when(dice.roll(2)).thenReturn(10);
        pip = new Pip(dice);
    }

    @Test
    void should_initialize_pip_hp() {
        when(dice.roll(2)).thenReturn(10);
        pip = new Pip(dice);
        assertThat(pip.getInitialHealthPoints()).isEqualTo(40);
    }

    @Test
    void should_do_damage_if_roll_is_greather_than_6() {
        when(dice.roll(2)).thenReturn(10);
        Entity target = Foe.builder().name("Foe").dice(Mockito.mock(Dice.class)).initialHealthPoints(10).build();
        Attack Attack = pip.createPhysicAttack(target);
        assertThat(Attack.getStatus()).isEqualTo(TOUCHED);
        assertThat(Attack.getDamagePoints()).isEqualTo(4);
    }

    @Test
    void should_not_do_damage_if_roll_is_lesser_or_equal_than_6() {
        when(dice.roll(2)).thenReturn(1);
        Entity target = Foe.builder().name("Foe").dice(Mockito.mock(Dice.class)).initialHealthPoints(10).build();
        Attack Attack = pip.createPhysicAttack(target);
        assertThat(Attack.getStatus()).isEqualTo(MISSED);
        assertThat(Attack.getDamagePoints()).isZero();
    }

    @Test
    void should_set_touch_cap_to_4_when_EJ_is_equiped() {
        pip.addAndEquip(EXCALIBUR_JUNIOR);
        assertThat(pip.getAdjustedHitRollRange().getMin()).isEqualTo(4);
    }

    @Test
    void should_set_additional_damage_points_to_5_when_EJ_is_equiped() {
        pip.addAndEquip(EXCALIBUR_JUNIOR);
        assertThat(pip.getAdditionalDamagePoints()).isEqualTo(5);

        when(dice.roll(2)).thenReturn(10);
        Entity target = Foe.builder().name("Foe").dice(Mockito.mock(Dice.class)).initialHealthPoints(10).build();
        Attack Attack = pip.createPhysicAttack(target);
        assertThat(Attack.getDamagePoints()).isEqualTo(11);
    }

    @Test
    void should_sleep_well_and_restore_health_points() {
        pip.wounds(10);
        assertThat(pip.getCurrentHealthPoints()).isEqualTo(30);

        when(dice.roll()).thenReturn(5);
        when(dice.roll(2)).thenReturn(10);

        pip.sleep();

        assertThat(pip.getCurrentHealthPoints()).isEqualTo(40);
    }

    @Test
    void use_spell_causes_3_hp() {
        pip.use(AEP);
        assertThat(pip.getCurrentHealthPoints()).isEqualTo(pip.getInitialHealthPoints() - 3);
    }

    @Test
    void spell_can_only_be_used_3_times() {
        IntStream.of(1, 2, 3).forEach(i -> {
            assertThat(pip.canUse(AEP)).isTrue();
            pip.use(AEP);
        });
        assertThat(pip.canUse(AEP)).isFalse();
    }

    @Test
    void spell_works_only_if_roll_is_greater_than_6() {
        when(dice.roll(2)).thenReturn(7);
        SpellEffectResult spellEffectResult = pip.use(AEP);
        assertThat(spellEffectResult).isEqualTo(SUCCESS);
    }

    @Test
    void spell_failed_when_roll_is_lesser_than_7() {
        when(dice.roll(2)).thenReturn(6);
        SpellEffectResult spellEffectResult = pip.use(AEP);
        assertThat(spellEffectResult).isEqualTo(FAILURE);
    }

    @Test
    void pip_should_have_3_potions_at_the_beginning() {
        List<HealingItem> potions = pip.getHealingItemsOfType(HealingPotion.class);
        assertThat(potions).hasSize(3);
    }

    @Test
    void pip_should_have_5_ointments_at_the_beginning() {
        List<HealingItem> ointments = pip.getHealingItemsOfType(Ointment.class);
        assertThat(ointments).hasSize(5);
    }

}
