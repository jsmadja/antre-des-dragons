package fr.jsmadja.antredesdragons.stuff;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ArmorPoint {
    private final int value;

    public static ArmorPoint armor(int value) {
        return new ArmorPoint(value);
    }
}
