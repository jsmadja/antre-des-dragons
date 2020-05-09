package fr.jsmadja.antredesdragons.core.inventory;

import fr.jsmadja.antredesdragons.core.entities.Entity;
import fr.jsmadja.antredesdragons.core.stuff.HealthPoints;
import lombok.Getter;

import static fr.jsmadja.antredesdragons.core.stuff.HealthPoints.hp;

public class Ointment extends HealingItem {

    @Getter
    private boolean usable = true;

    public Ointment() {
        super("Onguent");
    }

    @Override
    public HealthPoints use() {
        if (isUsable()) {
            this.usable = false;
            return hp(5);
        }
        return hp(0);
    }

    @Override
    public HealthPoints useDuringFight(Entity attacker, Entity target) {
        return this.use();
    }

    @Override
    public String toString() {
        return "Onguent (5 HP)";
    }

}
