package fr.jsmadja.antredesdragons.chapters;

import fr.jsmadja.antredesdragons.entities.Pip;

import java.util.List;

public abstract class RollAndGoChapter extends Chapter {

    @Override
    public Execution execute(Pip pip) {
        return pip.rollAndGo(getDiceWays(pip));
    }

    protected abstract List<DiceWay> getDiceWays(Pip pip);

}
