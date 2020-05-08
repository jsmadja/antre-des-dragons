package fr.jsmadja.antredesdragons.spellcasting;

import fr.jsmadja.antredesdragons.dices.Dice;
import fr.jsmadja.antredesdragons.entities.Foe;
import fr.jsmadja.antredesdragons.entities.Pip;
import org.junit.jupiter.api.Test;

import static fr.jsmadja.antredesdragons.stuff.HealthPoints.hp;
import static fr.jsmadja.antredesdragons.stuff.Item.FIREBALL;
import static org.assertj.core.api.Assertions.assertThat;

class SpellFireBallTest {

    @Test
    public void FIREBALL_should_give_2_items() {
        Pip pip = new Pip(new Dice());
        assertThat(pip.has(FIREBALL)).isFalse();

        Spell spell = new SpellFireBall();
        spell.onCast(pip);
        assertThat(pip.has(FIREBALL)).isTrue();
        assertThat(pip.getInventory().stream().filter(i -> i == FIREBALL).count()).isEqualTo(2);

        Foe target = Foe.builder().initialHealthPoints(hp(75)).build();

        spell.onAttack(pip, target);
        assertThat(target.isDead()).isTrue();
        assertThat(pip.getInventory().stream().filter(i -> i == FIREBALL).count()).isEqualTo(1);
    }

}
