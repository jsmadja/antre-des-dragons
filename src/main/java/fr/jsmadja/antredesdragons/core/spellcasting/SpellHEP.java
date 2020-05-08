package fr.jsmadja.antredesdragons.core.spellcasting;

import fr.jsmadja.antredesdragons.core.entities.Pip;
import fr.jsmadja.antredesdragons.core.stuff.DamagePoint;

public class SpellHEP extends Spell {
    @Override
    public void onCast(Pip pip) {
        pip.addMagicDamagePoints(DamagePoint.damage(10));
    }
}
