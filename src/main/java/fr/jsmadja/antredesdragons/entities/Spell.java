package fr.jsmadja.antredesdragons.entities;

import fr.jsmadja.antredesdragons.stuff.ArmorPoint;
import fr.jsmadja.antredesdragons.stuff.DamagePoint;
import lombok.AllArgsConstructor;
import lombok.Getter;

import static fr.jsmadja.antredesdragons.entities.SpellFightExecution.nothing;

@AllArgsConstructor
public enum Spell {

    AEP(new SpellCastExecution() {
        @Override
        public void execute(Pip pip) {
            pip.addMagicalArmorPoints(ArmorPoint.armor(4));
        }
    }, nothing()),

    INVISIBILITY(new SpellCastExecution() {
        @Override
        public void execute(Pip pip) {
            pip.setInvisible(true);
        }
    }, nothing(), DamagePoint.damage(15), false, 1),

    HEP(new SpellCastExecution() {
        @Override
        public void execute(Pip pip) {
            pip.addMagicDamagePoints(DamagePoint.damage(10));
        }
    }, nothing()),

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
    }),

    FIREBALL(SpellCastExecution.nothing(), nothing()),

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
    });

    @Getter
    private final SpellCastExecution castEffect;

    @Getter
    private final SpellFightExecution fightEffect;

    @Getter
    private final DamagePoint damagePoints;

    @Getter
    private final boolean freelyUsable;

    @Getter
    private final int maxUsages;

    Spell(SpellCastExecution onCast, SpellFightExecution onNextAttack) {
        this(onCast, onNextAttack, DamagePoint.damage(3), true, 3);
    }
}
