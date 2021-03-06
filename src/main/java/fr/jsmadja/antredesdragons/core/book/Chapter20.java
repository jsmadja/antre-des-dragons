package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.ManualChoiceChapter;
import fr.jsmadja.antredesdragons.core.entities.Pip;

import java.util.List;

public class Chapter20 extends ManualChoiceChapter {
    @Override
    public String getText() {
        return "Pouah, quelle puanteur ! A en juger par l'odeur vous devez vous trouver dans des " +
                "écuries. Mais elles ne semblent pas avoir servi récemment. Les stalles sont " +
                "démantelées, la paille est pourrie, et de vieux harnais de cuir accrochés à des clous " +
                "fixés aux murs semblent en si piteux état qu'ils se rompraient à coup sûr si vous " +
                "vouliez les passer à un cheval. Heureusement, ce ne sera pas nécessaire puisqu'il n'y a " +
                "pas de chevaux par ici. Si vous désirez fouiller ces écuries, rendez-vous au [71]. " +
                "Sinon, vous reprenez votre carte, et vous choisissez un autre numéro.";
    }

    @Override
    public Paths getPossiblesPath(Pip pip) {
        return new Paths(List.of(
                Path.builder().description("Fouiller les écuries").chapter(71).build(),
                Path.builder().description("Reprendre la carte").chapter(10).build()
        ));
    }
}
