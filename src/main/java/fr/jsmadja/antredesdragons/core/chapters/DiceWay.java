package fr.jsmadja.antredesdragons.core.chapters;

import fr.jsmadja.antredesdragons.core.dices.Roll;
import fr.jsmadja.antredesdragons.core.execution.Action;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class DiceWay {
    private final Integer from;
    private final Integer to;
    private final ChapterNumber chapterNumber;

    public boolean matches(Roll roll) {
        return roll.isBetween(from, to);
    }

    public Action toAction() {
        return Action.builder().chapter(chapterNumber).build();
    }
}
