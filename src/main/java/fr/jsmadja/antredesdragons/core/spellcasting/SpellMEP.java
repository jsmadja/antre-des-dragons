package fr.jsmadja.antredesdragons.core.spellcasting;

import fr.jsmadja.antredesdragons.core.entities.Pip;

public class SpellMEP extends Spell {
    @Override
    public void onCast(Pip pip) {
        pip.setAbleToStrikeTwice(true);
    }

    @Override
    public void onChapterEnd(Pip pip) {
        pip.setAbleToStrikeTwice(false);
    }

}
