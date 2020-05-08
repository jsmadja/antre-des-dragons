package fr.jsmadja.antredesdragons.core.skills;

import fr.jsmadja.antredesdragons.core.entities.Entity;

public abstract class SpecialSkill {
    public abstract void onAttack(Entity attacker, Entity target);
}
