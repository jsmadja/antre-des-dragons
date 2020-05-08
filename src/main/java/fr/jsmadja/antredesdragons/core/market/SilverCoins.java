package fr.jsmadja.antredesdragons.core.market;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static java.text.MessageFormat.format;

@Getter
@RequiredArgsConstructor(staticName = "of")
public class SilverCoins {
    private final double value;

    @Override
    public String toString() {
        return format("{0} pa", value);
    }

    public SilverCoins plus(SilverCoins silverCoins) {
        return SilverCoins.of(this.value + silverCoins.value);
    }

    public SilverCoins minus(SilverCoins silverCoins) {
        return SilverCoins.of(this.value - silverCoins.value);
    }
}
