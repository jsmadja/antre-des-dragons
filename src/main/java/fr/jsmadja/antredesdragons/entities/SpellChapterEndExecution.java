package fr.jsmadja.antredesdragons.entities;

public abstract class SpellChapterEndExecution {
    public static SpellChapterEndExecution nothing() {
        return new SpellChapterEndExecution() {
            @Override
            public void execute(Pip pip) {

            }
        };
    }

    public abstract void execute(Pip pip);
}
