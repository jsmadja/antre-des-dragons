package fr.jsmadja.antredesdragons.entities;

public abstract class SpellFightExecution {

    public static SpellFightExecution nothing() {
        return new SpellFightExecution() {
            @Override
            public void execute(Pip pip, Entity target) {

            }
        };
    }

    public abstract void execute(Pip pip, Entity target);

}
