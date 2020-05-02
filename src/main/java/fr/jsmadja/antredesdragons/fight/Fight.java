package fr.jsmadja.antredesdragons.fight;

import fr.jsmadja.antredesdragons.dices.Roll;
import fr.jsmadja.antredesdragons.entities.Entity;
import fr.jsmadja.antredesdragons.entities.Foe;
import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.ui.Events;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static fr.jsmadja.antredesdragons.ui.Events.fightEvent;
import static fr.jsmadja.antredesdragons.ui.Events.statusEvent;
import static java.text.MessageFormat.format;
import static java.util.stream.Collectors.toList;

public class Fight {
    private final Pip pip;
    private Foe foe;
    private List<Foe> foes;
    private Entity firstAttacker;
    private int turn = 1;
    private int maxTurns = Integer.MAX_VALUE;

    public Fight(Pip pip, Foe foe) {
        this.pip = pip;
        this.foe = foe;
    }

    public Fight(Pip pip, List<Foe> foes) {
        this.pip = pip;
        this.foes = foes;
    }

    public Fight(Pip pip, Foe foe, int maxTurns) {
        this.pip = pip;
        this.foe = foe;
        this.maxTurns = maxTurns;
    }

    public void start() {
        if (this.foe != null) {
            singleFight();
        } else {
            multipleFight();
        }
    }

    private void multipleFight() {
        List<Entity> opponents = new ArrayList<>();
        opponents.add(pip);
        opponents.addAll(foes);
        if (this.firstAttacker != null && this.firstAttacker != pip) {
            opponents = opponents.stream()
                    .map(FightOrder.Entity2DiceRoll::new)
                    .sorted(new FightOrder())
                    .map(FightOrder.Entity2DiceRoll::getEntity)
                    .collect(toList());
        }

        while (!this.isOver()) {
            showTurn();
            opponents.stream().filter(Entity::canFight).forEach(attacker -> {
                Entity other = this.getFromOthers(attacker);
                if (!other.isDead()) {
                    this.attack(attacker, other);
                }
                Events.statusEvent(attacker.toString());
            });
            this.turn++;
        }

        if (this.isMaxTurnReached()) {
            pip.kill();
        }
    }

    private void showTurn() {
        Events.event("\n");
        fightEvent(format("Tour no {0}", this.turn));
    }

    private void singleFight() {
        List<Entity> opponents = getOrderedOpponents();

        while (!this.isOver()) {
            showTurn();
            opponents.forEach(attacker -> {
                Entity other = this.getOther(attacker);
                if (!other.isDead()) {
                    this.attack(attacker, other);
                }
            });
            Events.statusEvent(pip.toString());
            Events.statusEvent(foe.toString());
            this.turn++;
        }
        if (this.isMaxTurnReached()) {
            pip.kill();
        }
    }

    private List<Entity> getOrderedOpponents() {
        List<Entity> opponents = new ArrayList<>();
        if (firstAttacker == null) {
            Roll pipOrderRoll = this.pip.roll2Dices();
            Roll foeOrderRoll = this.foe.roll2Dices();
            if (!this.pip.isLoseInitiative() && pipOrderRoll.isGreaterThan(foeOrderRoll)) {
                opponents.add(pip);
                opponents.add(foe);
            } else {
                opponents.add(foe);
                opponents.add(pip);
            }
        } else {
            opponents.add(firstAttacker);
            opponents.add(this.getOther(firstAttacker));
        }
        return opponents;
    }

    private Entity getOther(Entity entity) {
        if (entity == this.foe) {
            return this.pip;
        }
        return this.foe;
    }

    private Entity getFromOthers(Entity entity) {
        if (entity.isFoe()) {
            return this.pip;
        }
        return this.foes.get(0);
    }

    private void attack(Entity attacker, Entity target) {
        // fightEvent(format("{0} attaque {1}", attacker.getName(), target.getName()));
        PhysicalAttack physicalAttack = attacker.attacks(target);
        if (physicalAttack.getStatus() == PhysicalAttack.Status.TOUCHED) {
            int damagePoints = physicalAttack.getDamagePoints();
            fightEvent(format("{0} fait {1} points de dégâts à {2}", attacker.getName(), damagePoints, target.getName()));
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

    private boolean isOver() {
        if (isMaxTurnReached()) {
            return true;
        }
        if (this.pip.isDead()) {
            return true;
        }
        if (this.foe != null) {
            return this.foe.isDead() || this.foe.isStuned();
        }
        return this.foes.stream().allMatch(foe -> foe.isStuned() || foe.isDead());
    }

    private boolean isMaxTurnReached() {
        return this.turn > this.maxTurns;
    }

    public void setFirstAttacker(Entity firstAttacker) {
        this.firstAttacker = firstAttacker;
    }

    public Entity getFirstAttacker() {
        return firstAttacker;
    }
}
