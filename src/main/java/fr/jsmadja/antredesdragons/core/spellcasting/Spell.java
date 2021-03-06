package fr.jsmadja.antredesdragons.core.spellcasting;

import fr.jsmadja.antredesdragons.core.entities.Entity;
import fr.jsmadja.antredesdragons.core.entities.Pip;
import fr.jsmadja.antredesdragons.core.stuff.DamagePoints;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Spell {

    @Getter
    private final DamagePoints damagePoints;

    @Getter
    private final boolean freelyUsable;

    @Getter
    private final int maxUsages;

    Spell() {
        this.freelyUsable = true;
        this.maxUsages = 3;
        this.damagePoints = DamagePoints.damage(3);
    }

    public void onCast(Pip pip) {
    }

    public void onAttack(Pip pip, Entity target) {
    }

    public void onChapterEnd(Pip pip) {

    }

}
