package fr.jsmadja.antredesdragons.core.ui;

import static java.lang.System.err;

public class Events {

    public static void questionEvent(String message) {
        err.println(String.format("%-10s ", "\n[QUESTION]") + message);
    }

}
