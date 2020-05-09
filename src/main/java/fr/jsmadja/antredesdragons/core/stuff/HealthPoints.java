package fr.jsmadja.antredesdragons.core.stuff;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static java.text.MessageFormat.format;

@EqualsAndHashCode
@RequiredArgsConstructor
public class HealthPoints {
    @Getter
    private final int healthPoints;

    public static HealthPoints hp(int healthPoints) {
        return new HealthPoints(healthPoints);
    }

    @Override
    public String toString() {
        return format("{0} HP", this.healthPoints);
    }
}
