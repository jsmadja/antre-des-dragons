package fr.jsmadja.antredesdragons.core.skills;

import fr.jsmadja.antredesdragons.core.entities.Entity;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DiesAfterNStrikesSpecialSkill extends SpecialSkill {
    private int strikes;

    @Override
    public void onAttack(Entity attacker, Entity target) {
        if (attacker.getStrikes() >= strikes) {
            attacker.die();
        }
    }
}
