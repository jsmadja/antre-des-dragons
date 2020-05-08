package fr.jsmadja.antredesdragons.core.spellcasting;

import fr.jsmadja.antredesdragons.core.dices.Dice;
import fr.jsmadja.antredesdragons.core.entities.Foe;
import fr.jsmadja.antredesdragons.core.entities.Pip;
import org.junit.jupiter.api.Test;

import static fr.jsmadja.antredesdragons.core.spellcasting.SpellBook.FIP;
import static fr.jsmadja.antredesdragons.core.stuff.HealthPoints.hp;
import static org.assertj.core.api.Assertions.assertThat;

class SpellFIPTest {

    @Test
    public void FIP_should_damage_10_points() {
        Pip pip = new Pip(new Dice());
        Foe target = Foe.builder().initialHealthPoints(hp(10)).build();

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
