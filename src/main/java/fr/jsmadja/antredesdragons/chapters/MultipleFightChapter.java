package fr.jsmadja.antredesdragons.chapters;

import fr.jsmadja.antredesdragons.entities.Foe;
import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.ui.Events;

import java.util.List;

public abstract class MultipleFightChapter extends Chapter {
    @Override
    public Execution execute(Pip pip) {
        onBeforeFight(pip);
        pip.fight(getFoes(pip), getRequiredDeadFoes(pip));
        Events.statusEvent(pip.toString());
        if (pip.isDead()) {
            return pip.goTo(ChapterNumber.chapter(14));
        }
        onAfterSuccessfulFight(pip);
        return pip.goTo(ChapterNumber.chapter(getSuccessChapter()));
    }

    protected void onBeforeFight(Pip pip) {
    }

    protected void onAfterSuccessfulFight(Pip pip) {
    }

    protected abstract int getSuccessChapter();

    protected abstract List<Foe> getFoes(Pip pip);

    public int getRequiredDeadFoes(Pip pip) {
        return this.getFoes(pip).size();
    }
}
