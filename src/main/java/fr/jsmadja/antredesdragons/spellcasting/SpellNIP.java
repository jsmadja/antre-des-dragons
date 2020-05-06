package fr.jsmadja.antredesdragons.spellcasting;

import fr.jsmadja.antredesdragons.entities.Pip;

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
