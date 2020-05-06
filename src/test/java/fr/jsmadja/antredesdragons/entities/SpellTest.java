package fr.jsmadja.antredesdragons.entities;

import fr.jsmadja.antredesdragons.dices.Dice;
import fr.jsmadja.antredesdragons.stuff.Item;
import org.junit.jupiter.api.Test;

import static fr.jsmadja.antredesdragons.entities.Spell.AEP;
import static fr.jsmadja.antredesdragons.entities.Spell.FINGER_OF_FIRE;
import static fr.jsmadja.antredesdragons.entities.Spell.FIP;
import static fr.jsmadja.antredesdragons.entities.Spell.FIREBALL;
import static fr.jsmadja.antredesdragons.entities.Spell.HEP;
import static fr.jsmadja.antredesdragons.entities.Spell.INVISIBILITY;
import static fr.jsmadja.antredesdragons.entities.Spell.MEP;
import static fr.jsmadja.antredesdragons.entities.Spell.NIP;
import static fr.jsmadja.antredesdragons.entities.Spell.PAP;
import static fr.jsmadja.antredesdragons.entities.Spell.RIP;
import static org.assertj.core.api.Assertions.assertThat;

class SpellTest {

    @Test
    public void AEP_should_add_temporary_armor() {
        Pip pip = getPip();

        assertThat(pip.getMagicArmorPoints().getValue()).isEqualTo(0);
        AEP.getCastEffect().execute(pip);

        assertThat(pip.getMagicArmorPoints().getValue()).isEqualTo(4);
    }

    @Test
    public void HEP_should_add_temporary_damages() {
        Pip pip = getPip();

        assertThat(pip.getMagicDamagePoints().getValue()).isEqualTo(0);
        HEP.getCastEffect().execute(pip);

        assertThat(pip.getMagicDamagePoints().getValue()).isEqualTo(10);
    }

    @Test
    public void INVISIBILITY_should_set_pip_invisible() {
        Pip pip = getPip();

        assertThat(pip.isInvisible()).isFalse();
        INVISIBILITY.getCastEffect().execute(pip);

        assertThat(pip.isInvisible()).isTrue();

        INVISIBILITY.getOnChapterEnd().execute(pip);
        assertThat(pip.isInvisible()).isFalse();
    }

    @Test
    public void RIP_should_add_missing_strike_malus_to_next_foe() {
        Pip pip = getPip();

        assertThat(pip.getSpellsToCastDuringFight()).isEmpty();
        RIP.getCastEffect().execute(pip);
        assertThat(pip.getSpellsToCastDuringFight()).contains(RIP);

        Foe target = Foe.builder().build();
        RIP.getFightEffect().execute(pip, target);

        assertThat(pip.getSpellsToCastDuringFight()).isEmpty();
        assertThat(target.getMissMalusCount()).isEqualTo(3);
    }

    @Test
    public void FIP_should_damage_10_points() {
        Pip pip = getPip();
        Foe target = Foe.builder().initialHealthPoints(10).build();

        assertThat(target.getCurrentHealthPoints()).isEqualTo(10);
        assertThat(pip.getSpellsToCastDuringFight()).isEmpty();
        FIP.getCastEffect().execute(pip);
        assertThat(pip.getSpellsToCastDuringFight()).contains(FIP);

        FIP.getFightEffect().execute(pip, target);

        assertThat(pip.getSpellsToCastDuringFight()).isEmpty();
        assertThat(target.getCurrentHealthPoints()).isEqualTo(0);
    }

    @Test
    public void PAP_should_immune_to_poison() {
        Pip pip = getPip();
        assertThat(pip.isImmuneToPoison()).isFalse();

        PAP.getCastEffect().execute(pip);
        assertThat(pip.isImmuneToPoison()).isTrue();

        PAP.getOnChapterEnd().execute(pip);
        assertThat(pip.isImmuneToPoison()).isFalse();
    }

    @Test
    public void PAP_cant_work_on_an_already_poisoned_entity() {
        Pip pip = getPip();
        pip.setPoisoned(true);

        assertThat(pip.isImmuneToPoison()).isFalse();
        PAP.getCastEffect().execute(pip);
        assertThat(pip.isImmuneToPoison()).isFalse();
    }

    @Test
    public void NIP_pip_can_open_any_item() {
        Pip pip = getPip();

        assertThat(pip.isAbleToOpenAnyItem()).isFalse();

        NIP.getCastEffect().execute(pip);
        assertThat(pip.isAbleToOpenAnyItem()).isTrue();

        NIP.getOnChapterEnd().execute(pip);
        assertThat(pip.isAbleToOpenAnyItem()).isFalse();
    }

    @Test
    public void MEP_should_be_able_to_strike_twice_during_the_fight_() {
        Pip pip = getPip();
        assertThat(pip.isAbleToStrikeTwice()).isFalse();

        MEP.getCastEffect().execute(pip);
        assertThat(pip.isAbleToStrikeTwice()).isTrue();

        MEP.getOnChapterEnd().execute(pip);
        assertThat(pip.isAbleToStrikeTwice()).isFalse();
    }

    @Test
    public void FINGER_OF_DEATH_should_give_10_items() {
        Pip pip = getPip();
        assertThat(pip.has(Item.FINGER_OF_FIRE)).isFalse();

        FINGER_OF_FIRE.getCastEffect().execute(pip);
        assertThat(pip.has(Item.FINGER_OF_FIRE)).isTrue();
        assertThat(pip.getInventory().stream().filter(i -> i == Item.FINGER_OF_FIRE).count()).isEqualTo(10);

        Foe target = Foe.builder().initialHealthPoints(10).build();

        FINGER_OF_FIRE.getFightEffect().execute(pip, target);
        assertThat(target.isDead()).isTrue();
        assertThat(pip.getInventory().stream().filter(i -> i == Item.FINGER_OF_FIRE).count()).isEqualTo(9);

        FINGER_OF_FIRE.getOnChapterEnd().execute(pip);
        assertThat(pip.has(Item.FINGER_OF_FIRE)).isFalse();
    }

    @Test
    public void FIREBALL_should_give_2_items() {
        Pip pip = getPip();
        assertThat(pip.has(Item.FIREBALL)).isFalse();

        FIREBALL.getCastEffect().execute(pip);
        assertThat(pip.has(Item.FIREBALL)).isTrue();
        assertThat(pip.getInventory().stream().filter(i -> i == Item.FIREBALL).count()).isEqualTo(2);

        Foe target = Foe.builder().initialHealthPoints(75).build();

        FIREBALL.getFightEffect().execute(pip, target);
        assertThat(target.isDead()).isTrue();
        assertThat(pip.getInventory().stream().filter(i -> i == Item.FIREBALL).count()).isEqualTo(1);
    }

    private Pip getPip() {
        return new Pip(new Dice());
    }

}
