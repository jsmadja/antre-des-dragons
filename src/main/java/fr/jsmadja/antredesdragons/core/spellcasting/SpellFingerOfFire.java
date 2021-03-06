package fr.jsmadja.antredesdragons.core.spellcasting;

import fr.jsmadja.antredesdragons.core.entities.Entity;
import fr.jsmadja.antredesdragons.core.entities.Pip;
import fr.jsmadja.antredesdragons.core.inventory.Item;
import fr.jsmadja.antredesdragons.core.stuff.DamagePoints;

import java.util.stream.IntStream;

public class SpellFingerOfFire extends Spell {

    SpellFingerOfFire() {
        super(DamagePoints.damage(3), true, 1);
    }

    @Override
    public void onCast(Pip pip) {
        IntStream.range(0, 10).forEach(i -> pip.add(Item.FINGER_OF_FIRE));
    }

    @Override
    public void onAttack(Pip pip, Entity target) {
        if (pip.has(Item.FINGER_OF_FIRE)) {
            target.wounds(10);
            pip.remove(Item.FINGER_OF_FIRE);
        }
    }

    @Override
    public void onChapterEnd(Pip pip) {
        pip.removeAll(Item.FINGER_OF_FIRE);
    }

}
