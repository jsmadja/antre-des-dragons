package fr.jsmadja.antredesdragons.spellcasting;

import fr.jsmadja.antredesdragons.entities.Entity;
import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.stuff.DamagePoint;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Spell {

    @Getter
    private final DamagePoint damagePoints;

    @Getter
    private final boolean freelyUsable;

    @Getter
    private final int maxUsages;

    Spell() {
        this.freelyUsable = true;
        this.maxUsages = 3;
        this.damagePoints = DamagePoint.damage(3);
    }

    public void onCast(Pip pip) {
    }

    public void onAttack(Pip pip, Entity target) {
    }

    public void onChapterEnd(Pip pip) {

    }

}