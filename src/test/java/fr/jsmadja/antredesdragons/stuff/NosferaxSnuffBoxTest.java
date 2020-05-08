package fr.jsmadja.antredesdragons.stuff;

import fr.jsmadja.antredesdragons.dices.Roll;
import fr.jsmadja.antredesdragons.entities.Pip;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class NosferaxSnuffBoxTest {

    @Test
    public void should_kill_pip_when_snuffbox_is_used_twice() {
        Pip pip = mock(Pip.class);
        when(pip.roll4Dices()).thenReturn(Roll.of(40), Roll.of(12));

        NosferaxSnuffBox nosferaxSnuffBox = new NosferaxSnuffBox(pip);
        assertThat(nosferaxSnuffBox.isUsable()).isTrue();

        HealthPoints healthPoints = nosferaxSnuffBox.use();
        assertThat(healthPoints.getValue()).isEqualTo(40);
        assertThat(nosferaxSnuffBox.isUsable()).isTrue();

        when(pip.isNosferaxSnuffBoxUsed()).thenReturn(true);
        healthPoints = nosferaxSnuffBox.use();
        assertThat(healthPoints.getValue()).isEqualTo(12);
        verify(pip, Mockito.times(1)).die();
    }

}
