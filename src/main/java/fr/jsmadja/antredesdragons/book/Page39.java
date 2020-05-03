package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.market.GoldenCoins;
import fr.jsmadja.antredesdragons.pages.Execution;
import fr.jsmadja.antredesdragons.pages.Page;
import fr.jsmadja.antredesdragons.ui.Prompt;

public class Page39 extends Page {
    @Override
    public String getText() {
        return "Comme vous vous approchez de cette chaumière, vous remarquez, près de la porte " +
                "d'entrée, l'un de ces atroces gnomes en plastique dont on décore les jardins et qui vont " +
                "devenir si populaires dans quelques siècles. Hé, un instant ! Un nain en plastique du " +
                "temps du roi Arthur ! Il y a là quelque chose qui cloche !\n" +
                "— Bonjour, l'Humain, dit le Gnome que vous contemplez alors avec stupéfaction.\n" +
                "— Vous êtes... réel ? demandez-vous bêtement.\n" +
                "— Je pense, répond le Gnome. Que puis-je faire pour vous ?\n" +
                "Excellente question, puisque vous comptiez simplement fouiner un peu dans sa " +
                "chaumière, ce que vous ne pouvez guère lui avouer. Après réflexion, vous repondez :\n" +
                "— Je me demande, Gnoble Gnome, si vous connaissez le meilleur chemin pour " +
                "arriver à l'Antre du Dragon ? Ou, par ailleurs, si vous pouvez m'indiquer un moyen de " +
                "sortir de ce village.\n" +
                "Il opine gravement de sa tête de Gnome.\n" +
                "—Parmi toutes les questions que vous auriez pu poser, je peux vous proposer des " +
                "réponses à ces deux-là. Avez-vous de quoi les payer ?\n" +
                "—Payer quoi ? demandez-vous.\n" +
                "—Les réponses ! rugit le Gnome, furieux. Vous ne pensez quand même pas que je vais " +
                "vous donner gratis des renseignements de cette valeur ?\n" +
                "— Non, bien sûr, mentez-vous effrontément. Combien coûtent les réponses ?\n" +
                "—Ça dépend, dit-il un peu calmé. Je suis, comprenez-vous, un Gnome à l'esprit " +
                "aventureux, et donc tout à fait prêt à laisser le hasard décider du prix. Là-dessus, il sort " +
                "de sa poche deux dés tout à fait semblables aux vôtres.\n" +
                "—Voulez-vous prendre la peine de les examiner? dit-il. Pour vous assurer qu'ils ne " +
                "sont pas pipés ou trafiqués d'une façon quelconque ?\n" +
                "Vous les examinez donc. On a beau être transporté à " +
                "— l'ère de la Chevalerie, l'esprit chevaleresque ne vous oblige pas à vous laisser " +
                "arnaquer par un Gnome. Les dés, cependant, sont parfaitement normaux.\n" +
                "Voyons, reprend le Gnome', vous désirez connaître le chemin jusqu'à l'Antre du " +
                "Dragon. Disons que c'est la Question n° 1. Et vous voulez savoir comment on sort du " +
                "village. Ce sera la Question n° 2. Maintenant nous allons jeter ces dés parfaitement " +
                "normaux et découvrir combien vaut chaque question, en Pièces d'Or. Pour chaque " +
                "point sorti par les dés, la valeur sera de 10 Pièces d'Or. Vous pouvez donc, " +
                "éventuellement obtenir les réponses à vos questions pour 20 Pièces, mais il se peut que " +
                "vous ayez à débourser jusqu'à 120 Pièces d'Or. Inscrivez ci-dessous les chiffres que " +
                "vous obtenez en lançant les dés, et multipliez-les par 10.\n" +
                "Question n° 1 : Question n° 2 : \n" +
                "Avez-vous les moyens de payer pour obtenir des réponses à vos questions ? Vérifiez " +
                "l'argent et les objets de valeur dont vous disposez. Si vous ne voulez pas payer, que " +
                "vous en ayez les moyens ou non, reprenez votre carte et allez explorer un autre endroit " +
                "(le Gnome n'y verra aucun inconvénient, et vous pourrez toujours revenir le voir plus " +
                "tard, si vous le désirez).\nSi vous payez pour une réponse à la Question n° 1. rendez-vous au [93]. " +
                "Si vous payez pour une réponse à la Question n° 2, rendez-vous au [113]. " +
                "Si vous payez pour les deux réponses, vous pouvez choisir de vous rendre soit au [93], " +
                "soit au [113].";
    }

    @Override
    public Execution execute(Pip pip) {
        GoldenCoins answerOnePrice = getRandomAnswerPrice(pip);
        if (pip.has(answerOnePrice) && Prompt.answerTo("Payer " + answerOnePrice + " pour avoir la réponse à la question n° 1").isYes()) {
            pip.remove(answerOnePrice);
            return pip.goToPage(93);
        }
        GoldenCoins answerTwoPrice = getRandomAnswerPrice(pip);
        if (pip.has(answerTwoPrice) && Prompt.answerTo("Payer " + answerTwoPrice + " pour avoir la réponse à la question n° 2").isYes()) {
            pip.remove(answerTwoPrice);
            return pip.goToPage(113);
        }

        return pip.goToPage(10);
    }

    private GoldenCoins getRandomAnswerPrice(Pip pip) {
        return GoldenCoins.of(pip.roll2Dices().getValue() * 10);
    }
}
