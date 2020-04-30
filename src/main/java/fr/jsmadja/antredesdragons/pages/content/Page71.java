package fr.jsmadja.antredesdragons.pages.content;

import fr.jsmadja.antredesdragons.pages.types.Execution;
import fr.jsmadja.antredesdragons.stuff.Item;
import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.pages.types.GoPage;

public class Page71 extends GoPage {
    @Override
    public String getText() {
        return "Félicitations ! Vous avez trouvé un fer à cheval Maintenant ne perdez plus de temps. " +
                "Reprenez la carte pour explorer une partie plus intéressante du village.";
    }

    @Override
    public Execution execute(Pip pip) {
        pip.addInInventory(Item.FER_A_CHEVAL);
        return super.execute(pip);
    }

    @Override
    protected int getNextPage() {
        return 10;
    }
}
