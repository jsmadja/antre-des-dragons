package fr.jsmadja.antredesdragons.core.sleep;

import fr.jsmadja.antredesdragons.core.chapters.ChapterNumber;
import fr.jsmadja.antredesdragons.core.dices.Roll;
import fr.jsmadja.antredesdragons.core.entities.Pip;
import fr.jsmadja.antredesdragons.core.stuff.HealthPoints;
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
