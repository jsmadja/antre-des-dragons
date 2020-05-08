package fr.jsmadja.antredesdragons.skills;

import fr.jsmadja.antredesdragons.entities.Entity;
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
