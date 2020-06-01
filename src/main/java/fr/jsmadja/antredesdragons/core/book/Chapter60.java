package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.GoNextChapter;
import fr.jsmadja.antredesdragons.core.entities.Pip;
import fr.jsmadja.antredesdragons.core.execution.Execution;
import fr.jsmadja.antredesdragons.core.spellcasting.SpellBook;

import static fr.jsmadja.antredesdragons.core.spellcasting.SpellBook.FIP;
import static fr.jsmadja.antredesdragons.core.spellcasting.SpellBook.HEP;
import static fr.jsmadja.antredesdragons.core.spellcasting.SpellEffectResult.FAILURE;

public class Chapter60 extends GoNextChapter {
    private int nextChapter = 14;

    @Override
    public String getText() {
        return "N'avez-vous rien de mieux à faire que de fixer le fond d'un puits, Pip ? " +
                "Particulièrement un puits où se trouve un Farfadet des Eaux. Parfaitement, un " +
                "farfadet des Eaux !\n" +
                "Cette créature ne possède que 10 POINTS DE VIE, mais si cette nouvelle paraît bonne, " +
                "réfléchissez à deux fois : seule la magie peut la neutraliser. Il va falloir utiliser le " +
                "sortilège FIP ou le sortilège HEP (s'il vous en reste).\n" +
                "Si l'un ou l'autre des sortilèges opère, la créature meurt et vous pouvez reprendre votre " +
                "carte et continuer à explorer le village.\n" +
                "Si le sortilège échoue ou qu'il ne vous reste plus de sortilèges, la créature va absorber " +
                "vos POINTS DE VIE comme une éponge. Rendez-vous au [14].";
    }

    @Override
    public int getNextChapter() {
        return nextChapter;
    }

    @Override
    public Execution execute(Pip pip) {
        if (pip.canUse(HEP)) {
            use(pip, HEP);
        } else if (pip.canUse(FIP)) {
            use(pip, FIP);
        }
        return super.execute(pip);
    }

    private void use(Pip pip, SpellBook spell) {
        if (pip.use(spell) == FAILURE) {
            this.execute(pip);
        } else {
            pip.addExperiencePoints(1);
            this.nextChapter = 10;
        }
    }
}
