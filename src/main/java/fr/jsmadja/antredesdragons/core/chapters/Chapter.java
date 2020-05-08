package fr.jsmadja.antredesdragons.core.chapters;

import fr.jsmadja.antredesdragons.core.entities.Pip;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Chapter {

    private boolean visited;

    public abstract String getText();

    public abstract Execution execute(Pip pip);

    protected void beforeLeavingChapter(Pip pip) {}

}
