package fr.jsmadja.antredesdragons.core.stuff;

import fr.jsmadja.antredesdragons.core.entities.Entity;

public abstract class HealingItem {
    public abstract boolean isUsable();

    public abstract HealthPoints use();

    public abstract HealthPoints useDuringFight(Entity attacker, Entity target);
}
