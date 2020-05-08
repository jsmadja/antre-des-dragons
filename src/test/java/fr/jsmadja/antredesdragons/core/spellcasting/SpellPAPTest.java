package fr.jsmadja.antredesdragons.core.spellcasting;

import fr.jsmadja.antredesdragons.core.dices.Dice;
import fr.jsmadja.antredesdragons.core.entities.Pip;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SpellPAPTest {

    @Test
    public void PAP_should_immune_to_poison() {
        Pip pip = new Pip(new Dice());
        assertThat(pip.isImmuneToPoison()).isFalse();

        Spell spell = new SpellPAP();

        spell.onCast(pip);
        assertThat(pip.isImmuneToPoison()).isTrue();

        spell.onChapterEnd(pip);
        assertThat(pip.isImmuneToPoison()).isFalse();
    }

    @Test
    public void PAP_cant_work_on_an_already_poisoned_entity() {
        Pip pip = new Pip(new Dice());
        pip.setPoisoned(true);

        assertThat(pip.isImmuneToPoison()).isFalse();

        Spell spell = new SpellPAP();
        spell.onCast(pip);

        assertThat(pip.isImmuneToPoison()).isFalse();
    }

}
