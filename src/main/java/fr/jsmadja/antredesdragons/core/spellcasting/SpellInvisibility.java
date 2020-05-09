package fr.jsmadja.antredesdragons.core.spellcasting;

import fr.jsmadja.antredesdragons.core.entities.Pip;
import fr.jsmadja.antredesdragons.core.stuff.DamagePoints;

public class SpellInvisibility extends Spell {

    SpellInvisibility() {
        super(DamagePoints.damage(15), false, 1);
    }

    @Override
    public void onCast(Pip pip) {
        pip.setInvisible(true);
    }

    @Override
    public void onChapterEnd(Pip pip) {
        pip.setInvisible(false);
    }

}
