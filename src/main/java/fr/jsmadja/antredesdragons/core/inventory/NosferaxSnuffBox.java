package fr.jsmadja.antredesdragons.core.inventory;

import fr.jsmadja.antredesdragons.core.entities.Entity;
import fr.jsmadja.antredesdragons.core.entities.Pip;
import fr.jsmadja.antredesdragons.core.stuff.HealthPoints;

import static fr.jsmadja.antredesdragons.core.stuff.HealthPoints.hp;

public class NosferaxSnuffBox extends HealingItem {
    private final Pip pip;

    public NosferaxSnuffBox(Pip pip) {
        super("Tabatière de Nosferax");
        this.pip = pip;
    }

    @Override
    public boolean isUsable() {
        return true;
    }

    @Override
    public HealthPoints use() {
        if (pip.isNosferaxSnuffBoxUsed()) {
            pip.die();
        }
        pip.setNosferaxSnuffBoxUsed(true);
        return hp(pip.roll4Dices().getValue());
    }

    @Override
    public HealthPoints useDuringFight(Entity attacker, Entity target) {
        return this.use();
    }

    @Override
    public String toString() {
        return "Tabatière de Nosferax";
    }
}
