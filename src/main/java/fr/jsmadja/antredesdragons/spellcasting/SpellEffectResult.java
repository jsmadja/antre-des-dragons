package fr.jsmadja.antredesdragons.spellcasting;

public enum SpellEffectResult {
    FAILURE, SUCCESS;

    public boolean withSuccess() {
        return this == SUCCESS;
    }
}
