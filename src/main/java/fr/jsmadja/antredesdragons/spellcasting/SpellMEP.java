package fr.jsmadja.antredesdragons.spellcasting;

import fr.jsmadja.antredesdragons.entities.Pip;

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
