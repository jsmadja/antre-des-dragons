package fr.jsmadja.antredesdragons.core.spellcasting;

import fr.jsmadja.antredesdragons.core.dices.Dice;
import fr.jsmadja.antredesdragons.core.entities.Pip;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SpellAEPTest {

    @Test
    public void AEP_should_add_temporary_armor() {
        Pip pip = new Pip(new Dice());

        assertThat(pip.getMagicArmorPoints().getArmorPoints()).isEqualTo(0);

        new SpellAEP().onCast(pip);

        assertThat(pip.getMagicArmorPoints().getArmorPoints()).isEqualTo(4);
    }

}
