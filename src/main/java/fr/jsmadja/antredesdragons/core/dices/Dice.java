package fr.jsmadja.antredesdragons.core.dices;

import java.util.Random;
import java.util.stream.IntStream;

public class Dice {
    private final Random random = new Random();

    public int roll() {
        return random.nextInt(6) + 1;
    }

    public Roll roll(int count) {
        return Roll.roll(IntStream.range(0, count).map(i -> this.roll()).sum());
    }
}
