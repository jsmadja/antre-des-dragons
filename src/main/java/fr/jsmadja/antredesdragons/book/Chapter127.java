package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.chapters.GoNextChapter;
import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.stuff.NosferaxLollipop;

public class Chapter127 extends GoNextChapter {
    @Override
    public int getNextChapter() {
        return 10;
    }

    @Override
    protected void beforeLeavingChapter(Pip pip) {
        pip.add(new NosferaxLollipop());
        super.beforeLeavingChapter(pip);
    }

    @Override
    public String getText() {
        return "Quel beau travail ! s'exclame Nosférax le Poète. Quel remarquable effort ! Presque " +
                "digne, à certains égards, de mes premières œuvres, si prometteuses. Cela me rappelle " +
                "en un sens T.S. Eliot dans sa Période Bleue, ou était-ce Picasso? Peu importe. C'est un " +
                "effort admirable et qui mérite une récompense, bien que vous n'ayez pas élucidé " +
                "l'énigme. Et, plongeant une main dans une poche de sa cape d'opéra, il en sort une " +
                "sorte de bonbon au bout d'un bâtonnet.\n" +
                "Voici une sucette.\n" +
                "Une sucette ? demandez-vous, surpris et peut-être même un peu déçu, à dire vrai.\n" +
                "Une sucette magique, précise Nosférax. découvrant ses crocs brillants en un large " +
                "sourire Sucez-la et vous verrez, mais pas tout de suite. Pour ne pas la gaspiller. Vous " +
                "ne pouvez la lécher que trois fois avant qu'elle ne disparaisse. Mais chaque fois que " +
                "vous la lécherez au cours d'un combat ou d'un affrontement quelconque, tous les " +
                "POINTS DE VIE que vous auriez pu perdre vous seront rendus, jusqu'à concurrence " +
                "de votre total de départ, tandis que le même nombre de POINTS DE VIE sera déduit " +
                "de ceux de votre adversaire. Un peu difficile à calculer, mais extrêmement utile, si " +
                "jamais vous êtes en mauvaise posture... Et maintenant (il entreprend de retourner dans " +
                "son cercueil) il me faut malheureusement vous quitter, si plaisante qu'ait été cette " +
                "conversation. Et, là-dessus, il rabat le couvercle. Vous frappez dessus un petit coup " +
                "discret, mais vous n'obtenez qu'une réponse assourdie : \n" +
                "Adieu, mon jeune ami Espérons que n'est pas finie La Quête que tu " +
                "entrepris Car toi, mon hôte, En dépit du courroux des autres, Tu " +
                "mérites cent fois d'accéder A l'Antre du Dragon.\n" +
                "Reprenez la carte du village de la Pierre-qui-Mue, et explorez une autre partie.";
    }
}
