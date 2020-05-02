package fr.jsmadja.antredesdragons.dices;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(staticName = "of")
@Getter
public class Roll {
    private int value;
    public boolean isBetween(int minIncluded, int maxIncluded) {
        return minIncluded <= value && value <= maxIncluded;
    }

    public boolean isGreaterThan(Roll roll) {
        return this.value > roll.value;
    }
}
