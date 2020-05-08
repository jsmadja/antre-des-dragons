package fr.jsmadja.antredesdragons.stuff;

import fr.jsmadja.antredesdragons.entities.Entity;

public class NosferaxLollipop extends HealingItem {
    private int usages = 0;

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
            target.wounds(healthPoints.getValue());
            return healthPoints;
        }
        return use();
    }
}
