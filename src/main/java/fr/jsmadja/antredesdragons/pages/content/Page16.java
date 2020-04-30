package fr.jsmadja.antredesdragons.pages.content;

import fr.jsmadja.antredesdragons.pages.types.Execution;
import fr.jsmadja.antredesdragons.dices.DiceWay;
import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.pages.types.Page;

public class Page16 extends Page {
    @Override
    public String getText() {
        return "Vous poursuivez péniblement votre chemin, laissant bientôt la sombre forêt loin " +
                "derrière vous. Le paysage est plus riant maintenant mais, au bout d'un moment, la route descend " +
                "et plonge dans une vallée. Vous continuez à avancer et vous vous trouvez bientôt environné d'une " +
                "brume qui ne cesse de s'épaissir. Cette brume se transforme bien vite en brouillard. Et vous ne voyez" +
                " même plus le bout de votre nez. Votre sens de l'orientation, si aigu d'habitude, s'amenuise, diminue, " +
                "disparaît complètement, saprelotte, Pip, vous voilà perdu ! Il ne vous reste plus qu'une solution : " +
                "lancer deux dés pour décider dans quelle direction poursuivre.\n" +
                "Si vous faites : de 2 à 4 : rendez-vous au [5].\n" +
                "de 5 à 7 : rendez-vous au [8].\n" +
                "de 8 à 12 : rendez-vous au [64].";
    }

    @Override
    public Execution execute(Pip pip) {
        return pip.rollAndGo(new DiceWay(2, 4, PageNumber.of(5)),
                new DiceWay(5, 7, PageNumber.of(8)),
                new DiceWay(8, 12, PageNumber.of(64))
        );
    }
}
