package fr.jsmadja.antredesdragons.spellcasting;

import fr.jsmadja.antredesdragons.entities.Pip;

import static fr.jsmadja.antredesdragons.stuff.ArmorPoint.armor;

public class SpellAEP extends Spell {
    @Override
    public void onCast(Pip pip) {
        pip.addMagicalArmorPoints(armor(4));
    }
}
