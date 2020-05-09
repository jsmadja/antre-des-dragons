package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.Chapter;
import fr.jsmadja.antredesdragons.core.chapters.Execution;
import fr.jsmadja.antredesdragons.core.entities.Pip;

import static fr.jsmadja.antredesdragons.core.skills.Skill.SWIMMING;

public class Chapter138 extends Chapter {

    @Override
    public String getText() {
        return "Le passage s'élargit brusquement et vous vous retrouvez sur la berge rocheuse d'un " +
                "vaste lac souterrain. Aucun chemin n'apparaît autour de ces eaux sombres, immobiles. " +
                "Mais, amarré à quelques metres de vous, flotte un vieux canot à rames disloqué. " +
                "Si vous avez découvert précédemment au cours de cette aventure que vous savez " +
                "nager, peut-être aurez-vous envie de vous baigner dans ce lac. Rendez-vous " +
                "alors au [123]. Si vous ignorez si vous savez nager, NE prenez pas ce risque. " +
                "Si vous voulez vous hasarder dans le canot qui, manifestement, fait eau, il vous " +
                "emmènera, par UN tunnel, jusqu'au [102].";
    }

    @Override
    public Execution execute(Pip pip) {
        if (pip.hasSkill(SWIMMING)) {
            return pip.goToChapter(123);
        }
        return pip.goToChapter(102);
    }
}
