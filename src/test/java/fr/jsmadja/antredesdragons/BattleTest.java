package fr.jsmadja.antredesdragons;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BattleTest {

    @Test
    void should_run_a_battle() {
        Dice dice1 = mock(Dice.class);
        Dice dice2 = mock(Dice.class);

        Entity entity1 = new Entity(dice1, 10);
        Entity entity2 = new Entity(dice2, 10);

        Battle battle = new Battle();
        battle.addOpponent(entity1);
        battle.addOpponent(entity2);

        when(entity1.roll2Dices()).thenReturn(10);
        when(entity2.roll2Dices()).thenReturn(8);

        //
        // Round 1
        //

        // E1 attacks E2
        Entity attacker = battle.getNextAttacker();
        List<Entity> targets = battle.getTargets();
        assertEquals(entity1, attacker);
        assertEquals(entity2, targets.get(0));

        when(entity1.roll2Dices()).thenReturn(11);
        battle.attack(attacker, targets.get(0));

        assertEquals(5, entity2.getHealthPoints());

        // E2 attacks E1
        attacker = battle.getNextAttacker();
        targets = battle.getTargets();
        assertEquals(entity2, attacker);
        assertEquals(entity1, targets.get(0));
        when(entity2.roll2Dices()).thenReturn(7);
        battle.attack(attacker, targets.get(0));

        assertEquals(9, entity1.getHealthPoints());

        assertFalse(battle.isOver());

        //
        // Round 2
        //

        // E1 attacks E2
        attacker = battle.getNextAttacker();
        targets = battle.getTargets();
        assertEquals(entity1, attacker);
        assertEquals(entity2, targets.get(0));

        when(entity1.roll2Dices()).thenReturn(11);
        battle.attack(attacker, targets.get(0));

        assertEquals(0, entity2.getHealthPoints());

        assertTrue(battle.isOver());
    }

}
