package fr.jsmadja.antredesdragons;

class Sword {
    private int touchCap;
    private int damagePoints;

    Sword(int touchCap, int damagePoints) {
        this.touchCap = touchCap;
        this.damagePoints = damagePoints;
    }

    int getTouchCap() {
        return touchCap;
    }

    int getDamagePoints() {
        return damagePoints;
    }
}
