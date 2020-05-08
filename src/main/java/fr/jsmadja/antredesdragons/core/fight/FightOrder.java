package fr.jsmadja.antredesdragons.core.fight;

import fr.jsmadja.antredesdragons.core.dices.Roll;
import fr.jsmadja.antredesdragons.core.entities.Entity;

import java.util.Comparator;

public class FightOrder implements Comparator<FightOrder.Entity2DiceRoll> {
    @Override
    public int compare(Entity2DiceRoll entity1, Entity2DiceRoll entity2) {
        if (entity1.entity.isLoseInitiative()) {
            return 1;
        }
        if (entity2.entity.isLoseInitiative()) {
            return -1;
        }
        return entity2.getRoll().getValue() - entity1.getRoll().getValue();
    }

    static class Entity2DiceRoll {

        private final Entity entity;
        private final Roll roll;

        public Entity2DiceRoll(Entity entity) {
            this.entity = entity;
            this.roll = entity.roll2Dices();
        }

        public Roll getRoll() {
            return roll;
        }

        public Entity getEntity() {
            return entity;
        }
    }


}
