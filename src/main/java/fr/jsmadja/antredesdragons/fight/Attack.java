package fr.jsmadja.antredesdragons.fight;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Attack {
    private final int damagePoints;
    private final Status status;

    public enum Status {
        TOUCHED, MISSED
    }
}
