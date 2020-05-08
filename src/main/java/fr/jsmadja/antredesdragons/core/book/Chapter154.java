package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.ManualChoiceChapter;
import fr.jsmadja.antredesdragons.core.entities.Pip;

public class Chapter154 extends ManualChoiceChapter {
    @Override
    public Paths getPossiblesPath(Pip pip) {
        return new Paths(
                Path.builder().description("Lire le parchemin").chapter(170).build(),
                Path.builder().description("Ouvrir le coffre").chapter(156).build()
        );
    }

    @Override
    public String getText() {
        return "Vous descendez prudemment les marches pour déboucher dans une salle de dimension " +
                "moyenne. manifestement créée par l'homme, mais voilà certainement des siècles et, " +
                "semble-t-il abandonnée depuis longtemps. Des lambeaux de porte pourrie sont restés " +
                "accrochés au chambranle. Le plafond disparaît à demi sous les toiles d'araignées. Une " +
                "issue située au nord-est, s'ouvre sur un autre passage, dont le sol descend en pente. " +
                "Mais, entre vous et la sortie, se trouvent des objets d'un intérêt considérable : un coffre " +
                "vétuste, mais bien conservé, et un rouleau de parchemin, plus récent semble-t-il qui a " +
                "roulé jusqu'à l'entrée du passage...\n" +
                "Si vous désirez lire d'abord ce qui peut être écrit sur le parchemin, rendez-vous au [170].\n" +
                "Si vous désirez ouvrir d'abord le coffre, rendez-vous au [156].";
    }
}
