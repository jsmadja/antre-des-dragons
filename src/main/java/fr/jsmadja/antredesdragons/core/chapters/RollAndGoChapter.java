package fr.jsmadja.antredesdragons.core.chapters;

import fr.jsmadja.antredesdragons.core.entities.Pip;
import fr.jsmadja.antredesdragons.core.execution.Execution;

import java.util.List;

public abstract class RollAndGoChapter extends Chapter {

    protected abstract List<DiceWay> getDiceWays(Pip pip);

    @Override
    public Execution execute(Pip pip) {
        return pip.rollAndGo2(getDiceWays(pip));
    }
}
