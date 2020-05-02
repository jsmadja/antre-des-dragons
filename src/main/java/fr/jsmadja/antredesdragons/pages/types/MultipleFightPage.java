package fr.jsmadja.antredesdragons.pages.types;

import fr.jsmadja.antredesdragons.ui.Events;
import fr.jsmadja.antredesdragons.entities.Foe;
import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.pages.content.PageNumber;

import java.util.List;

public abstract class MultipleFightPage extends Page {
    @Override
    public Execution execute(Pip pip) {
        pip.fight(getFoes(), true);
        Events.statusEvent(pip.toString());
        if(pip.isDead()) {
            return pip.goToPage(PageNumber.page(14));
        }
        return pip.goToPage(PageNumber.page(getSuccessPage()));
    }

    protected abstract int getSuccessPage();

    protected abstract List<Foe> getFoes();

}
