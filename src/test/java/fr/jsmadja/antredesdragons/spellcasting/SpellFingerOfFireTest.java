package fr.jsmadja.antredesdragons.spellcasting;

import fr.jsmadja.antredesdragons.dices.Dice;
import fr.jsmadja.antredesdragons.entities.Foe;
import fr.jsmadja.antredesdragons.entities.Pip;
import org.junit.jupiter.api.Test;

import static fr.jsmadja.antredesdragons.stuff.HealthPoints.hp;
import static fr.jsmadja.antredesdragons.stuff.Item.FINGER_OF_FIRE;
import static org.assertj.core.api.Assertions.assertThat;

class SpellFingerOfFireTest {

    @Test
    public void FINGER_OF_FIRE_should_give_10_items() {
        Pip pip = new Pip(new Dice());
        assertThat(pip.has(FINGER_OF_FIRE)).isFalse();

        Spell spell = new SpellFingerOfFire();

        spell.onCast(pip);
        assertThat(pip.has(FINGER_OF_FIRE)).isTrue();
        assertThat(pip.getInventory().stream().filter(i -> i == FINGER_OF_FIRE).count()).isEqualTo(10);

        Foe target = Foe.builder().initialHealthPoints(hp(10)).build();

        spell.onAttack(pip, target);
        assertThat(target.isDead()).isTrue();
        assertThat(pip.getInventory().stream().filter(i -> i == FINGER_OF_FIRE).count()).isEqualTo(9);

        spell.onChapterEnd(pip);
        assertThat(pip.has(FINGER_OF_FIRE)).isFalse();
    }

}
