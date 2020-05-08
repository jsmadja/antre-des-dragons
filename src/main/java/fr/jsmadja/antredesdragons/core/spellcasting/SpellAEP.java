package fr.jsmadja.antredesdragons.core.spellcasting;

import fr.jsmadja.antredesdragons.core.entities.Pip;

import static fr.jsmadja.antredesdragons.core.stuff.ArmorPoint.armor;

public class SpellAEP extends Spell {
    @Override
    public void onCast(Pip pip) {
        pip.addMagicalArmorPoints(armor(4));
    }
}
