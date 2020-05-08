package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.Chapter;
import fr.jsmadja.antredesdragons.core.chapters.Execution;
import fr.jsmadja.antredesdragons.core.entities.Pip;
import fr.jsmadja.antredesdragons.core.spellcasting.SpellBook;
import fr.jsmadja.antredesdragons.core.spellcasting.SpellEffectResult;

public class Chapter60 extends Chapter {
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
    public Execution execute(Pip pip) {
        if (pip.canUse(SpellBook.HEP)) {
            return use(pip, SpellBook.HEP);
        }
        if (pip.canUse(SpellBook.FIP)) {
            return use(pip, SpellBook.FIP);
        }
        return pip.goToChapter(14);
    }

    private Execution use(Pip pip, SpellBook spell) {
        if (pip.use(spell) == SpellEffectResult.FAILURE) return execute(pip);
        pip.addExperiencePoints(1);
        return pip.goToChapter(10);
    }
}
