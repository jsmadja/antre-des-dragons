package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.pages.ManualChoicePage;

public class Page126 extends ManualChoicePage {
    @Override
    public Paths getPossiblesPath(Pip pip) {
        return new Paths(
                Path.builder().description("Ouvrir les coffres 1 et 3").page(135).build(),
                Path.builder().description("Ouvrir les coffres 1 et 2").page(140).build(),
                Path.builder().description("Ouvrir les coffres 2 et 3").page(146).build(),
                Path.builder().description("Ouvrir le coffre 1 et la cassette").page(143).build(),
                Path.builder().description("Ouvrir le coffre 2 et la cassette").page(150).build(),
                Path.builder().description("Ouvrir le coffre 3 et la cassette").page(129).build()
        );
    }

    @Override
    public String getText() {
        return "Eh bien voyons, dit le Minotaure un peu essoufflé après le combat, maintenant que " +
                "nous voilà débarrassés de cette formalité, tu ferais bien de farfouiller dans mes " +
                "coffres. Cela fait également partie de la tradition, tu sais. Au Vainqueur les " +
                "Dépouilles comme me disait souvent le jeune Jules César, avant: que ma tête n'ait " +
                "pris son aspect actuel. Nous avons alors cessé de nous parler. Mais que je te " +
                "prévienne tu ne peux ouvrir que deux coffres. Dès que tu l'auras fait, les deux autres " +
                "disparaîtront. Un petit tour de magie que j'ai acheté pour protéger mes biens. " +
                "J'espère que tu apprécieras. L'ennui, c'est que je ne sais pas comment annuler cette " +
                "satanée magie, et que je deviens à moitié fou lorsque je dois chercher quelque chose " +
                "dans ces maudits coffres, qui disparaissent et réapparaissent à tout moment- Enfin " +
                "voyons : nous avons trois coffres, et une cassette, et tu peux ouvrir deux d'entre " +
                "eux. Alors, fais ton choix.\n" +
                "Vous examinez les coffres l'un après l'autre. Tous trois semblent identiques. Quant " +
                "à la cassette, bien que plus petite, elle en est la réplique exacte.\n" +
                "Vous ne pourriez pas me dire simplement ce qu'ils contiennent? demandez-vous " +
                "au Minotaure. Mais il secoue sa grosse tête de taureau.\n" +
                "La tradition, vois-tu... explique-t-il avec tristesse. Comme rien ne distingue un " +
                "coffre de l'autre, vous leur donnez les numéros 1, 2 et 3. Bonne chance !\n" +
                "Si vous ouvrez les coffres 1 et 3, rendez-vous au [135]. " +
                "Si vous ouvrez les coffres 1 et 2, rendez-vous au [140]. " +
                "Si vous ouvrez les coffres 2 et 3, rendez-vous au [146]. " +
                "Si vous ouvrez le coffre 1 et la cassette, rendez-vous au [143]. " +
                "Si vous ouvrez le coffre 2 et la cassette, rendez-vous au [150]. " +
                "Si vous ouvrez le coffre 3 et la cassette, rendez-vous au [129].";
    }
}
