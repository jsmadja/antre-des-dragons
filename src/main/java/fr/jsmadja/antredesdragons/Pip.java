package fr.jsmadja.antredesdragons;

class Pip extends Entity {

    private Sword sword;

    Pip(Dice dice) {
        super(dice, dice.roll(2) * 4);
    }

    @Override
    boolean isFoe() {
        return false;
    }

    void setSword(Sword sword) {
        this.sword = sword;
    }

    @Override
    int getTouchCap() {
        return this.sword == null ? super.getTouchCap() : this.sword.getTouchCap();
    }

    public int getAdditionalDamagePoints() {
        return this.sword == null ? 0 : this.sword.getDamagePoints();
    }
}
