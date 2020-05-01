package fr.jsmadja.antredesdragons.dices;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class HitRollRange {
    private final int min;
    private final int max;

    public HitRollRange(int min) {
        this.min = min;
        this.max = 12;
    }

    public boolean contains(int roll) {
        return min <= roll && roll <= max;
    }
}
