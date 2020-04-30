package fr.jsmadja.antredesdragons.pages.types;

import fr.jsmadja.antredesdragons.entities.Foe;
import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.pages.content.PageNumber;

public abstract class FightPage extends Page {
    @Override
    public Execution execute(Pip pip) {
        pip.fight(getFoe());
        if(pip.isDead()) {
            return pip.goToPage(PageNumber.of(14));
        }
        return pip.goToPage(PageNumber.of(getSuccessPage()));
    }

    protected abstract int getSuccessPage();

    protected abstract Foe getFoe();

}
