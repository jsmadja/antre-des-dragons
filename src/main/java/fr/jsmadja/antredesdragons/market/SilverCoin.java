package fr.jsmadja.antredesdragons.market;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static java.text.MessageFormat.format;

@Getter
@RequiredArgsConstructor(staticName = "of")
public class SilverCoin {
    private final double value;

    @Override
    public String toString() {
        return format("{0} pa", value);
    }
}
