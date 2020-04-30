package fr.jsmadja.antredesdragons.fight;

public class PhysicalAttack {
    private final int damagePoints;
    private Status status;

    public PhysicalAttack(int damagePoints, Status status) {
        this.damagePoints = damagePoints;
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public int getDamagePoints() {
        return damagePoints;
    }

    public enum Status {
        TOUCHED, MISSED
    }
}
