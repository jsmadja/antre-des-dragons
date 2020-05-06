package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.dices.Dice;
import fr.jsmadja.antredesdragons.entities.Foe;
import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.pages.Execution;
import fr.jsmadja.antredesdragons.pages.MultipleFightPage;
import fr.jsmadja.antredesdragons.stuff.Item;
import fr.jsmadja.antredesdragons.ui.Prompt;

import java.util.List;
import java.util.stream.IntStream;

import static fr.jsmadja.antredesdragons.spellcasting.SpellBook.INVISIBILITY;
import static java.util.stream.Collectors.toList;

public class Page98 extends MultipleFightPage {
    @Override
    public String getText() {
        return "Le passage, une fissure naturelle dans le rocher, selon toute apparence, s'incurve, " +
                "tourne, s'élargit, se rétrécit de nouveau et vous finissez par perdre tout sens de la " +
                "direction. (Bien que vous ayez, en gros, la sensation d'aller vers le nord-ouest.) Le " +
                "passage se resserre à tel point que vous êtes obligé de vous tourner de côté pour " +
                "avancer. Vous franchissez les derniers mètres en vous aplatissant de votre mieux et " +
                "vous émergez, tel un bouchon d'une bouteille, dans une autre caverne plus vaste que " +
                "celle par laquelle vous êtes entré. Dans cette caverne vous remarquez vite un groupe " +
                "de minuscules créatures humanoïdes à grosses têtes, qui s'avance vers vous. Elles sont " +
                "armées d'épées, et revêtues d'armures en cuir. Vous êtes tombé, cela ne fait aucun " +
                "doute pour vous, sur des Trolls des Rochers. Un deuxième passage permet de sortir de " +
                "cette caverne en direction du nord, et il paraît un peu plus large que celui que vous " +
                "venez d'emprunter. Mais, comment l'atteindre ? " +
                "Votre sortilège INVISIBILITÉ peut opérer ici. Si vous l'utilisez avec succès, il vous " +
                "sera possible de passer en catimini à côté des Trolls, puis de gagner le passage nord. " +
                "Rendez-vous au [99]. Mais n'oubliez pas que ce sortilège ne peut être utilisé qu'une " +
                "seule fois, et que vous risquez d'en avoir besoin par la suite. Vous pouvez aussi " +
                "adresser la parole aux Trolls, en espérant les convaincre de vous laisser passer. " +
                "Rendez-vous, dans ce cas, au [103]. Vous pouvez également bondir sur eux pour " +
                "essayer de les mettre en pièces. Il y a six Trolls en tout. Chacun dispose de 10 " +
                "POINTS DE VIE. Ils n'ont pas l'air de se méfier, vous pouvez donc frapper un premier " +
                "coup contre l'un d'entre eux. Les autres, néanmoins, répliqueront à tour de rôle, avant " +
                "que vous ne puissiez porter un nouveau coup. Ils vous frappent en faisant un 6, et leurs " +
                "épées pourront vous infliger 2 Points de Dommage supplémentaires. Leurs armures, " +
                "de qualité médiocre, ne peuvent annuler qu'un seul Point de Dommage. Maintenant, " +
                "vous pouvez lancer vos dés. Si vous êtes vainqueur, rendez-vous au [99]. Sinon, vous " +
                "avez droit au [14].";
    }

    @Override
    public Execution execute(Pip pip) {
        if (pip.hasSpell(INVISIBILITY)) {
            if (this.useInvisibilitySpell()) {
                pip.removeSpell(INVISIBILITY);
                return pip.goToPage(99);
            }
        }
        if (this.talkToTrolls()) {
            return pip.goToPage(103);
        }
        return super.execute(pip);
    }

    @Override
    protected int getSuccessPage() {
        return 99;
    }

    @Override
    protected List<Foe> getFoes(Pip pip) {
        return IntStream
                .range(1, 7)
                .mapToObj(operand -> {
                    Foe foe = Foe.builder()
                            .name("Troll des Rochers #" + operand)
                            .dice(new Dice()).initialHealthPoints(10)
                            .build();
                    foe.addAndEquip(Item.TROLL_SWORD);
                    foe.addAndEquip(Item.TROLL_ARMOR);
                    return foe;
                })
                .collect(toList());
    }

    private boolean talkToTrolls() {
        return Prompt.answerTo("Parler aux trolls").isYes();
    }

    private boolean useInvisibilitySpell() {
        return Prompt.answerTo("Utiliser le sort d'invisibilité").isYes();
    }

}
