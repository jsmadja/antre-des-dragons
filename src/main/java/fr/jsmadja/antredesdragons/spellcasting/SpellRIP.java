package fr.jsmadja.antredesdragons.spellcasting;

import fr.jsmadja.antredesdragons.entities.Entity;
import fr.jsmadja.antredesdragons.entities.Pip;

public class SpellRIP extends Spell {

    @Override
    public void onCast(Pip pip) {
        pip.addSpellToCast(SpellBook.RIP);
    }

    @Override
    public void onAttack(Pip pip, Entity target) {
        target.setMissMalusCount(3);
        pip.removeSpellToCast(SpellBook.RIP);
    }

}
