package fr.jsmadja.antredesdragons.chapters;

import fr.jsmadja.antredesdragons.book.ChapterNumber;
import fr.jsmadja.antredesdragons.entities.Foe;
import fr.jsmadja.antredesdragons.entities.Pip;

import java.util.List;

public abstract class SingleFightChapter extends Chapter {
    @Override
    public Execution execute(Pip pip) {
        onBeforeFight(pip);
        pip.fight(List.of(getFoe()));
        if (pip.isDead()) {
            return pip.goToChapter(ChapterNumber.chapter(14));
        }
        onAfterSuccessfulFight(pip);
        return pip.goToChapter(ChapterNumber.chapter(getSuccessChapter()));
    }

    protected void onBeforeFight(Pip pip) {
    }

    protected void onAfterSuccessfulFight(Pip pip) {

    }

    protected abstract int getSuccessChapter();

    protected abstract Foe getFoe();

}
