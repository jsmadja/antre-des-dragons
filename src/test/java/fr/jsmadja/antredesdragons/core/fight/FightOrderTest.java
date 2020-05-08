package fr.jsmadja.antredesdragons.core.fight;

import fr.jsmadja.antredesdragons.core.dices.Roll;
import fr.jsmadja.antredesdragons.core.entities.Entity;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FightOrderTest {

    @Test
    public void entity2_should_be_the_first_to_attack_by_roll() {
        Entity entity1 = mock(Entity.class);
        Entity entity2 = mock(Entity.class);

        when(entity1.roll2Dices()).thenReturn(Roll.roll(2));
        when(entity2.roll2Dices()).thenReturn(Roll.roll(4));

        FightOrder.Entity2DiceRoll o1 = new FightOrder.Entity2DiceRoll(entity1);
        FightOrder.Entity2DiceRoll o2 = new FightOrder.Entity2DiceRoll(entity2);

        int compare = new FightOrder().compare(o1, o2);

        assertThat(compare).isPositive();
    }

    @Test
    public void entity1_should_be_the_first_to_attack_by_roll() {
        Entity entity1 = mock(Entity.class);
        Entity entity2 = mock(Entity.class);

        when(entity1.roll2Dices()).thenReturn(Roll.roll(4));
        when(entity2.roll2Dices()).thenReturn(Roll.roll(2));

        FightOrder.Entity2DiceRoll o1 = new FightOrder.Entity2DiceRoll(entity1);
        FightOrder.Entity2DiceRoll o2 = new FightOrder.Entity2DiceRoll(entity2);

        int compare = new FightOrder().compare(o1, o2);

        assertThat(compare).isNegative();
    }

    @Test
    public void entity2_should_be_the_first_to_attack_because_entity_1_lose_initiative() {
        Entity entity1 = mock(Entity.class);
        Entity entity2 = mock(Entity.class);

        when(entity1.isLoseInitiative()).thenReturn(true);
        when(entity1.roll2Dices()).thenReturn(Roll.roll(10));
        when(entity2.roll2Dices()).thenReturn(Roll.roll(4));

        FightOrder.Entity2DiceRoll o1 = new FightOrder.Entity2DiceRoll(entity1);
        FightOrder.Entity2DiceRoll o2 = new FightOrder.Entity2DiceRoll(entity2);

        int compare = new FightOrder().compare(o1, o2);

        assertThat(compare).isPositive();
    }

    @Test
    public void entity1_should_be_the_first_to_attack_because_entity_2_lose_initiative() {
        Entity entity1 = mock(Entity.class);
        Entity entity2 = mock(Entity.class);

        when(entity1.roll2Dices()).thenReturn(Roll.roll(4));
        when(entity2.roll2Dices()).thenReturn(Roll.roll(10));
        when(entity2.isLoseInitiative()).thenReturn(true);

        FightOrder.Entity2DiceRoll o1 = new FightOrder.Entity2DiceRoll(entity1);
        FightOrder.Entity2DiceRoll o2 = new FightOrder.Entity2DiceRoll(entity2);

        int compare = new FightOrder().compare(o1, o2);

        assertThat(compare).isNegative();
    }

}
