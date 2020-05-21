package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.dices.Dice;
import fr.jsmadja.antredesdragons.core.entities.Pip;
import fr.jsmadja.antredesdragons.core.execution.Execution;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static fr.jsmadja.antredesdragons.core.dices.Roll.roll;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class Chapter24Test {

    @Test
    public void should_fight_ghost_and_pip_wins() {
        Chapter24 chapter24 = new Chapter24();
        Dice dice = Mockito.mock(Dice.class);
        when(dice.roll()).thenReturn(6);
        when(dice.roll(2)).thenReturn(roll(12));
        when(dice.roll(3)).thenReturn(roll(18));
        Pip pip = new Pip(dice);
        pip.initialize();
        Execution execution = chapter24.execute(pip);
        execution.getFoes().forEach(foe -> assertThat(foe.isDead()).isTrue());
        assertThat(pip.isDead()).isFalse();
    }

}
