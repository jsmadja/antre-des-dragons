package fr.jsmadja.antredesdragons.fight;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PhysicalAttack {
    private final int damagePoints;
    private final Status status;

    public enum Status {
        TOUCHED, MISSED
    }
}
