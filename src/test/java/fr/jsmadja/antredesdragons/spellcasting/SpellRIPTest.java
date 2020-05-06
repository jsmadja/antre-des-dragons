package fr.jsmadja.antredesdragons.spellcasting;

import fr.jsmadja.antredesdragons.dices.Dice;
import fr.jsmadja.antredesdragons.entities.Foe;
import fr.jsmadja.antredesdragons.entities.Pip;
import org.junit.jupiter.api.Test;

import static fr.jsmadja.antredesdragons.spellcasting.SpellBook.RIP;
import static org.assertj.core.api.Assertions.assertThat;

class SpellRIPTest {

    @Test
    public void RIP_should_add_missing_strike_malus_to_next_foe() {
        Pip pip = new Pip(new Dice());

        assertThat(pip.getSpellsToCastDuringFight()).isEmpty();
        Spell spell = new SpellRIP();
        spell.onCast(pip);
        assertThat(pip.getSpellsToCastDuringFight()).contains(RIP);

        Foe target = Foe.builder().build();
        spell.onAttack(pip, target);

        assertThat(pip.getSpellsToCastDuringFight()).isEmpty();
        assertThat(target.getMissMalusCount()).isEqualTo(3);
    }

}
