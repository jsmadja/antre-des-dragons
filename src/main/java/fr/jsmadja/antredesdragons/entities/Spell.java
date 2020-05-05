package fr.jsmadja.antredesdragons.entities;

import fr.jsmadja.antredesdragons.stuff.ArmorPoint;
import fr.jsmadja.antredesdragons.stuff.DamagePoint;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.function.Function;

@AllArgsConstructor
public enum Spell {
    AEP(pip -> {
        pip.addMagicalArmorPoints(ArmorPoint.armor(4));
        return pip;
    }),
    INVISIBILITY(pip -> {
        pip.setInvisible(true);
        return pip;
    }, DamagePoint.damage(15), false, 1),
    HEP(pip -> {
        pip.addMagicDamagePoints(DamagePoint.damage(10));
        return pip;
    }),
    FIP(Function.identity()),
    FIREBALL(Function.identity());

    @Getter
    private final Function<Pip, Pip> effect;

    @Getter
    private final DamagePoint damagePoints;

    @Getter
    private final boolean freelyUsable;

    @Getter
    private final int maxUsages;

    Spell(Function<Pip, Pip> effect) {
        this(effect, DamagePoint.damage(3), true, 3);
    }

}
