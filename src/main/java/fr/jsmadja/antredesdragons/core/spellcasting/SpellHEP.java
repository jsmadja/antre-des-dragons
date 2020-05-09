package fr.jsmadja.antredesdragons.core.spellcasting;

import fr.jsmadja.antredesdragons.core.entities.Pip;
import fr.jsmadja.antredesdragons.core.stuff.DamagePoints;

public class SpellHEP extends Spell {
    @Override
    public void onCast(Pip pip) {
        pip.addMagicDamagePoints(DamagePoints.damage(10));
    }
}
