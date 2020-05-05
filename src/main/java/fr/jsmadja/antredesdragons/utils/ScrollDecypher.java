package fr.jsmadja.antredesdragons.utils;

import java.util.stream.Collectors;

public class ScrollDecypher {
    public static String scrollDecypher(String scrollText) {
        return (scrollText.chars().mapToObj(letterIntCode -> {
            char letter = (char) letterIntCode;
            return Character.toString(letter == ' ' || letter == ',' || letter == '\'' || letter == '.' ? letter : (char) (letterIntCode - 1));
        }).collect(Collectors.joining()));
    }

}
