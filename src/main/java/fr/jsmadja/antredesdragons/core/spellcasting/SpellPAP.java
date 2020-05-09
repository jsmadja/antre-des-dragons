package fr.jsmadja.antredesdragons.core.spellcasting;

import fr.jsmadja.antredesdragons.core.entities.Pip;

public class SpellPAP extends Spell {
    @Override
    public void onCast(Pip pip) {
        if (pip.isPoisoned()) {
            pip.logSpell("Pip est déjà empoisonné, le sortilège est inopérant");
        } else {
            pip.logSpell("Pip est immunisé contre le poison");
            pip.setImmuneToPoison(true);
        }
    }

    @Override
    public void onChapterEnd(Pip pip) {
        pip.setImmuneToPoison(false);
    }

}
