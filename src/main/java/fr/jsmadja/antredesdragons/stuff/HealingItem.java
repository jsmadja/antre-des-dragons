package fr.jsmadja.antredesdragons.stuff;

import fr.jsmadja.antredesdragons.entities.Entity;

public abstract class HealingItem {
    public abstract boolean isUsable();

    public abstract HealthPoints use();

    public abstract HealthPoints useDuringFight(Entity attacker, Entity target);
}
