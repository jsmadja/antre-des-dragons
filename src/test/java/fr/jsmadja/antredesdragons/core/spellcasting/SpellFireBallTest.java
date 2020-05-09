package fr.jsmadja.antredesdragons.core.spellcasting;

import fr.jsmadja.antredesdragons.core.dices.Dice;
import fr.jsmadja.antredesdragons.core.entities.Foe;
import fr.jsmadja.antredesdragons.core.entities.Pip;
import fr.jsmadja.antredesdragons.core.inventory.Item;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static fr.jsmadja.antredesdragons.core.stuff.HealthPoints.hp;
import static org.assertj.core.api.Assertions.assertThat;

class SpellFireBallTest {

    @Test
    public void FIREBALL_should_give_2_items() {
        Pip pip = new Pip(new Dice());
        Assertions.assertThat(pip.has(Item.FIREBALL)).isFalse();

        Spell spell = new SpellFireBall();
        spell.onCast(pip);
        Assertions.assertThat(pip.has(Item.FIREBALL)).isTrue();
        assertThat(pip.getInventory().stream().filter(i -> i == Item.FIREBALL).count()).isEqualTo(2);

        Foe target = Foe.builder().initialHealthPoints(hp(75)).build();

        spell.onAttack(pip, target);
        assertThat(target.isDead()).isTrue();
        assertThat(pip.getInventory().stream().filter(i -> i == Item.FIREBALL).count()).isEqualTo(1);
    }

}
