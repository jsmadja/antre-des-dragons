package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.pages.Execution;
import fr.jsmadja.antredesdragons.stuff.Item;
import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.pages.GoPage;

public class Page71 extends GoPage {
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
    protected int getNextPage() {
        return 10;
    }
}
