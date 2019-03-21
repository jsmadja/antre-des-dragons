package fr.jsmadja.antredesdragons;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

class Battle {
    private List<Entity> opponents = new ArrayList<>();
    private List<Entity> opponentsOrderedByFirstRollDesc;

    void addOpponent(Entity entity) {
        this.opponents.add(entity);
        this.opponentsOrderedByFirstRollDesc = opponents.stream()
                .map(Entity2DieRoll::new)
                .sorted(byRollDesc)
                .map(Entity2DieRoll::getEntity)
                .collect(toList());
    }

    private Comparator<Entity2DieRoll> byRollDesc = (Entity2DieRoll entity1, Entity2DieRoll entity2) -> entity2.getRoll() - entity1.getRoll();

    Entity getNextAttacker() {
        return this.opponentsOrderedByFirstRollDesc.get(0);
    }

    List<Entity> getTargets() {
        return this.opponentsOrderedByFirstRollDesc.stream().filter(entity -> !entity.equals(getNextAttacker())).collect(toList());
    }

    void attack(Entity attacker, Entity target) {
        Attack attack = attacker.attacks();
        if (attack.getStatus() == Attack.Status.TOUCHED) {
            target.wounds(attack.getDamagePoints());
        }
        this.opponentsOrderedByFirstRollDesc.remove(0);
        this.opponentsOrderedByFirstRollDesc.add(attacker);
        if (target.isDead()) {
            this.opponentsOrderedByFirstRollDesc.remove(target);
        }
    }

    boolean isOver() {
        return this.opponentsOrderedByFirstRollDesc.size() <= 1 || this.foesAreStuned();
    }

    private boolean foesAreStuned() {
        return this.getFoes().stream().allMatch(Entity::isStuned);
    }

    private List<Entity> getFoes() {
        return this.opponentsOrderedByFirstRollDesc.stream().filter(Entity::isFoe).collect(toList());
    }
}
