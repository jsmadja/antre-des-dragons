package fr.jsmadja.antredesdragons.core.stuff;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DamagePoints {
    private final int damagePoints;

    public static DamagePoints damage(int damagePoint) {
        return new DamagePoints(damagePoint);
    }
}
