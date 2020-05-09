package fr.jsmadja.antredesdragons.core.spellcasting;

import fr.jsmadja.antredesdragons.core.dices.Dice;
import fr.jsmadja.antredesdragons.core.entities.Pip;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SpellHEPTest {

    @Test
    public void HEP_should_add_temporary_damages() {
        Pip pip = new Pip(new Dice());

        assertThat(pip.getMagicDamagePoints().getDamagePoints()).isEqualTo(0);
        Spell spell = new SpellHEP();

        spell.onCast(pip);

        assertThat(pip.getMagicDamagePoints().getDamagePoints()).isEqualTo(10);
    }

}
