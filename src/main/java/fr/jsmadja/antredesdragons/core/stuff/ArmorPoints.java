package fr.jsmadja.antredesdragons.core.stuff;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ArmorPoints {
    private final int armorPoints;

    public static ArmorPoints armor(int armorPoints) {
        return new ArmorPoints(armorPoints);
    }
}
