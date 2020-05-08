package fr.jsmadja.antredesdragons.core.ui;

import static java.lang.System.err;

public class Events {

    private static final int LEFT_PADDING = 10;

    public static void fightEvent(String message) {
        err.println(pad("[FIGHT]") + message.trim());
    }

    public static void statusEvent(String message) {
        err.println(pad("[STATUS]") + message);
    }

    public static void diceEvent(String message) {
        err.println(pad("[DICE]") + message);
    }

    public static void chapterEvent(String message) {
        err.println(pad("\n[CHAPTER]") + message + "\n");
    }

    public static void inventoryEvent(String message) {
        err.println(pad("[INVENTORY]") + message);
    }

    public static void questionEvent(String message) {
        err.println(pad("\n[QUESTION]") + message);
    }

    public static void spellEvent(String message) {
        err.println(pad("[SPELL]") + message);
    }

    public static void event(String message) {
        err.println(message);
    }

    private static String pad(String message) {
        return String.format("%-" + LEFT_PADDING + "s ", message);
    }

}
