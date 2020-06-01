package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.ManualChoiceChapter;
import fr.jsmadja.antredesdragons.core.entities.Pip;

public class Chapter22 extends ManualChoiceChapter {
    @Override
    public Paths getPossiblesPath(Pip pip) {
        return new Paths(
                Path.builder().description("Ecouter son conseil").chapter(29).build(),
                Path.builder().description("Poursuivre mon chemin").chapter(19).build()
        );
    }

    @Override
    public String getText() {
        return "— Vous pensez bien que je comprends ça parfaitement. dit le petit homme, nullement " +
                "offensé. Restez tranquillement où vous êtes, et mangez tout à votre aise. Je me " +
                "contenterai de vous tenir compagnie un moment.\n" +
                "Tandis que vous terminez votre repas, l'idée vous vint que le petit homme pourrait " +
                "peut-être vous eclairer sur le mystère qui entoure le village. Aussi, lui demandez-vous " +
                "comment vous y rendre.\n" +
                "— Ce patelin, là-bas? demande-t-il. Je le connais comme ma poche. J'y suis allé " +
                "souvent et j'y ai rencontré des gens parmi les plus aimables, les plus serviables, les " +
                "plus généreux de tout Avalon. Il s'appelle : la Pierre-qui-Mue.\n" +
                "— Voilà des heures que j'avance dans sa direction, et je n'ai pas l'impression de m'en " +
                "approcher.\n" +
                "— Oui, c'est un endroit très difficile à atteindre, acquiesce-t-il. Mais si vous voulez " +
                "mon avis, dirigez-vous donc vers le [29].\n" +
                "Vous pouvez suivre son conseil. Rendez-vous alors au [29].\n" +
                "Mais vous pouvez préférer ne pas en tenir compte, et poursuivre votre chemin. Dans " +
                "ce cas, rendez- vous au [19]. ";
    }
}
