package fr.jsmadja.antredesdragons.spellcasting;

import fr.jsmadja.antredesdragons.dices.Dice;
import fr.jsmadja.antredesdragons.entities.Pip;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SpellHEPTest {

    @Test
    public void HEP_should_add_temporary_damages() {
        Pip pip = new Pip(new Dice());

        assertThat(pip.getMagicDamagePoints().getValue()).isEqualTo(0);
        Spell spell = new SpellHEP();

        spell.onCast(pip);

        assertThat(pip.getMagicDamagePoints().getValue()).isEqualTo(10);
    }

}
