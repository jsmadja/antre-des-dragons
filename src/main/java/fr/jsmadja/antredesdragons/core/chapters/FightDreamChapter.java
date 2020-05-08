package fr.jsmadja.antredesdragons.core.chapters;

import fr.jsmadja.antredesdragons.core.entities.Foe;
import fr.jsmadja.antredesdragons.core.entities.Pip;

import java.util.List;

public abstract class FightDreamChapter extends DreamChapter {

    @Override
    public Execution execute(Pip pip) {
        Foe foe = getFoe();
        onBeforeFight(pip, foe);
        pip.fight(List.of(foe));
        onAfterFight(pip);
        if (pip.isDead()) {
            return pip.goTo(ChapterNumber.chapter(14));
        }
        return super.execute(pip);
    }

    protected void onBeforeFight(Pip pip, Foe foe) {
    }

    protected void onAfterFight(Pip pip) {
    }

    protected abstract Foe getFoe();
}
