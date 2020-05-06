package fr.jsmadja.antredesdragons.entities;

public abstract class SpellFightEndExecution {
    public static SpellFightEndExecution nothing() {
        return new SpellFightEndExecution() {
            @Override
            public void execute(Entity entity) {

            }
        };
    }

    public abstract void execute(Entity entity);
}
