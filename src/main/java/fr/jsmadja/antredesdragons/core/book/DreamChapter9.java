package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.Sleep;
import fr.jsmadja.antredesdragons.core.chapters.DreamChapter;
import fr.jsmadja.antredesdragons.core.chapters.Execution;
import fr.jsmadja.antredesdragons.core.entities.Pip;

public class DreamChapter9 extends DreamChapter {
    @Override
    public String getText() {
        return ":Vous vous trouvez dans un sinistre couloir face à un énorme Monstre du Sommeil " +
                "couvert de poils. Vous n'avez ni armes ni armure mais, près de vous, sont posés deux " +
                "coffrets. Vous n'avez le temps d'en ouvrir qu'un seul avant que le Monstre du Sommeil " +
                "ne vous attaque. Lancez un dé. Si vous faites de 1 à 3, vous trouvez une dague " +
                "magique qui vous permet de trucider instantanément le Monstre. De 4 à 6, le coffret " +
                "que vous ouvrez est rempli de gaz soporifique. Autrement dit, vous voilà obligé de " +
                "vous endormir et de lancer à nouveau les dés pour savoir si vous allez faire un " +
                "nouveau voyage dans le Temps du Rêve.";
    }

    @Override
    public Execution execute(Pip pip) {
        if (pip.roll1Dice().isBetween(4, 6)) {
            Sleep sleep = new Sleep(pip);
            if (!sleep.isGood()) {
                return pip.goToDreamChapter(sleep.getDreamChapterNumber());
            }
        }
        return super.execute(pip);
    }
}
