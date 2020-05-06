package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.pages.Execution;
import fr.jsmadja.antredesdragons.pages.Page;
import fr.jsmadja.antredesdragons.spellcasting.SpellBook;

import static fr.jsmadja.antredesdragons.spellcasting.SpellBook.FIP;
import static fr.jsmadja.antredesdragons.spellcasting.SpellBook.HEP;
import static fr.jsmadja.antredesdragons.spellcasting.SpellEffectResult.FAILURE;

public class Page60 extends Page {
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
        if (pip.canUse(HEP)) {
            return use(pip, HEP);
        }
        if (pip.canUse(FIP)) {
            return use(pip, FIP);
        }
        return pip.goToPage(14);
    }

    private Execution use(Pip pip, SpellBook spell) {
        if (pip.use(spell) == FAILURE) return execute(pip);
        pip.addExperiencePoints(1);
        return pip.goToPage(10);
    }
}
