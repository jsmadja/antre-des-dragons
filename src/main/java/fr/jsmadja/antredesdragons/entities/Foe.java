package fr.jsmadja.antredesdragons.entities;

import fr.jsmadja.antredesdragons.dices.Dice;
import fr.jsmadja.antredesdragons.dices.HitRollRange;
import fr.jsmadja.antredesdragons.stuff.Sword;
import lombok.Builder;

public class Foe extends Entity {

    @Builder
    public Foe(String name, Dice dice, int initialHealthPoints, int armor, HitRollRange hitRollRange, Integer constantHitDamage, boolean immuneToPhysicalDamages, Sword sword) {
        super(name, dice == null ? new Dice() : dice, initialHealthPoints, armor, hitRollRange, constantHitDamage, immuneToPhysicalDamages, sword);
    }

    @Override
    public boolean isFoe() {
        return true;
    }
}
