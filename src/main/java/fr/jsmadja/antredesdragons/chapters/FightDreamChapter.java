package fr.jsmadja.antredesdragons.chapters;

import fr.jsmadja.antredesdragons.entities.Foe;
import fr.jsmadja.antredesdragons.entities.Pip;

import java.util.List;

import static fr.jsmadja.antredesdragons.chapters.ChapterNumber.chapter;

public abstract class FightDreamChapter extends DreamChapter {

    @Override
    public Execution execute(Pip pip) {
        Foe foe = getFoe();
        onBeforeFight(pip, foe);
        pip.fight(List.of(foe));
        onAfterFight(pip);
        if (pip.isDead()) {
            return pip.goTo(chapter(14));
        }
        return super.execute(pip);
    }

    protected void onBeforeFight(Pip pip, Foe foe) {
    }

    protected void onAfterFight(Pip pip) {
    }

    protected abstract Foe getFoe();
}
