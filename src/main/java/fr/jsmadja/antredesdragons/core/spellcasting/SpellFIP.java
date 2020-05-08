package fr.jsmadja.antredesdragons.core.spellcasting;

import fr.jsmadja.antredesdragons.core.entities.Entity;
import fr.jsmadja.antredesdragons.core.entities.Pip;

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
