package fr.jsmadja.antredesdragons.core.skills;

import fr.jsmadja.antredesdragons.core.entities.Entity;
import fr.jsmadja.antredesdragons.core.stuff.Item;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UseSpecialWeaponEveryNStrikes extends SpecialSkill {
    private final Item specialWeapon;
    private final int strikes;
    private Item previousWeapon;

    @Override
    public void onAttack(Entity attacker, Entity target) {
        int attackerStrikes = attacker.getStrikes();
        if (attacker.getEquipedWeapon().isPresent()) {
            Item equipedWeapon = attacker.getEquipedWeapon().get();
            if (isTimeToEquipSpecialWeapon(attackerStrikes)) {
                this.previousWeapon = attacker.unequip(equipedWeapon);
                attacker.equip(this.specialWeapon);
            } else if (equipedWeapon.equals(this.specialWeapon)) {
                attacker.unequip(equipedWeapon);
                attacker.equip(previousWeapon);
            }
        }
    }

    private boolean isTimeToEquipSpecialWeapon(int attackerStrikes) {
        return attackerStrikes > 0 && attackerStrikes % this.strikes == 0;
    }
}
