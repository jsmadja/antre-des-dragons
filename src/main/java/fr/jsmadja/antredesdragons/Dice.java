package fr.jsmadja.antredesdragons;

import java.util.Random;
import java.util.stream.IntStream;

class Dice {
    private Random random = new Random();

    int roll() {
        return random.nextInt(6) + 1;
    }

    int roll(int count) {
        return IntStream.range(0, count).map(i -> this.roll()).sum();
    }
}
