package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.Execution;
import fr.jsmadja.antredesdragons.core.chapters.GoNextChapter;
import fr.jsmadja.antredesdragons.core.entities.Pip;
import fr.jsmadja.antredesdragons.core.inventory.Item;

public class Chapter71 extends GoNextChapter {
    @Override
    public String getText() {
        return "Félicitations ! Vous avez trouvé un fer à cheval Maintenant ne perdez plus de temps. " +
                "Reprenez la carte pour explorer une partie plus intéressante du village.";
    }

    @Override
    public Execution execute(Pip pip) {
        pip.add(Item.HORSESHOE);
        return super.execute(pip);
    }

    @Override
    public int getNextChapter() {
        return 10;
    }
}
