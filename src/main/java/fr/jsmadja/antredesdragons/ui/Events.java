package fr.jsmadja.antredesdragons.ui;

import static java.lang.System.out;

public class Events {

    private static final int LEFT_PADDING = 10;

    public static void fightEvent(String message) {
        out.println(pad("[FIGHT]") + message.trim());
    }

    public static void statusEvent(String message) {
        out.println(pad("[STATUS]") + message);
    }

    public static void diceEvent(String message) {
        out.println(pad("[DICE]") + message);
    }

    public static void pageEvent(String message) {
        out.println(pad("\n[PAGE]") + message + "\n");
    }

    public static void inventoryEvent(String message) {
        out.println(pad("[INVENTORY]") + message);
    }

    public static void questionEvent(String message) {
        out.println(pad("\n[QUESTION]") + message);
    }

    public static void spellEvent(String message) {
        out.println(pad("[SPELL]") + message);
    }

    public static void event(String message) {
        out.println(message);
    }

    private static String pad(String message) {
        return String.format("%-"+LEFT_PADDING+"s ", message);
    }

}
