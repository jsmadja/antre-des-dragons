package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.pages.ManualChoicePage;

public class Page140 extends ManualChoicePage {
    @Override
    public Paths getPossiblesPath(Pip pip) {
        return new Paths(
                Path.builder().page(137).build(),
                Path.builder().page(114).build(),
                Path.builder().page(128).build()
        );
    }

    @Override
    public String getText() {
        return "Oh misère. Vous venez d'être mordu par un Serpent qui était enroulé au fond du coffre " +
                "n° 1. (Non, ne prenez pas vos dés, ne vous tordez pas de douleur ce n'est pas tout). " +
                "Heureusement, comme tout excentrique sensé, vous avez ouvert en premier le coffre " +
                "n° 2. A l'intérieur se trouvait un petit flacon portant clairement l'inscription : Antidote " +
                "au venin de Serpent. En toute hâte, vous lampez cet antidote (qui a un goût infect) et, " +
                "en quelques instants, vous vous sentez beaucoup mieux. Le [14] avec ses perspectives " +
                "fatales s'efface à l'horizon. Comme le Minotaure l'avait prédit, les autres coffres et la " +
                "cassette ont disparu. Rien d'autre à faire que de partir.\n" +
                "les passages qui permettent de sortir de la grotte du Minotaure conduisent au [137], au " +
                "[114] et au [128]. Faites votre choix !";
    }
}
