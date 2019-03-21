package fr.jsmadja.antredesdragons;

class Pip extends Entity {

    Pip(Dice dice) {
        super(dice, dice.roll(2) * 4);
    }

}
