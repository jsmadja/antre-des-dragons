package fr.jsmadja.antredesdragons.entities;

import fr.jsmadja.antredesdragons.dices.Dice;
import org.junit.jupiter.api.Test;

import static fr.jsmadja.antredesdragons.entities.Spell.AEP;
import static fr.jsmadja.antredesdragons.entities.Spell.FIP;
import static fr.jsmadja.antredesdragons.entities.Spell.HEP;
import static fr.jsmadja.antredesdragons.entities.Spell.INVISIBILITY;
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

    private Pip getPip() {
        return new Pip(new Dice());
    }

}
