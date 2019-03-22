package fr.jsmadja.antredesdragons;

class Foe extends Entity {
    Foe(Dice dice, int initialHealthPoints) {
        super("Foe", dice, initialHealthPoints);
        this.strength = this.roll2Dices();
    }

    @Override
    boolean isFoe() {
        return true;
    }
}
