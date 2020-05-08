package fr.jsmadja.antredesdragons.core.skills;

import fr.jsmadja.antredesdragons.core.entities.Entity;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class InstantKillWithStrikesInARowSpecialSkill extends SpecialSkill {
    private final int strikesInARow;

    @Override
    public void onAttack(Entity attacker, Entity target) {
        if (attacker.getStrikesInARow() >= this.strikesInARow) {
            target.die();
        }
    }

}
