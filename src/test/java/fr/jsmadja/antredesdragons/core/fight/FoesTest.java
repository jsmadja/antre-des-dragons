package fr.jsmadja.antredesdragons.core.fight;

import fr.jsmadja.antredesdragons.core.dices.Roll;
import fr.jsmadja.antredesdragons.core.entities.Foe;
import fr.jsmadja.antredesdragons.core.entities.Pip;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FoesTest {

    @Test
    public void should_compute_unfriendly_foes() {
        Pip pip = mock(Pip.class);

        Foe unfriendly1 = mock(Foe.class);
        Foe unfriendly2 = mock(Foe.class);

        Foe friendly1 = mock(Foe.class);
        Foe friendly2 = mock(Foe.class);

        when(pip.roll3Dices()).thenReturn(Roll.roll(4));

        when(unfriendly1.roll1Dice()).thenReturn(Roll.roll(1));
        when(unfriendly2.roll1Dice()).thenReturn(Roll.roll(3));

        when(friendly1.roll1Dice()).thenReturn(Roll.roll(5));
        when(friendly2.roll1Dice()).thenReturn(Roll.roll(6));

        List<Foe> foesList = List.of(unfriendly1, friendly1, unfriendly2, friendly2);
        Foes foes = new Foes(foesList, pip);
        assertThat(foes.getFriendlyFoes()).containsExactlyInAnyOrder(friendly1, friendly2);
        assertThat(foes.getUnfriendlyFoes()).containsExactlyInAnyOrder(unfriendly1, unfriendly2);
        assertThat(foes.getSize()).isEqualTo(4);
    }

    @Test
    public void should_count_dead_and_stuned() {
        Pip pip = mock(Pip.class);

        Foe unfriendly1 = mock(Foe.class);
        Foe unfriendly2 = mock(Foe.class);

        Foe friendly1 = mock(Foe.class);
        Foe friendly2 = mock(Foe.class);

        when(pip.roll3Dices()).thenReturn(Roll.roll(4));

        when(unfriendly1.roll1Dice()).thenReturn(Roll.roll(1));
        when(unfriendly1.isDead()).thenReturn(true);

        when(unfriendly2.roll1Dice()).thenReturn(Roll.roll(3));
        when(unfriendly2.isStuned()).thenReturn(true);

        when(friendly1.roll1Dice()).thenReturn(Roll.roll(5));
        when(friendly1.isDead()).thenReturn(true);

        when(friendly2.roll1Dice()).thenReturn(Roll.roll(6));
        when(friendly2.isStuned()).thenReturn(true);

        List<Foe> foesList = List.of(unfriendly1, friendly1, unfriendly2, friendly2);
        Foes foes = new Foes(foesList, pip);
        assertThat(foes.getUnableToFightCount()).isEqualTo(2);
    }

}
