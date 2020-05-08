package fr.jsmadja.antredesdragons.core.spellcasting;

import fr.jsmadja.antredesdragons.core.entities.Pip;

public class SpellNIP extends Spell {
    @Override
    public void onCast(Pip pip) {
        pip.setAbleToOpenAnyItem(true);
    }

    @Override
    public void onChapterEnd(Pip pip) {
        pip.setAbleToOpenAnyItem(false);
    }

}
