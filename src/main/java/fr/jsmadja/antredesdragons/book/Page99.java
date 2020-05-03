package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.ui.Prompt;
import fr.jsmadja.antredesdragons.dices.Roll;
import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.pages.Execution;
import fr.jsmadja.antredesdragons.pages.ManualChoicePage;
import fr.jsmadja.antredesdragons.stuff.Item;

public class Page99 extends ManualChoicePage {
    @Override
    public String getText() {
        return "Le passage, qui semble fort fréquenté, débouche quelques deux cents mètres plus loin " +
                "sur une immense caverne, dont la suffocante puanteur vous prend à la gorge. Votre " +
                "torche vous révèle bientôt l'origine de cette odeur : au centre de la caverne est amassé " +
                "un énorme monceau de déjections de Dragons. Vous portez aussitôt la main à la garde " +
                "de votre épée, mais une brève inspection des lieux vous amène à la conclusion qu'il n'y " +
                "a, pour le moment, aucun Dragon dans les parages. Posté au centre de a caverne, tout " +
                "près du tas de fumier, vous constatez qu'il existe trois issues possibles. " +
                "Si vous empruntez le passage ouest, rendez-vous au [98]. " +
                " " +
                "Si vous empruntez le passage nord, rendez-vous au [105]. " +
                "Le passage est presque totalement obstrué par un enorme bloc de rocher. Si vous " +
                "désirez partir dans cette direction, lancez deux dés pour savoir si vous êtes " +
                "suffisamment fort pour déplacer ce rocher. Si vous faites de 2 à 6, il ne bouge pas d'un " +
                "millimètre. Si vous faites de 7 à 12, vous réussissez, malgré son poids, à le déplacer, et " +
                "vous pouvez vous faufiler dans le passage. Rendez-vous au [102]. " +
                "Si vous le désirez, vous pouvez utiliser ici l'une de vos précieuses Boules de Feu. Si " +
                "tout se passe bien, elle pulvérisera le rocher, vous permettant ainsi d'emprunter le " +
                "passage. Rendez-vous au [102]. Enfin, vous pouvez farfouiller dans le tas de déjections " +
                "(perspective révoltante !) pour voir s'il ne cache pas quelque chose d'intéressant, avant " +
                "de quitter la caverne. Rendez-vous dans ce cas au [111].";
    }

    @Override
    public Execution execute(Pip pip) {
        if (Prompt.answerTo("Voulez vous déplacer le rocher").isYes()) {
            Roll roll = pip.roll2Dices();
            if (roll.isBetween(7, 12)) {
                return pip.goToPage(102);
            }
        }
        if (pip.has(Item.FIREBALL)) {
            if (Prompt.answerTo("Voulez-vous utiliser une boule de feu").isYes()) {
                pip.removeOne(Item.FIREBALL);
                return pip.goToPage(102);
            }
        }
        return super.askWhichWay(pip);
    }

    @Override
    public Paths getPossiblesPath(Pip pip) {
        return new Paths(
                Path.builder().description("Emprunter le passage ouest").page(98).build(),
                Path.builder().description("Emprunter le passage nord").page(105).build(),
                Path.builder().description("Fouiller les tas de déjections").page(111).build()
        );
    }
}
