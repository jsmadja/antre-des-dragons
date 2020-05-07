package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.chapters.Execution;
import fr.jsmadja.antredesdragons.chapters.GoNextChapter;
import fr.jsmadja.antredesdragons.stuff.DamagePoint;

public class Chapter32 extends GoNextChapter {
    @Override
    public int getNextChapter() {
        return 23;
    }

    @Override
    public Execution execute(Pip pip) {
        pip.addTemporaryDamagePointsMalus(DamagePoint.damage(4));
        return super.execute(pip);
    }

    @Override
    public String getText() {
        return "Pas un mauvais choix, Pip. Les armes magiques sont efficaces ici, bien que vous " +
                "ayez à soustraire 4 points de tous les Points de Dommage qu'elles infligent. rendezvous au [23].";
    }
}
