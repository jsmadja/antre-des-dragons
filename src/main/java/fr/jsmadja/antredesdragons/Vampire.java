package fr.jsmadja.antredesdragons;

class Vampire extends Foe {
    Vampire(Dice dice, int healthPoints) {
        super(dice, healthPoints);
    }

    @Override
    boolean canInstantKill() {
        return true;
    }
}
