package fr.jsmadja.antredesdragons.skills;

import fr.jsmadja.antredesdragons.entities.Entity;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class InstantKillWithStrikesInARowSpecialSkill extends SpecialSkill {
    private final int strikesInARow;

    @Override
    public void onAttack(Entity attacker, Entity target) {
        if (attacker.getStrikesInARow() >= this.strikesInARow) {
            target.kill();
        }
    }

}
