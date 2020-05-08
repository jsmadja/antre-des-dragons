package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.FightDreamChapter;
import fr.jsmadja.antredesdragons.core.entities.Foe;
import fr.jsmadja.antredesdragons.core.entities.Pip;
import fr.jsmadja.antredesdragons.core.stuff.Item;

import static fr.jsmadja.antredesdragons.core.dices.Roll.roll;
import static fr.jsmadja.antredesdragons.core.stuff.HealthPoints.hp;

public class DreamChapter8 extends FightDreamChapter {
    @Override
    public String getText() {
        return "Vous combattez le Chevalier Noir, un redoutable scélérat disposant de 25 POINTS " +
                "DE VIE. Vous portez une armure qui vous permet de déduire 5 points, des Points de " +
                "Dommage que le Chevalier peut vous infliger. L'armure de votre adversaire est plus " +
                "robuste, elle peut absorber 6 Points de Dommage. La lance utilisée par le Chevalier " +
                "Noir lui donne 10 Points de Dommage supplémentaires à chaque fois qu'il vous " +
                "portera un coup. Cependant, votre lance a été baptisée par l'archevêque de Canterbury " +
                "et elle vous permet d'ajouter 12 Points de Dommage supplémentaire à chaque coup " +
                "que vous porterez. Le roi Arthur lance deux dés pour décider de celui qui frappera en " +
                "premier. S'il obtient de 2 à 6, c'est le Chevalier Noir qui prend l'initiative. S'il obtient " +
                "de 7 à 12, c'est vous qui commencez.";
    }

    @Override
    protected void onBeforeFight(Pip pip, Foe foe) {
        pip.addAndEquip(Item.DREAM_ARMOR);
        pip.addAndEquip(Item.CANTERBURY_SPEAR);
        Foe arthurKing = Foe.builder().name("Roi Arthur").build();
        if (arthurKing.roll2Dices().isLesserThan(roll(7))) {
            pip.loseInitiative();
        }
    }

    @Override
    protected void onAfterFight(Pip pip) {
        pip.unequip(Item.DREAM_ARMOR);
        pip.remove(Item.DREAM_ARMOR);
        pip.unequip(Item.CANTERBURY_SPEAR);
        pip.remove(Item.CANTERBURY_SPEAR);
    }

    @Override
    protected Foe getFoe() {
        Foe foe = Foe.builder()
                .name("Chevalier Noir")
                .initialHealthPoints(hp(25))
                .build();
        foe.addAndEquip(Item.BLACK_KNIGHT_ARMOR);
        foe.addAndEquip(Item.BLACK_KNIGHT_SPEAR);
        return foe;
    }
}
