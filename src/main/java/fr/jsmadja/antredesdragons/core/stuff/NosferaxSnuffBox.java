package fr.jsmadja.antredesdragons.core.stuff;

import fr.jsmadja.antredesdragons.core.entities.Entity;
import fr.jsmadja.antredesdragons.core.entities.Pip;
import lombok.AllArgsConstructor;

import static fr.jsmadja.antredesdragons.core.stuff.HealthPoints.hp;

@AllArgsConstructor
public class NosferaxSnuffBox extends HealingItem {
    private final Pip pip;

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
