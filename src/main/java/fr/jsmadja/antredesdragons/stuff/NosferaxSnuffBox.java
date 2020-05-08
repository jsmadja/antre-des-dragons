package fr.jsmadja.antredesdragons.stuff;

import fr.jsmadja.antredesdragons.entities.Pip;
import lombok.AllArgsConstructor;

import static fr.jsmadja.antredesdragons.stuff.HealthPoints.hp;

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
    public String toString() {
        return "Tabatière de Nosferax";
    }
}
