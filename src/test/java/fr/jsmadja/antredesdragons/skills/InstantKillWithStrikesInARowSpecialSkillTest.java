package fr.jsmadja.antredesdragons.skills;

import fr.jsmadja.antredesdragons.entities.Entity;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class InstantKillWithStrikesInARowSpecialSkillTest {

    @Test
    public void should_instant_kill_target_if_attacker_made_two_strikes_in_a_row() {
        InstantKillWithStrikesInARowSpecialSkill specialSkill = new InstantKillWithStrikesInARowSpecialSkill(2);

        Entity attacker = mock(Entity.class);
        Entity target = mock(Entity.class);

        when(attacker.getStrikesInARow()).thenReturn(0);
        specialSkill.onAttack(attacker, target);
        verify(target, never()).die();

        when(attacker.getStrikesInARow()).thenReturn(1);
        specialSkill.onAttack(attacker, target);
        verify(target, never()).die();

        when(attacker.getStrikesInARow()).thenReturn(2);
        specialSkill.onAttack(attacker, target);
        verify(target, times(1)).die();
    }

}
