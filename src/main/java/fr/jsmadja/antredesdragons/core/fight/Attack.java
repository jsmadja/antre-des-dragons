package fr.jsmadja.antredesdragons.core.fight;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static java.text.MessageFormat.format;

@AllArgsConstructor
@Getter
public class Attack {
    private final int damagePoints;
    private final Status status;

    public enum Status {
        TOUCHED, MISSED
    }

    @Override
    public String toString() {
        return format("{0} {1} DMG", status, damagePoints);
    }
}
