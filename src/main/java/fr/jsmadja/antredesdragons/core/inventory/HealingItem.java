package fr.jsmadja.antredesdragons.core.inventory;

import fr.jsmadja.antredesdragons.core.entities.Entity;
import fr.jsmadja.antredesdragons.core.stuff.HealthPoints;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public abstract class HealingItem {

    protected final String name;

    public abstract boolean isUsable();

    public abstract HealthPoints use();

    public abstract HealthPoints useDuringFight(Entity attacker, Entity target);
}
