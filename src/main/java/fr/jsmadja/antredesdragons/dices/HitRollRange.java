package fr.jsmadja.antredesdragons.dices;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class HitRollRange {
    private final int min;
    private final int max;

    public HitRollRange(int exact) {
        this.min = exact;
        this.max = exact;
    }

    public boolean contains(int roll) {
        return min <= roll && roll <= max;
    }
}
