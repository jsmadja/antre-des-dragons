package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.GoNextChapter;
import fr.jsmadja.antredesdragons.core.entities.Pip;
import fr.jsmadja.antredesdragons.core.inventory.NosferaxSnuffBox;

public class Chapter122 extends GoNextChapter {
    @Override
    public String getText() {
        return "Aussitôt le couvercle du cercueil se rabat et une mince silhouette d'une mortelle pâleur " +
                "en tenue de soirée et longue cape noire en bondit avec une effrayante célérité. Cette " +
                "créature a des yeux roses et ses canines supérieures chevauchent sa lèvre inférieure, " +
                "même lorsqu'elle sourit, ce qui est le cas en ce moment.\n" +
                "Bien joué, mon cher et courageux visiteur ! Bien joué ! Je n'aurais pas mieux résolu " +
                "moi-même cette énigme. Si ce n'est en vers, bien entendu. Quelque chose dans le genre " +
                ":\n" +
                "Telle était la question du Sphinx : Quelle est la différence entre un canard ? " +
                "Enigme, semble-t-il, sans fard. Favori de la chance. Les yeux plantés dans " +
                "ceux du Sphinx, Je lui déclare plein d'assurance : L'une de ses pattes se " +
                "ressemble.\n" +
                "Voilà, dit Nosférax, les yeux brillants. Qu'est-ce que vous pensez de ça comme " +
                "réponse poétique ?\n" +
                "Superbe ! répondez-vous, vous rappelant que Nosférax aime entendre vanter ses vers. " +
                "Les allusions mythologiques me semblent tout à fait appropriées.\n" +
                "Oui, dit Nosférax, visiblement ravi. C'est aussi mon avis. Maintenant, comme vous " +
                "êtes de toute évidence un jeune homme plein de goût et de discernement, permettez-moi de vous récompenser de votre intelligence.\n" +
                "Là-dessus, il sort de la poche de son frac une petite tabatière en argent.\n" +
                "Vous prisez ? demande-t-il. Vous secouez la tête. Tant mieux, approuve Nosférax.\n" +
                "Une manie répugnante et très mauvaise pour la santé. Vous pouvez néanmoins faire " +
                "exception avec ce mélange. Ce n'est pas du tabac, en fait, mais de l'armoise pilée, et " +
                "bénie par un vicaire de confession anglicane. Elle est douée de propriétés curatives " +
                "exceptionnelles. Prisez une pincée lorsque vous vous sentez affaibli et lancez les deux " +
                "dés deux fois. Le total obtenu indique le nombre de POINTS DE VIE qui vous sont " +
                "restitués. Mais contentez-vous d'une seule prise au cours d'un paragraphe, sinon vous " +
                "serez expédié directement au [14]. Compris ? Très bien. Maintenant en route, audacieux " +
                "aventurier, car il fait froid et je dois retourner dans mon cercueil avant d'attraper un " +
                "rhume et de me mettre à éternuer.\n" +
                "Ei il referme son couvercle d'un coup sec vous laissant la tabatière pleine de mélange " +
                "curatif entre les mains.\n" +
                "Reprenez la carte du village de la Pierre-qui-Mue et poursuivez votre exploration. Et ne " +
                "perdez pas cette tabatière.";
    }

    @Override
    protected void beforeLeavingChapter(Pip pip) {
        pip.add(new NosferaxSnuffBox(pip));
        super.beforeLeavingChapter(pip);
    }

    @Override
    public int getNextChapter() {
        return 10;
    }
}
