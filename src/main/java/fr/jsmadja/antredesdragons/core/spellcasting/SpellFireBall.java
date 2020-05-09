package fr.jsmadja.antredesdragons.core.spellcasting;

import fr.jsmadja.antredesdragons.core.entities.Entity;
import fr.jsmadja.antredesdragons.core.entities.Pip;
import fr.jsmadja.antredesdragons.core.inventory.Item;

public class SpellFireBall extends Spell {
    @Override
    public void onCast(Pip pip) {
        pip.add(Item.FIREBALL);
        pip.add(Item.FIREBALL);
    }

    @Override
    public void onAttack(Pip pip, Entity target) {
        if (pip.has(Item.FIREBALL)) {
            target.wounds(75);
            pip.remove(Item.FIREBALL);
        }
    }

}
