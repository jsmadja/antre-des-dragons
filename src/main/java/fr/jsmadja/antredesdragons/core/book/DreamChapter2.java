package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.FightDreamChapter;
import fr.jsmadja.antredesdragons.core.entities.Foe;
import fr.jsmadja.antredesdragons.core.entities.Pip;

import static fr.jsmadja.antredesdragons.core.stuff.HealthPoints.hp;

public class DreamChapter2 extends FightDreamChapter {
    @Override
    public String getText() {
        return "Vous vous trouvez face à une petite créature volante en forme de cigare qui ne " +
                "cesse de vous harceler. Bien qu'elle ne vous touche pas, à chaque passage elle émet " +
                "une vibration qui altère votre cerveau et vous fait perdre 5 POINTS DE VIE. Cette " +
                "créature est un Ronge-Méninges. Elle dispose de 15 POINTS DE VIE et frappe la " +
                "première. Combattez-la au plus vite !";
    }

    @Override
    protected void onBeforeFight(Pip pip, Foe foe) {
        super.onBeforeFight(pip, foe);
        pip.loseInitiative();
    }

    @Override
    protected Foe getFoe() {
        return Foe.builder()
                .name("Ronge-Méninges")
                .constantHitDamage(5)
                .initialHealthPoints(hp(15))
                .build();
    }
}
