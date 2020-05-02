package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.pages.GoPage;

public class Page95 extends GoPage {
    @Override
    public String getText() {
        return "Derrière vous, le désert volcanique. Devant vous, la gueule béante d'une sombre et " +
                "sinistre caverne. Dans vos narines, l'odeur du Dragon, mêlée à des relents de vapeurs " +
                "sulfureuses et de méthane. A votre main (si vous avez le moindre bon sens) votre " +
                "fidèle épée. Dans votre esprit, la liste de vos sortileges.\n" +
                "Vous touchez au but, Pip. Voilà l'endroit que vous recherchez depuis si longtemps, " +
                "risquant votre vie pour le trouver. S'il y avait des trompettes ici, elles lanceraient vers " +
                "les cieux une triomphante fanfare. mieux vaut, d'ailleurs, qu'il n'en soit rien, car s'il y a " +
                "vraiment une chose dont vous n'avez pas besoin, c est d'une ruée sauvage de Dragons, " +
                "en bronze ou pas, alertés par un brusque appel de trompettes. Vous avancez à pas " +
                "précautionneux, tous les sens en alerte, le cœur battant. Des questions déferlent malgré " +
                "vous dans votre esprit. Le Dragon de Bronze est-il vraiment caché ici ? Merlin en " +
                "semble persuadé, mais il peut se tromper. Combien d'autres Dragons allez-vous " +
                "découvrir? Tout le monde à avalon sait que cette caverne est habitée par un grand  " +
                "nombre de monstres. Que peut recéler d'autre ce labyrinthe de tunnels souterrains, de " +
                "passages, de grottes et de cavernes où vous vous apprêtez à entrer? La légende parle " +
                "de créatures si horribles qu'elles peuvent vivre là sans être molestées par les cracheurs " +
                "de feu, des créatures si terrifiantes que les Dragons eux-mêmes les laissent en paix. De " +
                "quoi glacer le cœur du plus vaillant. C'est pourquoi, Pip, l'intrépidité avec laquelle " +
                "vous avez avancé d'un pas ferme restera éternellement inscrite a votre actif. Rendez-vous au 108.";
    }

    @Override
    protected int getNextPage() {
        return 108;
    }
}
