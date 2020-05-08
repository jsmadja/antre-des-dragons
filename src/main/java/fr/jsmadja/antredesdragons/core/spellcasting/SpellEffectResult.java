package fr.jsmadja.antredesdragons.core.spellcasting;

public enum SpellEffectResult {
    FAILURE, SUCCESS;

    public boolean withSuccess() {
        return this == SUCCESS;
    }
}
