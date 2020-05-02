package fr.jsmadja.antredesdragons.pages;

import fr.jsmadja.antredesdragons.book.PageNumber;
import fr.jsmadja.antredesdragons.dices.Roll;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class DiceWay {
    private final Integer from;
    private final Integer to;
    private final PageNumber pageNumber;

    public boolean matches(Roll roll) {
        return roll.isBetween(from, to);
    }
}
