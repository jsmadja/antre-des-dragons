package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.pages.DiceWay;
import fr.jsmadja.antredesdragons.pages.RollAndGoPage;

import java.util.List;

public class Page160 extends RollAndGoPage {
    @Override
    protected List<DiceWay> getDiceWays(Pip pip) {
        return List.of(
                DiceWay.builder().from(1).to(9).pageNumber(PageNumber.page(163)).build(),
                DiceWay.builder().from(10).to(12).pageNumber(PageNumber.page(166)).build()
        );
    }

    @Override
    public String getText() {
        return "Vous armant de tout votre courage, vous faites quelques pas, et vous pénétrez dans la " +
                "plus étrange des cavernes que vous ayez visitées jusqu'alors. D'extraordinaires " +
                "structures cristallines incrustées dans toute la surface de ses parois scintillent doucement à la lumière de votre torche, projetant des ombres aux reflets de saphir et " +
                "d'émeraude ondulant comme des flammes magiques. L'espace est immense, et le sol " +
                "descend en une série de gradins de faible hauteur, tel un escalier construit pour le plus " +
                "gigantesque des géants. Le dernier des gradins s'incurve vers le nord, se rétrécissant en " +
                "une espèce d'entonnoir dont l'extrémité s'élève brusquement, pour former une " +
                "cheminée débouchant certainement à l’air libre. Et toute l'atmosphère de ce lieu " +
                "sinistre est imprégnée d'une âcre puanteur qui vous suffoque à demi.\n" +
                "Soudain, une flamme jaillit, qui illumine l'espace d'un instant l'ensemble de la " +
                "caverne. Le spectacle qui s'est offert à vous durant ces quelques secondes vous glace " +
                "le sang : la caverne grouille de Dragons ! il y en a partout : des douzaines, des " +
                "centaines, nichés dans les anfractuosités, perchés sur des corniches rocheuses audessus de votre tête, plaqués aux parois irrégulières, tels des chauves-souris de cauchemar. Et leurs yeux rouges surveillent le moindre de vos mouvements. Même " +
                "l'Ordre des Chevaliers de la Table Ronde au complet ne pourrait venir à bout de cette " +
                "engeance monstrueuse. Même les puissants pouvoirs magiques que recèle le Globe " +
                "pour lequel vous avez risqué votre vie ne suffiraient sans doute pas à les tenir en " +
                "respect. Votre instinct vous crie de vous enfuir... mais la fuite est impossible ! Car " +
                "devant vous, sur la marche la plus basse, accroupi lourdement à côté d'une boule de " +
                "cristal rouge sang coiffant une colonne de marbre, gigantesque, impassible, se trouve " +
                "le monstre que vous avez pour mission de tuer. LE DRAGON DE BRONZE ! Il lève " +
                "ses yeux d'ambre étincelants et vous fixe jusqu'au tréfonds de l'âme. Sssss ! Une petite " +
                "langue de feu bleu-vert jaillit de sa gueule. Au même moment, des mots résonnent " +
                "silencieusement en vous.\n" +
                "Sois le bienvenu, Pip, aventurier et fidèle serviteur de l'Enchanteur Merlin !\n" +
                "Vous ressentez un coup au cœur. C'est de la télépathie ! Un dragon télépathe ! Aucun " +
                "texte n'a jamais fait mention de cela !\n" +
                "Ce n'est pas le Dragon, Pip. C'est moi qui te parle. D'esprit à esprit.\n" +
                "Stupéfait, vous jetez des regards affolés de tous côtés. Et, oubliant la multitude des " +
                "Dragons qui vous entourent, vous hurlez :\n" +
                "• Qui êtes vous ? Où êtes-vous ?\n" +
                "Je suis Ethelbert, Moine Guerrier, Pip, un aventurier tout comme toi, mais en proie à " +
                "la mauvaise fortune. Quant au lieu où je me trouve, la volonté divine a permis à ce " +
                "monstre infernal de se livrer à une étrange opération magique par laquelle il a " +
                "emprisonné mon âme dans cette infâme boule de cristal placée sur ce piedestal devant " +
                "toi. Je suis condamné à y demeurer à jamais, à moins que tu n'aies la force d'égorger " +
                "cette bête répugnante et de fracasser le cristal pour me délivrer.\n" +
                "Mais comment m'y prendre pour tuer le Dragon de Bronze ? demandez-vous avec " +
                "angoisse car en vérité, le peu d'assurance qui vous animait tend à vous abandonner. " +
                "Grâce à la magie, valeureux Pip ! La magie et la robustesse de tes bras. D'étranges " +
                "forces se sont répandues dans Avalon depuis que les Portes du sinistre Royaume des " +
                "Morts ont été ouvertes par ce monstre. Mais j'ai toute confiance en toi, Pip. Espère " +
                "en Dieu et frappe résolument à la tête quand tu affronteras la bête immonde. Mais, " +
                "pour commencer, tu dois te mesurer aux Dragons de moindre importance. Puisse ton " +
                "Globe mystique te protéger.\n" +
                "Et il a raison, vous savez, Pip. Avant de courir le risque de vous faire tuer par le " +
                "Dragon de Bronze, il va falloir venir à bout de ces centaines de Dragons qui vous " +
                "entourent. Alors lancez les dés, et tout de suite, avant que vos nerfs ne vous " +
                "trahissent.\n" +
                "Si vous faites :\n" +
                "de 1 à 9 : rendez-vous au [163].\n" +
                "de 10 à 12 : rendez-vous au [166]";
    }
}
