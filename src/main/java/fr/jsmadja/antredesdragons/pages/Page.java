package fr.jsmadja.antredesdragons.pages;

import fr.jsmadja.antredesdragons.entities.Pip;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Page {

    private boolean visited;

    public abstract String getText();

    public abstract Execution execute(Pip pip);

}
