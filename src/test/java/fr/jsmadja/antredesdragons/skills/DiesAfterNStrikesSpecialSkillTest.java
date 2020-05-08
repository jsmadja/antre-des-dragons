package fr.jsmadja.antredesdragons.skills;

import fr.jsmadja.antredesdragons.entities.Entity;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class DiesAfterNStrikesSpecialSkillTest {

    @Test
    public void should_die_after_1_strike() {
        DiesAfterNStrikesSpecialSkill diesAfterNStrikesSpecialSkill = new DiesAfterNStrikesSpecialSkill(1);

        Entity attacker = mock(Entity.class);
        Entity target = mock(Entity.class);

        when(attacker.getStrikes()).thenReturn(0);
        diesAfterNStrikesSpecialSkill.onAttack(attacker, target);
        verify(attacker, never()).die();

        when(attacker.getStrikes()).thenReturn(1);
        diesAfterNStrikesSpecialSkill.onAttack(attacker, target);
        verify(attacker, atLeastOnce()).die();
    }

}
