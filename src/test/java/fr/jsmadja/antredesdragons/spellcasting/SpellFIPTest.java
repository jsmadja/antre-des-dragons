package fr.jsmadja.antredesdragons.spellcasting;

import fr.jsmadja.antredesdragons.dices.Dice;
import fr.jsmadja.antredesdragons.entities.Foe;
import fr.jsmadja.antredesdragons.entities.Pip;
import org.junit.jupiter.api.Test;

import static fr.jsmadja.antredesdragons.spellcasting.SpellBook.FIP;
import static org.assertj.core.api.Assertions.assertThat;

class SpellFIPTest {

    @Test
    public void FIP_should_damage_10_points() {
        Pip pip = new Pip(new Dice());
        Foe target = Foe.builder().initialHealthPoints(10).build();

        assertThat(target.getCurrentHealthPoints()).isEqualTo(10);
        assertThat(pip.getSpellsToCastDuringFight()).isEmpty();
        Spell spell = new SpellFIP();
        spell.onCast(pip);
        assertThat(pip.getSpellsToCastDuringFight()).contains(FIP);

        spell.onAttack(pip, target);

        assertThat(pip.getSpellsToCastDuringFight()).isEmpty();
        assertThat(target.getCurrentHealthPoints()).isEqualTo(0);
    }

}
