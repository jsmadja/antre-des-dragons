package fr.jsmadja.antredesdragons;

import fr.jsmadja.antredesdragons.chapters.ChapterNumber;
import fr.jsmadja.antredesdragons.dices.Roll;
import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.stuff.HealthPoints;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Sleep {
    private final Pip pip;

    public boolean isGood() {
        return pip.roll1Dice().isGreaterThan(Roll.roll(4));
    }

    public HealthPoints getHealthPoints() {
        return pip.roll2Dices().toHealthPoints();
    }

    public ChapterNumber getDreamChapterNumber() {
        return pip.roll2Dices().toChapterNumber();
    }
}
