package fr.jsmadja.antredesdragons.core.chapters;

public enum Answer {
    Yes,
    No;

    public static Answer of(String answer) {
        return "yes".equalsIgnoreCase(answer) ? Yes : No;
    }

    public boolean isYes() {
        return this == Yes;
    }

    public boolean isNo() {
        return this == No;
    }
}
