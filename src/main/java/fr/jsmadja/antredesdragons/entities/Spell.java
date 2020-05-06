package fr.jsmadja.antredesdragons.entities;

import fr.jsmadja.antredesdragons.stuff.ArmorPoint;
import fr.jsmadja.antredesdragons.stuff.DamagePoint;
import fr.jsmadja.antredesdragons.ui.Events;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Spell {

    AEP(new SpellCastExecution() {
        @Override
        public void execute(Pip pip) {
            pip.addMagicalArmorPoints(ArmorPoint.armor(4));
        }
    }),

    HEP(new SpellCastExecution() {
        @Override
        public void execute(Pip pip) {
            pip.addMagicDamagePoints(DamagePoint.damage(10));
        }
    }),

    RIP(new SpellCastExecution() {
        @Override
        public void execute(Pip pip) {
            pip.addSpellToCast(Spell.RIP);
        }
    }, new SpellFightExecution() {
        @Override
        public void execute(Pip pip, Entity target) {
            target.setMissMalusCount(3);
            pip.removeSpellToCast(Spell.RIP);
        }
    }, SpellChapterEndExecution.nothing()),

    FIP(new SpellCastExecution() {
        @Override
        public void execute(Pip pip) {
            pip.addSpellToCast(Spell.FIP);
        }
    }, new SpellFightExecution() {
        @Override
        public void execute(Pip pip, Entity target) {
            target.wounds(10);
            pip.removeSpellToCast(Spell.FIP);
        }
    }, SpellChapterEndExecution.nothing()),

    PAP(new SpellCastExecution() {
        @Override
        public void execute(Pip pip) {
            if (pip.isPoisoned()) {
                Events.spellEvent("Pip est déjà empoisonné, le sortilège est inopérant");
            } else {
                Events.spellEvent("Pip est immunisé contre le poison");
                pip.setImmuneToPoison(true);
            }
        }
    }, SpellFightExecution.nothing(),
            new SpellChapterEndExecution() {
                @Override
                public void execute(Pip pip) {
                    pip.setImmuneToPoison(false);
                }
            }),

    NIP(new SpellCastExecution() {
        @Override
        public void execute(Pip pip) {
            pip.setAbleToOpenAnyItem(true);
        }
    }, SpellFightExecution.nothing(), new SpellChapterEndExecution() {
        @Override
        public void execute(Pip pip) {
            pip.setAbleToOpenAnyItem(false);
        }
    }),

    INVISIBILITY(new SpellCastExecution() {
        @Override
        public void execute(Pip pip) {
            pip.setInvisible(true);
        }
    }, SpellFightExecution.nothing(), SpellChapterEndExecution.nothing(), DamagePoint.damage(15), false, 1),

    FIREBALL(SpellCastExecution.nothing(), SpellFightExecution.nothing(), SpellChapterEndExecution.nothing());

    @Getter
    private final SpellCastExecution castEffect;

    @Getter
    private final SpellFightExecution fightEffect;

    @Getter
    private final SpellChapterEndExecution onChapterEnd;

    @Getter
    private final DamagePoint damagePoints;

    @Getter
    private final boolean freelyUsable;

    @Getter
    private final int maxUsages;

    Spell(SpellCastExecution onCast, SpellFightExecution onNextAttack, SpellChapterEndExecution onChapterEnd) {
        this(onCast, onNextAttack, onChapterEnd, DamagePoint.damage(3), true, 3);
    }

    Spell(SpellCastExecution onCast) {
        this(onCast, SpellFightExecution.nothing(), SpellChapterEndExecution.nothing(), DamagePoint.damage(3), true, 3);
    }
}
