package fr.jsmadja.antredesdragons.spellcasting;

import java.util.HashMap;
import java.util.Map;

public class SpellUsages {
    private Map<SpellBook, Integer> usages = new HashMap<>();

    public void increment(SpellBook spell) {
        this.usages.put(spell, getUsagesOf(spell) + 1);
    }

    public int getUsagesOf(SpellBook spell) {
        Integer usages = this.usages.get(spell);
        return usages == null ? 0 : usages;
    }
}
