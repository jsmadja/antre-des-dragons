package fr.jsmadja.antredesdragons;

abstract class Entity {
    private final Dice dice;
    private final int initialHealthPoints;
    private int healthPoints;

    private static final int DEFAULT_TOUCH_CAP = 6;

    Entity(Dice dice, int initialHealthPoints) {
        this.dice = dice;
        this.initialHealthPoints = this.healthPoints = initialHealthPoints;
    }

    int roll2Dices() {
        return this.dice.roll(2);
    }

    int getInitialHealthPoints() {
        return this.initialHealthPoints;
    }

    int getHealthPoints() {
        return this.healthPoints;
    }

    Attack attacks() {
        int roll = this.roll2Dices();
        return new Attack(computeDamages(roll), touchOpponent(roll) ? Attack.Status.TOUCHED : Attack.Status.MISSED);
    }

    private int computeDamages(int roll) {
        return roll - DEFAULT_TOUCH_CAP < 0 ? 0 : roll - DEFAULT_TOUCH_CAP;
    }

    private boolean touchOpponent(int roll) {
        return roll > DEFAULT_TOUCH_CAP;
    }

    void wounds(int damagePoints) {
        this.healthPoints -= damagePoints;
        if (this.healthPoints < 0) {
            this.healthPoints = 0;
        }
    }

    boolean isDead() {
        return this.healthPoints <= 0;
    }

    boolean isStuned() {
        return this.initialHealthPoints > 5 && this.healthPoints == 5;
    }

    abstract boolean isFoe();
}
