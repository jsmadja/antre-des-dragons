package fr.jsmadja.antredesdragons.fight;

import fr.jsmadja.antredesdragons.entities.Entity;
import fr.jsmadja.antredesdragons.entities.Foe;
import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.ui.Events;

import java.util.ArrayList;
import java.util.List;

import static fr.jsmadja.antredesdragons.fight.Attack.Status.TOUCHED;
import static fr.jsmadja.antredesdragons.ui.Events.fightEvent;
import static fr.jsmadja.antredesdragons.ui.Events.statusEvent;
import static java.text.MessageFormat.format;
import static java.util.stream.Collectors.toList;

public class Fight {
    private final Pip pip;
    private final Foes foes;
    private int minimumFoesToKillCount = Integer.MAX_VALUE;
    private int turn = 1;
    private int maxTurns = Integer.MAX_VALUE;

    public Fight(Pip pip, List<Foe> foes) {
        this.pip = pip;
        this.foes = new Foes(foes, pip);
        this.foes.getFriendlyFoes().forEach(foe -> fightEvent(String.format("%s a une réaction amicale", foe.getName())));
    }

    public Fight(Pip pip, int maxTurn, List<Foe> foes) {
        this(pip, foes);
        this.maxTurns = maxTurn;
    }

    public Fight(Pip pip, Foe foe) {
        this(pip, List.of(foe));
    }

    public Fight(Pip pip, Foe foe, int maxTurns) {
        this(pip, maxTurns, List.of(foe));
    }

    public Fight(Pip pip, List<Foe> foes, int mininumDeadFoes) {
        this(pip, foes);
        this.minimumFoesToKillCount = mininumDeadFoes;
    }

    private void showTurn() {
        Events.event("\n");
        fightEvent(format("Tour no {0}", this.turn));
    }

    public void start() {
        List<Entity> opponents = getOrderedOpponents();
        while (!this.isOver()) {
            showTurn();
            opponents.stream().filter(Entity::isAbleToFight).forEach(attacker -> {
                attack(attacker);
                if (attacker.isAbleToStrikeTwice()) {
                    attack(attacker);
                }
            });
            opponents.forEach(p -> Events.statusEvent(p.toString()));
            this.endTurn();
        }
        if (this.isMaxTurnReached()) {
            pip.kill();
        }
        this.endFight();
    }

    private void attack(Entity attacker) {
        Entity target = this.getTarget(attacker);
        attacker.getSpecialSkills().forEach(specialSkill -> specialSkill.onAttack(attacker, target));
        if (!target.isDead()) {
            if (attacker.isPip()) {
                Pip pip = (Pip) attacker;
                attacker.getSpellsToCastDuringFight()
                        .forEach(spell -> {
                            spell.getSpell().onAttack(pip, target);
                        });
            }
            this.attackPhysically(attacker, target);
            if (attacker.getMagicDamagePoints().getValue() > 0) {
                this.attackMagically(attacker, target);
            }
        }
    }

    private void endFight() {
        getOrderedOpponents().forEach(Entity::removeTemporaryBonusAndMalus);
    }

    private void attackMagically(Entity attacker, Entity target) {
        Attack attack = attacker.createMagicAttack(target);
        attack(attacker, target, attack);
    }

    private void attackPhysically(Entity attacker, Entity target) {
        Attack attack = attacker.createPhysicAttack(target);
        attack(attacker, target, attack);
    }

    private void attack(Entity attacker, Entity target, Attack attack) {
        if (attack.getStatus() == TOUCHED) {
            attacker.setStrikesInARow(attacker.getStrikesInARow() + 1);
            int damagePoints = attack.getDamagePoints();
            fightEvent(format("{0} fait {1} points de dégâts à {2}", attacker.getName(), damagePoints, target.getName()));
            if (attacker.hasPoisonedWeapon()) {
                fightEvent(format("{0} est empoisonné", target.getName()));
                target.setPoisoned(true);
            }
            target.wounds(damagePoints);
            if (target.isDead()) {
                fightEvent(format("{0} est mort", target.getName()));
            }
            if (target.isFoe() && target.isStuned()) {
                fightEvent(format("{0} est étourdi", target.getName()));
            }
        } else {
            fightEvent(format("{0} rate son attaque vers {1}", attacker.getName(), target.getName()));
        }
        statusEvent(target.toString());
    }

    private boolean isMaxTurnReached() {
        return this.turn > this.maxTurns;
    }

    private void endTurn() {
        getOrderedOpponents().forEach(Entity::removeAllMagicEffects);
        this.turn++;
    }

    public List<Entity> getOrderedOpponents() {
        List<Entity> opponents = new ArrayList<>();
        opponents.add(pip);
        opponents.addAll(foes.getUnfriendlyFoes());
        return opponents.stream()
                .map(FightOrder.Entity2DiceRoll::new)
                .sorted(new FightOrder())
                .map(FightOrder.Entity2DiceRoll::getEntity)
                .collect(toList());
    }

    private Entity getTarget(Entity entity) {
        if (entity.isFoe()) {
            return this.pip;
        }
        return this.foes.getUnfriendlyFoes().get(0);
    }

    private boolean isOver() {
        if (isMaxTurnReached()) {
            return true;
        }
        if (pip.isDead()) {
            return true;
        }
        return this.foes.areAllUnableToFight() || this.foes.getUnableToFightCount() >= getMinimumFoesToKillCount();
    }

    private int getMinimumFoesToKillCount() {
        return minimumFoesToKillCount - this.foes.getFriendlyCount();
    }
}
