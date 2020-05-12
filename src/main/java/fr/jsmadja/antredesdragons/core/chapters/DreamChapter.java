package fr.jsmadja.antredesdragons.core.chapters;

import fr.jsmadja.antredesdragons.core.entities.FoeFactory;
import fr.jsmadja.antredesdragons.core.entities.Pip;
import lombok.Getter;

public abstract class DreamChapter {

    @Getter
    private FoeFactory foeFactory = new FoeFactory();

    public abstract String getText();

    public Execution execute(Pip pip) {
        pip.setSleeping(false);
        return pip.goToPreviousChapter();
    }
}
