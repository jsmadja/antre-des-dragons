package fr.jsmadja.antredesdragons.core.inventory;

import fr.jsmadja.antredesdragons.core.dices.Dice;
import fr.jsmadja.antredesdragons.core.entities.Entity;
import fr.jsmadja.antredesdragons.core.stuff.HealthPoints;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class HealingPotion extends HealingItem {

    @Getter
    private final List<HealthPoints> doses;

    public HealingPotion(Dice dice) {
        super("Potion Curative");
        this.doses = IntStream
                .range(0, 6)
                .mapToObj(i -> dice.roll(2).toHealthPoints()).collect(toList());
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
