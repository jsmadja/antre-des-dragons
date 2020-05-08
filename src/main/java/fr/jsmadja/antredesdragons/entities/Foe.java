package fr.jsmadja.antredesdragons.entities;

import fr.jsmadja.antredesdragons.dices.Dice;
import fr.jsmadja.antredesdragons.dices.HitRollRange;
import lombok.Builder;

public class Foe extends Entity {

    private boolean dragon;

    @Builder
    public Foe(String name, Dice dice, int initialHealthPoints, HitRollRange hitRollRange, Integer constantHitDamage, boolean immuneToPhysicalDamages, boolean dragon, Integer requiredStrikesInARowToHitInvisible) {
        super(name, dice == null ? new Dice() : dice, initialHealthPoints, hitRollRange, constantHitDamage, immuneToPhysicalDamages, requiredStrikesInARowToHitInvisible);
        this.dragon = dragon;
    }

    @Override
    public boolean isFoe() {
        return true;
    }

    @Override
    protected boolean isDragon() {
        return dragon;
    }
}
