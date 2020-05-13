package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.GoNextChapter;
import fr.jsmadja.antredesdragons.core.entities.Pip;
import fr.jsmadja.antredesdragons.core.execution.Execution;
import fr.jsmadja.antredesdragons.core.stuff.DamagePoints;

public class Chapter32 extends GoNextChapter {
    @Override
    public int getNextChapter() {
        return 23;
    }

    @Override
    public Execution execute(Pip pip) {
        pip.addTemporaryDamagePointsMalus(DamagePoints.damage(4));
        return super.execute(pip);
    }

    @Override
    public String getText() {
        return "Pas un mauvais choix, Pip. Les armes magiques sont efficaces ici, bien que vous " +
                "ayez à soustraire 4 points de tous les Points de Dommage qu'elles infligent. rendezvous au [23].";
    }
}
