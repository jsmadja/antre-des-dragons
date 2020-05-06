package fr.jsmadja.antredesdragons.spellcasting;

import fr.jsmadja.antredesdragons.dices.Dice;
import fr.jsmadja.antredesdragons.entities.Pip;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SpellNIPTest {

    @Test
    public void NIP_pip_can_open_any_item() {
        Pip pip = new Pip(new Dice());

        assertThat(pip.isAbleToOpenAnyItem()).isFalse();

        Spell spell = new SpellNIP();

        spell.onCast(pip);
        assertThat(pip.isAbleToOpenAnyItem()).isTrue();

        spell.onChapterEnd(pip);
        assertThat(pip.isAbleToOpenAnyItem()).isFalse();
    }

}
