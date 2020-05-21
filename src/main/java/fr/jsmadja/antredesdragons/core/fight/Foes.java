package fr.jsmadja.antredesdragons.core.fight;

import fr.jsmadja.antredesdragons.core.dices.Roll;
import fr.jsmadja.antredesdragons.core.entities.Foe;
import fr.jsmadja.antredesdragons.core.entities.Pip;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Getter
public class Foes {
    private final List<Foe> unfriendlyFoes;
    private final List<Foe> friendlyFoes;

    public Foes(List<Foe> foes, Pip pip) {
        pip.log("lance les dés pour savoir connaître les réactions amicales");
        Roll pipRoll = pip.roll3Dices();
        this.unfriendlyFoes = foes.stream()
                .filter(f -> {
                    f.log("lance les dés pour savoir s'il a une réaction amicale envers Pip");
                    return pipRoll.isGreaterThan(f.roll1Dice());
                })
                .collect(toList());
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
