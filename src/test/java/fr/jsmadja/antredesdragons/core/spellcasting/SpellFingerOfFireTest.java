package fr.jsmadja.antredesdragons.core.spellcasting;

import fr.jsmadja.antredesdragons.core.dices.Dice;
import fr.jsmadja.antredesdragons.core.entities.Foe;
import fr.jsmadja.antredesdragons.core.entities.Pip;
import fr.jsmadja.antredesdragons.core.inventory.Item;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static fr.jsmadja.antredesdragons.core.stuff.HealthPoints.hp;
import static org.assertj.core.api.Assertions.assertThat;

class SpellFingerOfFireTest {

    @Test
    public void FINGER_OF_FIRE_should_give_10_items() {
        Pip pip = new Pip(new Dice());
        Assertions.assertThat(pip.has(Item.FINGER_OF_FIRE)).isFalse();

        Spell spell = new SpellFingerOfFire();

        spell.onCast(pip);
        Assertions.assertThat(pip.has(Item.FINGER_OF_FIRE)).isTrue();
        assertThat(pip.getInventory().stream().filter(i -> i == Item.FINGER_OF_FIRE).count()).isEqualTo(10);

        Foe target = Foe.builder().initialHealthPoints(hp(10)).build();

        spell.onAttack(pip, target);
        assertThat(target.isDead()).isTrue();
        assertThat(pip.getInventory().stream().filter(i -> i == Item.FINGER_OF_FIRE).count()).isEqualTo(9);

        spell.onChapterEnd(pip);
        Assertions.assertThat(pip.has(Item.FINGER_OF_FIRE)).isFalse();
    }

}
