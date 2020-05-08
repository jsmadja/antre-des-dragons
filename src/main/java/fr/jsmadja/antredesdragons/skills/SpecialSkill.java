package fr.jsmadja.antredesdragons.skills;

import fr.jsmadja.antredesdragons.entities.Entity;

public abstract class SpecialSkill {
    public abstract void onAttack(Entity attacker, Entity target);
}
