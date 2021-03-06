package fr.jsmadja.antredesdragons.core.fight;

import fr.jsmadja.antredesdragons.core.entities.Entity;
import fr.jsmadja.antredesdragons.core.entities.Foe;
import fr.jsmadja.antredesdragons.core.entities.Pip;

import java.util.ArrayList;
import java.util.List;

import static fr.jsmadja.antredesdragons.core.fight.Attack.Status.TOUCHED;
import static fr.jsmadja.antredesdragons.core.stuff.HealthPoints.hp;
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
        this.foes.getFriendlyFoes().forEach(foe -> foe.logFight(String.format("%s a une réaction amicale", foe.getName())));
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

    public void start() {
        beforeFight();
        List<Entity> opponents = createOrderedOpponents();
        while (!this.isOver()) {
            doTurn(opponents);
        }
        if (this.isMaxTurnReached()) {
            pip.die();
        }
        this.endFight();
    }

    public void doTurn(List<Entity> opponents) {
        opponents.stream().filter(Entity::isAbleToFight).forEach(attacker -> {
            if (attacker.isAbleToFight()) {
                attacker.autoHealIfNecessary();
                attack(attacker);
                if (attacker.isAbleToStrikeTwice()) {
                    attack(attacker);
                }
            }
        });
        this.endTurn();
    }

    private void beforeFight() {
        this.foes.getUnfriendlyFoes().forEach(o -> {
            o.resetStrikes();
            o.setLostHealthPointsDuringCurrentFight(hp(0));
        });
    }

    private void attack(Entity attacker) {
        Entity target = this.getTarget(attacker);
        attacker.getSpecialSkills()
                .forEach(specialSkill -> specialSkill.onAttack(attacker, target));
        if (!attacker.isDead() && !target.isDead()) {
            if (attacker.isPip()) {
                Pip pip = (Pip) attacker;
                attacker.getSpellsToCastDuringFight()
                        .forEach(spell -> spell.getSpell().onAttack(pip, target));
            }
            this.attackPhysically(attacker, target);
            if (attacker.getMagicDamagePoints().getDamagePoints() > 0) {
                this.attackMagically(attacker, target);
            }
            target.autoHealIfNecessary();
        }
    }

    private void endFight() {
        this.foes.getUnfriendlyFoes().forEach(Entity::removeTemporaryBonusAndMalus);
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
            attacker.logFight(format("{0} fait {1} points de dégâts à {2}", attacker.getName(), damagePoints, target.getName()));
            if (attacker.hasPoisonedWeapon()) {
                target.logFight(format("{0} est empoisonné", target.getName()));
                target.setPoisoned(true);
            }
            target.wounds(damagePoints);
            if (target.isDead()) {
                target.logFight(format("{0} est mort", target.getName()));
            }
            if (target.isFoe() && target.isStuned()) {
                target.logFight(format("{0} est étourdi", target.getName()));
            }
            if (!target.isAbleToFight()) {
                this.foes.removeUnfriendlyFoe(target);
            }
        } else {
            attacker.logFight(format("{0} rate son attaque vers {1}", attacker.getName(), target.getName()));
        }
        attacker.incrementStrikes();
    }

    private boolean isMaxTurnReached() {
        return this.turn > this.maxTurns;
    }

    private void endTurn() {
        this.foes.getUnfriendlyFoes().forEach(Entity::removeAllMagicEffects);
        this.turn++;
    }

    private List<Entity> createOrderedOpponents() {
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
