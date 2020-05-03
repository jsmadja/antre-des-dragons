package fr.jsmadja.antredesdragons.entities;

import fr.jsmadja.antredesdragons.dices.Dice;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SpellTest {

    @Test
    public void AEP_should_add_temporary_armor() {
        Pip pip = new Pip(new Dice());

        assertThat(pip.getMagicArmorPoints().getValue()).isEqualTo(0);
        Spell.AEP.getEffect().apply(pip);

        assertThat(pip.getMagicArmorPoints().getValue()).isEqualTo(4);
    }

    @Test
    public void HEP_should_add_temporary_damages() {
        Pip pip = new Pip(new Dice());

        assertThat(pip.getMagicDamagePoints().getValue()).isEqualTo(0);
        Spell.HEP.getEffect().apply(pip);

        assertThat(pip.getMagicDamagePoints().getValue()).isEqualTo(10);
    }

}
