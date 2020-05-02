package fr.jsmadja.antredesdragons.market;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static java.text.MessageFormat.format;

@Getter
@RequiredArgsConstructor(staticName = "of")
public class Quantity {
    private final int value;

    @Override
    public String toString() {
        return format("x{0}", value);
    }
}
