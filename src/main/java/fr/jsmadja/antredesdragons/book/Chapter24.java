package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.chapters.SingleFightChapter;
import fr.jsmadja.antredesdragons.entities.Foe;

import static fr.jsmadja.antredesdragons.stuff.HealthPoints.hp;
import static fr.jsmadja.antredesdragons.stuff.Item.GHOST_SWORD;

public class Chapter24 extends SingleFightChapter {
    @Override
    public String getText() {
        return "Cette église ne ressemble à aucune de celles qu'il vous ait été donné de voir. Du " +
                "moins, dans l'état où - elle se trouve. Il y a une nef, des bancs, un autel, un orgue, une " +
                "chaire, un lutrin et tout le reste, y compris des vitraux. Mais tout cela est couvert de " +
                "poussière, et il y a des toiles d'araignées partout. Elles vous effleurent le visage quand " +
                "vous avancez, et un nuage de poussière se soulève à chacun de vos pas. Les habitants " +
                "n'ont guère l'air portés sur la religion. Vous avancez, et... ta-ta-ta-boum ! Une musique " +
                "d'orgue ! L'orgue de l'église s'est mis à jouer. Vous sursautez, vous pivotez sur vous-même en levant les yeux vers la tribune d'orgue, mais les toiles d'araignées vous " +
                "empêchent de voir. Ah ha ha ha ha ah !\n" +
                "Un rire dément ! Son écho se répercute dans toute l'église puis la musique " +
                "s'interrompt brusquement. D'instinct, vous portez la main à la garde de votre épée, et " +
                "c'est une chance, car une silhouette voilée et masquée, brandissant une lame " +
                "étincelante, se balance au-dessus de vous au bout d'une corde. — Prends garde ! " +
                "hurle la créature en atterrissant à quelques mètres devant vous. Prends garde au Fantôme de l'Église du Village ! Là-dessus, il bondit sur vous et vous attaque " +
                "férocement, l'épée haute. Pas de doute, il faut vous battre, Pip, quoi que vous en " +
                "pensiez. Le Fantôme possède 30 POINTS DE VIE mais ne porte pas d'armure, vous " +
                "lui infligerez donc le maximum de Points de Dommage chaque fois que vous le " +
                "frapperez. En revanche, il est de première force à l'épée, il lui suffit donc de sortir un " +
                "5 ou plus pour vous frapper. Son épée inflige 3 Points de Dommage. " +
                "si le Fantôme vous tue, rendez-vous au [14]. si VOUS tuez le Fantôme, rendez-vous [87].";
    }

    @Override
    public int getSuccessChapter() {
        return 87;
    }

    @Override
    public Foe getFoe() {
        Foe foe = Foe.builder()
                .name("Fantôme")
                .initialHealthPoints(hp(30))
                .build();
        foe.addAndEquip(GHOST_SWORD);
        return foe;
    }
}
