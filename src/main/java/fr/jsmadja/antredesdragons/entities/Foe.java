package fr.jsmadja.antredesdragons.entities;

import fr.jsmadja.antredesdragons.dices.Dice;
import fr.jsmadja.antredesdragons.dices.HitRollRange;
import lombok.Builder;

public class Foe extends Entity {

    @Builder
    public Foe(String name, Dice dice, int initialHealthPoints, HitRollRange hitRollRange, Integer constantHitDamage, boolean immuneToPhysicalDamages) {
        super(name, dice == null ? new Dice() : dice, initialHealthPoints, hitRollRange, constantHitDamage, immuneToPhysicalDamages);
    }

    @Override
    public boolean isFoe() {
        return true;
    }
}
