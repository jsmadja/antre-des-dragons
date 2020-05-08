package fr.jsmadja.antredesdragons.stuff;

import fr.jsmadja.antredesdragons.entities.Entity;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.stream.IntStream;

import static fr.jsmadja.antredesdragons.stuff.HealthPoints.hp;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class NosferaxLollipopTest {

    @Test
    public void should_not_use_lollipop_without_a_fight() {
        NosferaxLollipop nosferaxLollipop = new NosferaxLollipop();
        HealthPoints healthPoints = nosferaxLollipop.use();
        assertThat(nosferaxLollipop.isUsable()).isTrue();
        assertThat(healthPoints.getValue()).isEqualTo(0);
    }

    @Test
    public void should_restore_hp_lost_during_fight() {
        NosferaxLollipop nosferaxLollipop = new NosferaxLollipop();
        Entity attacker = mock(Entity.class);
        Entity target = mock(Entity.class);

        when(attacker.getLostHealthPointsDuringCurrentFight()).thenReturn(hp(10));

        assertThat(nosferaxLollipop.isUsable()).isTrue();
        HealthPoints healthPoints = nosferaxLollipop.useDuringFight(attacker, target);
        assertThat(healthPoints.getValue()).isEqualTo(10);
    }

    @Test
    public void should_wound_target_with_attacker_hp_lost_during_fight() {
        NosferaxLollipop nosferaxLollipop = new NosferaxLollipop();
        Entity attacker = mock(Entity.class);
        Entity target = mock(Entity.class);

        when(attacker.getLostHealthPointsDuringCurrentFight()).thenReturn(hp(10));

        assertThat(nosferaxLollipop.isUsable()).isTrue();
        nosferaxLollipop.useDuringFight(attacker, target);

        ArgumentCaptor<Integer> damagesArgumentCaptor = ArgumentCaptor.forClass(Integer.class);

        verify(target).wounds(damagesArgumentCaptor.capture());

        int damages = damagesArgumentCaptor.getValue();
        assertThat(damages).isEqualTo(10);
    }

    @Test
    public void should_not_use_lollipop_more_than_3_times() {
        NosferaxLollipop nosferaxLollipop = new NosferaxLollipop();
        Entity attacker = mock(Entity.class);
        Entity target = mock(Entity.class);

        when(attacker.getLostHealthPointsDuringCurrentFight()).thenReturn(hp(10));

        IntStream.range(0, 3).forEach(i -> {
            assertThat(nosferaxLollipop.isUsable()).isTrue();
            nosferaxLollipop.useDuringFight(attacker, target);
        });
        assertThat(nosferaxLollipop.isUsable()).isFalse();
    }

}
