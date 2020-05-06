package fr.jsmadja.antredesdragons.spellcasting;

import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.stuff.DamagePoint;

public class SpellHEP extends Spell {
    @Override
    public void onCast(Pip pip) {
        pip.addMagicDamagePoints(DamagePoint.damage(10));
    }
}
