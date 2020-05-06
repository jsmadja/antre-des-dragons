package fr.jsmadja.antredesdragons.stuff;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DamagePoint {
    private final int value;

    public static DamagePoint damage(int value) {
        return new DamagePoint(value);
    }
}
