package fr.jsmadja.antredesdragons.core.chapters;

import fr.jsmadja.antredesdragons.core.entities.Foe;
import fr.jsmadja.antredesdragons.core.entities.Pip;

import java.util.List;

public abstract class SingleFightChapter extends Chapter {
    @Override
    public Execution execute(Pip pip) {
        onBeforeFight(pip);
        pip.fight(List.of(getFoe()));
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

    protected abstract Foe getFoe();

}
