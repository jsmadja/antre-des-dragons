package fr.jsmadja.antredesdragons.dices;

import fr.jsmadja.antredesdragons.pages.content.PageNumber;
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
