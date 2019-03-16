package fr.jsmadja.antredesdragons;

class Pip {
    private final Dice dice;

    Pip(Dice dice) {
        this.dice = dice;
    }

    int getInitialHealthPoints() {
        return this.dice.roll(2) * 4;
    }
}
