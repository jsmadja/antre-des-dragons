package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.ManualChoiceChapter;
import fr.jsmadja.antredesdragons.core.entities.Pip;

public class Chapter11 extends ManualChoiceChapter {
    @Override
    public Paths getPossiblesPath(Pip pip) {
        return new Paths(Path.builder().description("Bavarder avec le Lapin Blanc").chapter(6).build(),
                Path.builder().description("S'asseoir sous l'arbre").chapter(46).build());
    }

    @Override
    public String getText() {
        return "Vous êtes arrivé à une clairière. Eh bien, c'est toujours plus agréable que de vous " +
                "frayer un chemin dans les taillis, bien qu'il n'y ait pas grand-chose à voir, ici. La " +
                "clairière elle-même est presque ronde, et elle fait environ six à huit mètres de " +
                "diamètre. En son centre pousse un grand chêne et un lapin assis sur un petit monticule " +
                "à proximité de son terrier, vous considère d'un air soupçonneux. Et c'est à peu près " +
                "tout, à l'exception de quelques campanules qui poussent çà et là. " +
                "Alors, qu'allez-vous faire maintenant ? Vous asseoir sous l'arbre pour " +
                "réfléchir un instant ? Mais attendez donc ! C'est un lapin blanc qui est assis " +
                "là ! Un Lapin Blanc ! Vous savez bien, un Lapin Blanc, comme dans Alice " +
                "au Pays des Merveilles ! Non, ça ne peut pas être ce genre de Lapin Blanc, " +
                "n'est-ce pas ? Mais si, figurez-vous ! C'est très possible ! Vous vivez une " +
                "aventure magique et on ne peut rien trouver de plus magique qu'un Lapin " +
                "Blanc, pas vrai ? Ce terrier de lapin est peut-être l'entrée du Pays des " +
                "Merveilles. Le Sinistre Royaume des Morts est peut-être une autre façon " +
                "d'appeler le Pays des Merveilles ! C'est possible, après tout. Alors, qu'allez-" +
                "vous faire, Pip ?\n" +
                "Si vous voulez essayer de bavarder avec le Lapin, rendez-vous au [6]. Si vous " +
                "préférez vous asseoir sous l'arbre pour réfléchir un instant, rendez-vous au " +
                "[46].";
    }
}
