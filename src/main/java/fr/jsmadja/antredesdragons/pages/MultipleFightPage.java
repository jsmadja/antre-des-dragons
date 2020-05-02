package fr.jsmadja.antredesdragons.pages;

import fr.jsmadja.antredesdragons.ui.Events;
import fr.jsmadja.antredesdragons.entities.Foe;
import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.book.PageNumber;

import java.util.List;

public abstract class MultipleFightPage extends Page {
    @Override
    public Execution execute(Pip pip) {
        onBeforeFight(pip);
        pip.fight(getFoes());
        Events.statusEvent(pip.toString());
        if(pip.isDead()) {
            return pip.goToPage(PageNumber.page(14));
        }
        onAfterSuccessfulFight(pip);
        return pip.goToPage(PageNumber.page(getSuccessPage()));
    }

    protected void onBeforeFight(Pip pip) {
    }

    protected void onAfterSuccessfulFight(Pip pip) {
    }

    protected abstract int getSuccessPage();

    protected abstract List<Foe> getFoes();

}