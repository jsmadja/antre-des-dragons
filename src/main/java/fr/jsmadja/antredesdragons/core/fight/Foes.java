package fr.jsmadja.antredesdragons.core.fight;

import fr.jsmadja.antredesdragons.core.dices.Roll;
import fr.jsmadja.antredesdragons.core.entities.Foe;
import fr.jsmadja.antredesdragons.core.entities.Pip;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class Foes {
    private List<Foe> unfriendlyFoes;
    private List<Foe> friendlyFoes;

    public Foes(List<Foe> foes, Pip pip) {
        Roll pipRoll = pip.roll3Dices();
        this.unfriendlyFoes = foes.stream()
                .filter(f -> pipRoll.isGreaterThan(f.roll1Dice()))
                .collect(Collectors.toList());
        this.friendlyFoes = new ArrayList<>(foes);
        this.friendlyFoes.removeAll(this.unfriendlyFoes);
    }

    public int getSize() {
        return this.friendlyFoes.size() + this.unfriendlyFoes.size();
    }

    public long getUnableToFightCount() {
        return this.unfriendlyFoes
                .stream().filter(foe -> foe.isStuned() || foe.isDead())
                .count();
    }

    public boolean areAllUnableToFight() {
        return this.getUnableToFightCount() == this.getUnfriendlyFoes().size();
    }

    public int getFriendlyCount() {
        return this.friendlyFoes.size();
    }
}
