package fr.jsmadja.antredesdragons;

class Foe extends Entity {
    Foe(Dice dice, int initialHealthPoints) {
        super(dice, initialHealthPoints);
    }

    @Override
    boolean isFoe() {
        return true;
    }
}
