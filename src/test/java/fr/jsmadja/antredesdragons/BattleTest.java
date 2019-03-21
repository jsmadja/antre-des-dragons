package fr.jsmadja.antredesdragons;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BattleTest {

    @Test
    void should_kill_an_opponent_in_a_battle() {
        Dice pipDice = mock(Dice.class);
        Dice foeDice = mock(Dice.class);

        when(pipDice.roll(2)).thenReturn(10);
        Entity pip = new Pip(pipDice);
        Entity foe = new Foe(foeDice, 10);

        Battle battle = new Battle();
        battle.addOpponent(pip);
        battle.addOpponent(foe);

        when(pip.roll2Dices()).thenReturn(10);
        when(foe.roll2Dices()).thenReturn(8);

        //
        // Round 1
        //

        // E1 attacks E2
        Entity attacker = battle.getNextAttacker();
        List<Entity> targets = battle.getTargets();
        assertEquals(pip, attacker);
        assertEquals(foe, targets.get(0));

        when(pip.roll2Dices()).thenReturn(10);
        battle.attack(attacker, targets.get(0));

        assertEquals(6, foe.getHealthPoints());

        // E2 attacks E1
        attacker = battle.getNextAttacker();
        targets = battle.getTargets();
        assertEquals(foe, attacker);
        assertEquals(pip, targets.get(0));
        when(foe.roll2Dices()).thenReturn(7);
        battle.attack(attacker, targets.get(0));

        assertEquals(39, pip.getHealthPoints());

        assertFalse(battle.isOver());

        //
        // Round 2
        //

        // E1 attacks E2
        attacker = battle.getNextAttacker();
        targets = battle.getTargets();
        assertEquals(pip, attacker);
        assertEquals(foe, targets.get(0));

        when(pip.roll2Dices()).thenReturn(12);
        battle.attack(attacker, targets.get(0));

        assertEquals(0, foe.getHealthPoints());

        assertTrue(battle.isOver());
    }

    @Test
    void should_stun_an_opponent_in_a_battle() {
        Dice dice1 = mock(Dice.class);
        Dice dice2 = mock(Dice.class);

        when(dice1.roll(2)).thenReturn(10);
        Entity entity1 = new Pip(dice1);
        Entity entity2 = new Foe(dice2, 10);

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

        assertTrue(battle.isOver());
    }

}