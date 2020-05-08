package fr.jsmadja.antredesdragons.stuff;

import fr.jsmadja.antredesdragons.entities.Entity;
import lombok.Getter;

import static fr.jsmadja.antredesdragons.stuff.HealthPoints.hp;

public class Ointment extends HealingItem {

    @Getter
    private boolean usable = true;

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
