package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.chapters.ManualChoiceChapter;

public class Chapter112 extends ManualChoiceChapter {
    @Override
    public Paths getPossiblesPath(Pip pip) {
        return new Paths(
                Path.builder().description("Nager").chapter(123).build(),
                Path.builder().description("Prendre le canot").chapter(147).build()
        );
    }

    @Override
    public String getText() {
        return "Le passage s'élargit brusquement et vous vous retrouvez sur la berge rocheuse d'un " +
                "vaste lac souterrain. Aucun chemin n'apparaît autour de ces eau. sombres, immobiles. " +
                "Mais, amarré à quelques mètres de vous, flotte un vieux canot à rames disloqué. Si " +
                "vous avez découvert précédemment au cours, de cette aventure que vous saviez nager,  " +
                "peut-être aurez-vous envie de vous baigner dans ce lac (Si vous ignorez si vous savez " +
                "nager, ne prenez pas ce risque.)\n" +
                "Si vous voulez nager, rendez-vous au [123].\n" +
                "Si vous préférez vous hasarder dans le canot, qui fait eau manifestement, rendez-vous au [147].";
    }
}
