package fr.jsmadja.antredesdragons.stuff;

import fr.jsmadja.antredesdragons.dices.HitRollRange;

public class Armory {
    public static Sword getExcaliburJunior() {
        return new Sword(new HitRollRange(4, 12), 5);
    }
}
