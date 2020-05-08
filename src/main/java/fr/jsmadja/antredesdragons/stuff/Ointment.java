package fr.jsmadja.antredesdragons.stuff;

import lombok.Getter;

import static fr.jsmadja.antredesdragons.stuff.HealthPoints.hp;

public class Ointment extends HealingItem {

    @Getter
    private boolean usable = true;

    @Override
    public HealthPoints use() {
        this.usable = false;
        return hp(5);
    }

    @Override
    public String toString() {
        return "Onguent (5 HP)";
    }

}
