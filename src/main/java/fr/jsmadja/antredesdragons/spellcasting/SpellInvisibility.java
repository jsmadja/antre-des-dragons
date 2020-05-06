package fr.jsmadja.antredesdragons.spellcasting;

import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.stuff.DamagePoint;

public class SpellInvisibility extends Spell {

    SpellInvisibility() {
        super(DamagePoint.damage(15), false, 1);
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
