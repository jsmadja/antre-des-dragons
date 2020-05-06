package fr.jsmadja.antredesdragons.spellcasting;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum SpellBook {

    AEP(new SpellAEP()),
    HEP(new SpellHEP()),
    RIP(new SpellRIP()),
    FIP(new SpellFIP()),
    PAP(new SpellPAP()),
    NIP(new SpellNIP()),
    MEP(new SpellMEP()),
    INVISIBILITY(new SpellInvisibility()),
    FINGER_OF_FIRE(new SpellFingerOfFire()),
    FIREBALL(new SpellFireBall());

    @Getter
    private Spell spell;

}
