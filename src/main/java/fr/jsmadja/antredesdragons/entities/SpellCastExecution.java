package fr.jsmadja.antredesdragons.entities;

public abstract class SpellCastExecution {

    public static SpellCastExecution nothing() {
        return new SpellCastExecution() {
            @Override
            public void execute(Pip pip) {

            }
        };
    }

    public abstract void execute(Pip pip);

}
