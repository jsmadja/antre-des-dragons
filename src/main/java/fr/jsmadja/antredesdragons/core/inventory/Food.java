package fr.jsmadja.antredesdragons.core.inventory;

import fr.jsmadja.antredesdragons.core.entities.Entity;
import fr.jsmadja.antredesdragons.core.stuff.HealthPoints;

import static fr.jsmadja.antredesdragons.core.stuff.HealthPoints.hp;
import static java.lang.Integer.MAX_VALUE;

public class Food extends HealingItem {

    private boolean used;

    public Food() {
        super("Nourriture");
    }

    @Override
    public boolean isUsable() {
        return !used;
    }

    @Override
    public HealthPoints use() {
        if (isUsable()) {
            this.used = true;
            return hp(MAX_VALUE);
        }
        return hp(0);
    }

    @Override
    public HealthPoints useDuringFight(Entity attacker, Entity target) {
        return this.use();
    }

    @Override
    public String toString() {
        return "Nourriture";
    }
}
