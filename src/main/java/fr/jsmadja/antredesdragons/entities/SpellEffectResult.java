package fr.jsmadja.antredesdragons.entities;

public enum SpellEffectResult {
    FAILURE, SUCCESS;

    public boolean withSuccess() {
        return this == SUCCESS;
    }
}
