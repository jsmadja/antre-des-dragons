package fr.jsmadja.antredesdragons.entities;

import java.util.HashMap;
import java.util.Map;

public class SpellUsages {
    private Map<Spell, Integer> usages = new HashMap<>();

    public void increment(Spell spell) {
        this.usages.put(spell, getUsagesOf(spell) + 1);
    }

    public int getUsagesOf(Spell spell) {
        Integer usages = this.usages.get(spell);
        return usages == null ? 0 : usages;
    }
}
