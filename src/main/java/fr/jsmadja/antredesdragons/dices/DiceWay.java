package fr.jsmadja.antredesdragons.dices;

import fr.jsmadja.antredesdragons.pages.content.PageNumber;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class DiceWay {
    private Integer from;
    private Integer to;
    private PageNumber pageNumber;

    public boolean matches(Roll roll) {
        return roll.isBetween(from, to);
    }
}
