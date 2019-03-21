package fr.jsmadja.antredesdragons;

class Entity2DieRoll {

    private final Entity entity;
    private final int roll;

    Entity2DieRoll(Entity entity) {
        this.entity = entity;
        this.roll = entity.roll2Dices();
    }

    int getRoll() {
        return roll;
    }

    Entity getEntity() {
        return entity;
    }
}
