package fr.jsmadja.antredesdragons.dices;

import java.util.Random;
import java.util.stream.IntStream;

public class Dice {
    private final Random random = new Random();

    public int roll() {
        return random.nextInt(6) + 1;
    }

    public int roll(int count) {
        return IntStream.range(0, count).map(i -> this.roll()).sum();
    }
}
