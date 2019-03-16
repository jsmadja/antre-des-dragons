package fr.jsmadja.antredesdragons;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PipTest {

    @Test
    void should_initialize_pip_hp() {
        Dice dice = Mockito.mock(Dice.class);
        Mockito.when(dice.roll(2)).thenReturn(10);

        Pip pip = new Pip(dice);
        Assertions.assertEquals(40, pip.getInitialHealthPoints());
    }

}
