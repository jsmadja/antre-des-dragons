package fr.jsmadja.antredesdragons.core.entities;

import fr.jsmadja.antredesdragons.core.diary.LogEntry;
import fr.jsmadja.antredesdragons.core.dices.Dice;
import fr.jsmadja.antredesdragons.core.fight.Attack;
import fr.jsmadja.antredesdragons.core.inventory.HealingItem;
import fr.jsmadja.antredesdragons.core.inventory.HealingPotion;
import fr.jsmadja.antredesdragons.core.inventory.Item;
import fr.jsmadja.antredesdragons.core.inventory.Ointment;
import fr.jsmadja.antredesdragons.core.spellcasting.SpellEffectResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static fr.jsmadja.antredesdragons.core.diary.LogEntry.Type.MISC;
import static fr.jsmadja.antredesdragons.core.dices.Roll.roll;
import static fr.jsmadja.antredesdragons.core.fight.Attack.Status.MISSED;
import static fr.jsmadja.antredesdragons.core.fight.Attack.Status.TOUCHED;
import static fr.jsmadja.antredesdragons.core.spellcasting.SpellBook.AEP;
import static fr.jsmadja.antredesdragons.core.spellcasting.SpellEffectResult.FAILURE;
import static fr.jsmadja.antredesdragons.core.spellcasting.SpellEffectResult.SUCCESS;
import static fr.jsmadja.antredesdragons.core.stuff.HealthPoints.hp;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PipTest {

    private Dice dice;
    private Pip pip;

    @BeforeEach
    void setUp() {
        dice = mock(Dice.class);
        when(dice.roll(2)).thenReturn(roll(10));
        pip = new Pip(dice);
    }

    @Test
    void should_initialize_pip_hp() {
        when(dice.roll(2)).thenReturn(roll(10));
        pip = new Pip(dice);
        pip.initialize();
        assertThat(pip.getInitialHealthPoints()).isEqualTo(40);
    }

    @Test
    void should_do_damage_if_roll_is_greather_than_6() {
        when(dice.roll(2)).thenReturn(roll(10));
        Entity target = Foe.builder().name("Foe").dice(mock(Dice.class)).initialHealthPoints(hp(10)).build();
        Attack Attack = pip.createPhysicAttack(target);
        assertThat(Attack.getStatus()).isEqualTo(TOUCHED);
        assertThat(Attack.getDamagePoints()).isEqualTo(4);
    }

    @Test
    void should_not_do_damage_if_roll_is_lesser_or_equal_than_6() {
        when(dice.roll(2)).thenReturn(roll(1));
        Entity target = Foe.builder().name("Foe").dice(mock(Dice.class)).initialHealthPoints(hp(10)).build();
        Attack Attack = pip.createPhysicAttack(target);
        assertThat(Attack.getStatus()).isEqualTo(MISSED);
        assertThat(Attack.getDamagePoints()).isZero();
    }

    @Test
    void should_set_touch_cap_to_4_when_EJ_is_equiped() {
        pip.addAndEquip(Item.EXCALIBUR_JUNIOR);
        assertThat(pip.getAdjustedHitRollRange().getMin()).isEqualTo(4);
    }

    @Test
    void should_set_additional_damage_points_to_5_when_EJ_is_equiped() {
        pip.addAndEquip(Item.EXCALIBUR_JUNIOR);
        assertThat(pip.getAdditionalDamagePoints()).isEqualTo(5);

        when(dice.roll(2)).thenReturn(roll(10));
        Entity target = Foe.builder().name("Foe").dice(mock(Dice.class)).initialHealthPoints(hp(10)).build();
        Attack Attack = pip.createPhysicAttack(target);
        assertThat(Attack.getDamagePoints()).isEqualTo(11);
    }

    @Test
    void use_spell_causes_3_hp() {
        pip.initialize();
        pip.use(AEP);
        assertThat(pip.getCurrentHealthPoints()).isEqualTo(pip.getInitialHealthPoints() - 3);
    }

    @Test
    void spell_can_only_be_used_3_times() {
        pip.initialize();
        IntStream.of(1, 2, 3).forEach(i -> {
            assertThat(pip.canUse(AEP)).isTrue();
            pip.use(AEP);
        });
        assertThat(pip.canUse(AEP)).isFalse();
    }

    @Test
    void spell_works_only_if_roll_is_greater_than_6() {
        pip.initialize();
        when(dice.roll(2)).thenReturn(roll(7));
        SpellEffectResult spellEffectResult = pip.use(AEP);
        assertThat(spellEffectResult).isEqualTo(SUCCESS);
    }

    @Test
    void spell_failed_when_roll_is_lesser_than_7() {
        when(dice.roll(2)).thenReturn(roll(6));
        SpellEffectResult spellEffectResult = pip.use(AEP);
        assertThat(spellEffectResult).isEqualTo(FAILURE);
    }

    @Test
    void pip_should_have_3_potions_at_the_beginning() {
        pip.initialize();
        List<HealingItem> potions = pip.getHealingItemsOfType(HealingPotion.class);
        assertThat(potions).hasSize(3);
    }

    @Test
    void pip_should_have_5_ointments_at_the_beginning() {
        pip.initialize();
        List<HealingItem> ointments = pip.getHealingItemsOfType(Ointment.class);
        assertThat(ointments).hasSize(5);
    }

    @Test
    public void should_generate_log_entries_at_initialization() {
        pip.initialize();
        long healingItemLogEntriesCount = pip.getCurrentChapterLogEntries().toList()
                .stream()
                .map(LogEntry::getType).filter(t -> t.equals(MISC))
                .count();
        assertThat(healingItemLogEntriesCount).isEqualTo(9);
    }

}
