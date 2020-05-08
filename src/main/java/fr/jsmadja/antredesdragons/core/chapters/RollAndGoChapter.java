package fr.jsmadja.antredesdragons.core.chapters;

import fr.jsmadja.antredesdragons.core.entities.Pip;

import java.util.List;

public abstract class RollAndGoChapter extends Chapter {

    @Override
    public Execution execute(Pip pip) {
        return pip.rollAndGo(getDiceWays(pip));
    }

    protected abstract List<DiceWay> getDiceWays(Pip pip);

}
