package fr.jsmadja.antredesdragons;

class Pip extends Entity {

    Pip(Dice dice) {
        super(dice, dice.roll(2) * 4);
    }

    @Override
    boolean isFoe() {
        return false;
    }
}
