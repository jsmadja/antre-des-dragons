package fr.jsmadja.antredesdragons.spellcasting;

import fr.jsmadja.antredesdragons.entities.Entity;
import fr.jsmadja.antredesdragons.entities.Pip;

public class SpellFIP extends Spell {
    @Override
    public void onCast(Pip pip) {
        pip.addSpellToCast(SpellBook.FIP);
    }

    @Override
    public void onAttack(Pip pip, Entity target) {
        target.wounds(10);
        pip.removeSpellToCast(SpellBook.FIP);
    }

}
