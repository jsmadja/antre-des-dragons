package fr.jsmadja.antredesdragons.entities;

import fr.jsmadja.antredesdragons.stuff.ArmorPoint;
import fr.jsmadja.antredesdragons.stuff.DamagePoint;
import lombok.Getter;

import java.util.function.Function;

public enum Spell {
    AEP(pip -> {
        pip.addMagicalArmorPoints(ArmorPoint.armor(4));
        return pip;
    }),
    INVISIBILITY(Function.identity()),
    HEP(pip -> {
        pip.addMagicDamagePoints(DamagePoint.damage(10));
        return pip;
    });

    @Getter
    private Function<Pip, Pip> effect;

    Spell(Function<Pip, Pip> effect) {
        this.effect = effect;
    }
}
