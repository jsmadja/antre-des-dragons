package fr.jsmadja.antredesdragons.market;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static java.text.MessageFormat.format;

@Getter
@RequiredArgsConstructor(staticName = "of")
public class GoldenCoins {
    private final double value;

    public static final int GOLDEN_SILVER_COIN = 10;

    public SilverCoins toSilverCoins() {
        return SilverCoins.of(value * GOLDEN_SILVER_COIN);
    }

    @Override
    public String toString() {
        return format("{0} po", value);
    }
}
