package fr.jsmadja.antredesdragons.dices;

import fr.jsmadja.antredesdragons.chapters.ChapterNumber;
import fr.jsmadja.antredesdragons.stuff.HealthPoints;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static fr.jsmadja.antredesdragons.chapters.ChapterNumber.chapter;
import static fr.jsmadja.antredesdragons.stuff.HealthPoints.hp;

@RequiredArgsConstructor
@Getter
public class Roll {
    private final int value;

    public boolean isBetween(int minIncluded, int maxIncluded) {
        return minIncluded <= value && value <= maxIncluded;
    }

    public boolean isGreaterThan(Roll roll) {
        return this.value > roll.value;
    }

    public boolean is(int value) {
        return this.value == value;
    }

    public static Roll roll(int value) {
        return new Roll(value);
    }

    public HealthPoints toHealthPoints() {
        return hp(this.value);
    }

    public ChapterNumber toChapterNumber() {
        return chapter(this.value);
    }

    public boolean isLesserThan(Roll roll) {
        return this.value < roll.value;
    }
}
