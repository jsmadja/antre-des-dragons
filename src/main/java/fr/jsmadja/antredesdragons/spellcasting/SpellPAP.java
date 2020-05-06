package fr.jsmadja.antredesdragons.spellcasting;

import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.ui.Events;

public class SpellPAP extends Spell {
    @Override
    public void onCast(Pip pip) {
        if (pip.isPoisoned()) {
            Events.spellEvent("Pip est déjà empoisonné, le sortilège est inopérant");
        } else {
            Events.spellEvent("Pip est immunisé contre le poison");
            pip.setImmuneToPoison(true);
        }
    }

    @Override
    public void onChapterEnd(Pip pip) {
        pip.setImmuneToPoison(false);
    }

}
