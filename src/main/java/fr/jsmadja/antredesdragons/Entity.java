package fr.jsmadja.antredesdragons;

abstract class Entity {
    private final Dice dice;
    private final int initialHealthPoints;
    private int healthPoints;
    private int maximumHealthPoints;

    private static final int DEFAULT_TOUCH_CAP = 6;

    Entity(Dice dice, int initialHealthPoints) {
        this.dice = dice;
        this.initialHealthPoints = this.healthPoints = initialHealthPoints;
        this.maximumHealthPoints = this.initialHealthPoints;
    }

    int roll1Dice() {
        return this.dice.roll();
    }

    int roll2Dices() {
        return this.dice.roll(2);
    }

    int roll3Dices() {
        return this.dice.roll(3);
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
        if (roll - getTouchCap() < 0) {
            return 0;
        }
        return roll - getTouchCap() + getAdditionalDamagePoints();
    }

    int getAdditionalDamagePoints() {
        return 0;
    }

    private boolean touchOpponent(int roll) {
        return roll > getTouchCap();
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

    int getTouchCap() {
        return DEFAULT_TOUCH_CAP;
    }

    boolean isFriendlyWith(Pip pip) {
        return this.dice.roll() < pip.roll3Dices();
    }

    void restoreHealthPoints(int restoredHealthPoints) {
        this.healthPoints = Math.min(this.healthPoints + restoredHealthPoints, this.maximumHealthPoints);
    }

}
