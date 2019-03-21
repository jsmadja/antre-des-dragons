package fr.jsmadja.antredesdragons;

class Attack {
    private final int damagePoints;
    private Status status;

    Attack(int damagePoints, Status status) {
        this.damagePoints = damagePoints;
        this.status = status;
    }

    Status getStatus() {
        return status;
    }

    int getDamagePoints() {
        return damagePoints;
    }

    enum Status {
        TOUCHED, MISSED
    }
}
