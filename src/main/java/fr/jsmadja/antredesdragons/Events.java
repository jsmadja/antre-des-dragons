package fr.jsmadja.antredesdragons;

public class Events {
    public static void fightEvent(String message) {
        System.out.println("[FIGHT] " + message);
    }

    public static void statusEvent(String message) {
        System.out.println("[STATUS] " + message);
    }

    public static void diceEvent(String message) {
        System.out.println("  [DICE] " + message);
    }

    public static void pageEvent(String message) {
        System.out.println("\n[PAGE] " + message+"\n");
    }

    public static void inventoryEvent(String message) {
        System.out.println("[INVENTORY] " + message);
    }

    public static void questionEvent(String message) {
        System.out.println("\n[QUESTION] "+message);
    }
}
