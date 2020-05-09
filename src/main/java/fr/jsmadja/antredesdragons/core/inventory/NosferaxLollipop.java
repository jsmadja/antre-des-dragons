package fr.jsmadja.antredesdragons.core.inventory;

import fr.jsmadja.antredesdragons.core.entities.Entity;
import fr.jsmadja.antredesdragons.core.stuff.HealthPoints;

public class NosferaxLollipop extends HealingItem {
    private int usages = 0;

    public NosferaxLollipop() {
        super("Sucette de Nosferax");
    }

    @Override
    public boolean isUsable() {
        return this.usages < 3;
    }

    @Override
    public HealthPoints use() {
        this.usages++;
        return HealthPoints.hp(0);
    }

    @Override
    public HealthPoints useDuringFight(Entity attacker, Entity target) {
        if (isUsable()) {
            this.usages++;
            HealthPoints healthPoints = attacker.getLostHealthPointsDuringCurrentFight();
            target.wounds(healthPoints.getHealthPoints());
            return healthPoints;
        }
        return use();
    }
}
