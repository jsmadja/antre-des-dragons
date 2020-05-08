package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.ManualChoiceChapter;
import fr.jsmadja.antredesdragons.core.entities.Pip;

public class Chapter96 extends ManualChoiceChapter {
    @Override
    public Paths getPossiblesPath(Pip pip) {
        return new Paths(
                Path.builder().description("Lire le parchemin").chapter(101).build(),
                Path.builder().description("Retourner au village").chapter(10).build()
        );
    }

    @Override
    public String getText() {
        return "Non, bien sûr, ce n'est pas lui ! C'est un personnage dont vous vous souvenez, pour " +
                "l'avoir rencontre dans le Château des Ténèbres du Sorcier Ansalom. Lors de votre " +
                "dernière rencontre à la cour du roi Arthur, à Camelot, il arborait sa plus belle tenue et " +
                "les insignes de son rang. Vous vous rappelez sa détermination lorsque, perdu dans les " +
                "bois entourant le Château des Ténèbres, il était résolu à régler son compte au Sorcier, " +
                "si jamais il parvenait a retrouver son chemin. Un homme digne de respect. comme tous " +
                "les vrais rois. Et moins méchant qu'il pouvait le paraître.\n" +
                "Roi Pellinore ? demandez-vous. Est-ce bien vous. Votre Majesté ?\n" +
                "Quoi ? rétorque le personnage en armure noire. Quoi ? Quoi ? Quoi ? Mais, sapristi, je " +
                "vous connais, non ? Le jeune Pip, l'audacieux aventurier, pas moins ! Je ne me trompe " +
                "pas, quoi ?\n" +
                "Oh, intrépide, je ne sais pas trop... répondez-vous modestement.\n" +
                "Sottises ! On parle encore de votre dernier exploit dans tout le pays. Même les " +
                "Ecossais sont au courant. Et vous savez comme ils sont longs à comprendre quoi que " +
                "ce soit. Je ne serais pas surpris que la nouvelle parvienne jusqu'en Hibernia d'ici un an " +
                "ou deux. Eh bien, Pip, qu'est-ce qui vous amène en ce lieu désolé ?\n" +
                "Je suis à la recherche de l'Antre du Dragon, lui répondez-vous. J'ai suivi les indications " +
                "d'une carte que m'a donnée Merlin et elles m'ont conduit ici.\n" +
                "Je ne me fierais pas trop aux cartes de Merlin, fait remarquer Pellinore. Je me guidais " +
                "justement sur une des siennes quand je me suis perdu en cherchant le Sorcier Ansalom.\n" +
                "Vous ne sauriez pas, par hasard, où se trouve " +
                "l'Antre du Dragon ? lui demandez-vous.\n" +
                "Je crains que non, mon jeune ami. A dire vrai, j'ai eu tant de mal à dénicher le moyen " +
                "de sortir d'ici que j ai " +
                "réquisitionné cette demeure pour m'y installer pendant que je mettais au point un " +
                "itinéraire. Mais Je suis quand même tombé sur un objet qui pourrait vous être utile. Et, " +
                "du gantelet de son armure, il retire un rouleau de parchemin. C'est une description de " +
                "l'Antre lui-même, qui pourrait vous rendre de précieux services. Si jamais vous en " +
                "trouvez le chemin. Là-dessus, il vous tend le parchemin. Vous pouvez lire ce qui est " +
                "écrit sur le parchemin en vOUS rendant au [101]. Puis, vous reprenez votre carte du " +
                "village de la Pierre-qui-Mue afin de poursuivre votre exploration";
    }
}
