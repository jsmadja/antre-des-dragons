package fr.jsmadja.antredesdragons;

class Entity {
    private final Dice dice;
    private final int initialHealthPoints;
    private int healthPoints;

    private static final int TOUCH_CAP = 6;

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
        return roll - TOUCH_CAP < 0 ? 0 : roll - TOUCH_CAP;
    }

    private boolean touchOpponent(int roll) {
        return roll > TOUCH_CAP;
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
}
