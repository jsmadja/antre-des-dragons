package fr.jsmadja.antredesdragons.entities;

import fr.jsmadja.antredesdragons.stuff.ArmorPoint;
import fr.jsmadja.antredesdragons.stuff.DamagePoint;
import fr.jsmadja.antredesdragons.stuff.Item;
import fr.jsmadja.antredesdragons.ui.Events;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.IntStream;

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
    }),

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
    },
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
    }, new SpellChapterEndExecution() {
        @Override
        public void execute(Pip pip) {
            pip.setAbleToOpenAnyItem(false);
        }
    }),

    MEP(new SpellCastExecution() {
        @Override
        public void execute(Pip pip) {
            pip.setAbleToStrikeTwice(true);
        }
    }, new SpellChapterEndExecution() {
        @Override
        public void execute(Pip pip) {
            pip.setAbleToStrikeTwice(false);
        }
    }),
    INVISIBILITY(new SpellCastExecution() {
        @Override
        public void execute(Pip pip) {
            pip.setInvisible(true);
        }
    }, SpellFightExecution.nothing(),
            SpellFightEndExecution.nothing(),
            new SpellChapterEndExecution() {
                @Override
                public void execute(Pip pip) {
                    pip.setInvisible(false);
                }
            }, DamagePoint.damage(15), false, 1),

    FINGER_OF_FIRE(
            new SpellCastExecution() {
                @Override
                public void execute(Pip pip) {
                    IntStream.range(0, 10).forEach(i -> pip.add(Item.FINGER_OF_FIRE));
                }
            },
            new SpellFightExecution() {
                @Override
                public void execute(Pip pip, Entity target) {
                    if (pip.has(Item.FINGER_OF_FIRE)) {
                        target.wounds(10);
                        pip.remove(Item.FINGER_OF_FIRE);
                    }
                }
            },
            SpellFightEndExecution.nothing(),
            new SpellChapterEndExecution() {
                @Override
                public void execute(Pip pip) {
                    pip.removeAll(Item.FINGER_OF_FIRE);
                }
            },
            DamagePoint.damage(3),
            true,
            1),

    FIREBALL(
            new SpellCastExecution() {
                @Override
                public void execute(Pip pip) {
                    IntStream.range(0, 2).forEach(i -> pip.add(Item.FIREBALL));
                }
            },
            new SpellFightExecution() {
                @Override
                public void execute(Pip pip, Entity target) {
                    if (pip.has(Item.FIREBALL)) {
                        target.wounds(75);
                        pip.remove(Item.FIREBALL);
                    }
                }
            },
            SpellFightEndExecution.nothing(),
            SpellChapterEndExecution.nothing(),
            DamagePoint.damage(3),
            true,
            3);

    @Getter
    private final SpellCastExecution castEffect;

    @Getter
    private final SpellFightExecution fightEffect;

    @Getter
    private final SpellFightEndExecution onFightEnd;

    @Getter
    private final SpellChapterEndExecution onChapterEnd;

    @Getter
    private final DamagePoint damagePoints;

    @Getter
    private final boolean freelyUsable;

    @Getter
    private final int maxUsages;

    Spell(SpellCastExecution onCast, SpellFightExecution onNextAttack, SpellFightEndExecution onFightEnd, SpellChapterEndExecution onChapterEnd) {
        this(onCast, onNextAttack, onFightEnd, onChapterEnd, DamagePoint.damage(3), true, 3);
    }

    Spell(SpellCastExecution onCast) {
        this(onCast, SpellFightExecution.nothing(), SpellFightEndExecution.nothing(), SpellChapterEndExecution.nothing(), DamagePoint.damage(3), true, 3);
    }

    Spell(SpellCastExecution spellCastExecution, SpellFightExecution spellFightExecution) {
        this(spellCastExecution, spellFightExecution, SpellFightEndExecution.nothing(), SpellChapterEndExecution.nothing());
    }

    Spell(SpellCastExecution spellCastExecution, SpellChapterEndExecution spellChapterEndExecution) {
        this(spellCastExecution, SpellFightExecution.nothing(), SpellFightEndExecution.nothing(), spellChapterEndExecution);
    }
}
