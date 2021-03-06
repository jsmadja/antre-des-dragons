package fr.jsmadja.antredesdragons.core.spellcasting;

import fr.jsmadja.antredesdragons.core.dices.Dice;
import fr.jsmadja.antredesdragons.core.entities.Pip;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SpellInvisibilityTest {

    @Test
    public void INVISIBILITY_should_set_pip_invisible() {
        Pip pip = new Pip(new Dice());

        assertThat(pip.isInvisible()).isFalse();
        Spell spell = new SpellInvisibility();

        spell.onCast(pip);

        assertThat(pip.isInvisible()).isTrue();

        spell.onChapterEnd(pip);
        assertThat(pip.isInvisible()).isFalse();
    }

}
