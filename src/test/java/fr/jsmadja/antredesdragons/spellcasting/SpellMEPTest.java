package fr.jsmadja.antredesdragons.spellcasting;

import fr.jsmadja.antredesdragons.dices.Dice;
import fr.jsmadja.antredesdragons.entities.Pip;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SpellMEPTest {

    @Test
    public void MEP_should_be_able_to_strike_twice_during_the_fight_() {
        Pip pip = new Pip(new Dice());
        assertThat(pip.isAbleToStrikeTwice()).isFalse();

        Spell spell = new SpellMEP();
        spell.onCast(pip);
        assertThat(pip.isAbleToStrikeTwice()).isTrue();

        spell.onChapterEnd(pip);
        assertThat(pip.isAbleToStrikeTwice()).isFalse();
    }

}
