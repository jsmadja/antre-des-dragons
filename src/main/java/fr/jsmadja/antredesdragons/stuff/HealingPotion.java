package fr.jsmadja.antredesdragons.stuff;

import fr.jsmadja.antredesdragons.dices.Dice;
import fr.jsmadja.antredesdragons.entities.Entity;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HealingPotion extends HealingItem {
    private final List<HealthPoints> doses;

    public HealingPotion(Dice dice) {
        this.doses = IntStream
                .range(0, 6)
                .mapToObj(i -> HealthPoints.hp(dice.roll(2))).collect(Collectors.toList());
    }

    @Override
    public boolean isUsable() {
        return !this.doses.isEmpty();
    }

    @Override
    public HealthPoints use() {
        if (isUsable()) {
            return this.doses.remove(0);
        }
        return HealthPoints.hp(0);
    }

    @Override
    public HealthPoints useDuringFight(Entity attacker, Entity target) {
        return this.use();
    }

    @Override
    public String toString() {
        return "Potion Curative de " + this.doses.size() + " doses (" + this.doses.stream().map(HealthPoints::toString).collect(Collectors.joining(", ")) + ")";
    }
}
