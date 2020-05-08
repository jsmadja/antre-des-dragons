package fr.jsmadja.antredesdragons.stuff;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static java.text.MessageFormat.format;

@EqualsAndHashCode
@RequiredArgsConstructor
public class HealthPoints {
    @Getter
    private final int value;

    public static HealthPoints hp(int value) {
        return new HealthPoints(value);
    }

    @Override
    public String toString() {
        return format("{0} HP", this.value);
    }
}
