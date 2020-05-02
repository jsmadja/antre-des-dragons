package fr.jsmadja.antredesdragons.pages;

import fr.jsmadja.antredesdragons.entities.Pip;

import java.util.List;

public abstract class RollAndGoPage extends Page {

    @Override
    public Execution execute(Pip pip) {
        return pip.rollAndGo(getDiceWays());
    }

    protected abstract List<DiceWay> getDiceWays();

}
