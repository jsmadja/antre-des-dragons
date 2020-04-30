package fr.jsmadja.antredesdragons.pages.content;

import fr.jsmadja.antredesdragons.pages.types.Execution;
import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.pages.types.Page;

public class Page3 extends Page {
    @Override
    public String getText() {
        return "En accomplissant votre quête dans Le Château des Ténèbres, vous avez peut-être " +
                "découvert quelques objets intéressants que vous avez remporté avec vous. Ils peuvent " +
                "faire partie de votre équipement dans cette nouvelle aventure, mais seulement si vous " +
                "les avez vraiment trouvés dans le Château, et s'ils étaient encore en votre possession à " +
                "la fin de votre mission voici la liste des objets qui étaient cachés dans le château. Et ne " +
                "trichez pas, sinon le sortilège sera rompu.\n\n" +
                "1 : La Pierre de Chance. Cette pierre vous permet de rajouter ou de retrancher 3 " +
                "points à tous les résultats que vous obtiendrez en lançant les dés.\n\n" +
                "2 : La Pièce de Cuivre à double face. Une pièce très utile dans les jeux de hasard" +
                ", puisqu’elle permet de tricher comme un fou, et de gagner à tous les coups ! Quant à " +
                "savoir à combien de jeux de hasards vous allez jouer dans cette histoire, c'est une " +
                "autre affaire, mais on ne sait jamais.\n\n" +
                "3 : L'Anneau Sonore du Zombie. Jusqu’ici personne n’a encore très bien compris " +
                "comment fonctionnait l’anneau sonore. Mais son action semble réellement magique " +
                "aussi mieux vaut l'emporter.\n\n" +
                "4 : la Baguette à Bulles du laboratoire d'Ansalom. Elle projete une bulle verte " +
                "lumineuse qui handicape un adversaire à un point tel qu'il est possible de le frapper " +
                "quatre fois avant qu’il ne puisse répliquer. Lancez un dé : le chiffre obtenu sera le " +
                "nombre de bulles dont vous disposerez lors de cette aventure.\n\n" +
                "5 : Le Canard magique donné par Nosférax. Ce petit canard mettra en échec toute " +
                "opération magique tentée contre vous (ou autour de vous) par exemple une boule de feu " +
                "s'éteindra immédiatement ou une créature invisible deviendra visible. Vous ne pourrez " +
                "utiliser le canard qu'une seule fois au cours de la mission.\n\n" +
                "6 : Parchemin de Guérison. Il s'agit d'un sortilège qui, lu a haute voix, vous restituera " +
                "tous vos POINTS DE VIE. Il ne peut être utilisé qu'une seule fois.\n\n" +
                "7 : Parchemin de Téléportage. Un sortilège qui vous emmènera instantanément à n'importe quelle section " +
                "non visitée précédemment (les sections seront expliquées plus loin). Le Parchemin ne peut être utilisé qu'une fois.\n\n" +
                "8 : Parchemin de Mort. Ce Parchemin peut ôter la vie à toute créature, vous compris." +
                "Lorsque vous l'utiliserez, vous lancerez deux dés. Si vous faites un double 6, un " +
                "double 3 ou un double 1, vous êtes mort. Sinon, vous avez tué votre adversaire, aussi " +
                "puissant soit-il. Attention : vous ne pouvez emporter les objets 6, 7 et 8, que si vous ne " +
                "les avez pas utilisés dans Le Château des Ténèbres.\n\n" +
                "9 : Parchemin d'Hypnotisme. Vous devrez obtenir au minimum 5 en lançant deux " +
                "dés, pour que ce sortilege opère. Votre adversaire tombera alors dans une espèce de " +
                "léthargie, et ne présentera plus aucun danger pour vous. Malheureusement, ce sortilège " +
                "n'a aucun pouvoir sur les Dragons.\n\n" +
                "10 : Parchemin d'Antidote au Poison. Peut être utilisé contre tout empoisonnement.\n\n" +
                "11 : La Boule de Cristal du laboratoire d'Ansalom. Elle est maintenant brisée. Vous " +
                "pouvez l'emporter, si vous le désirez, mais elle ne fonctionnera pas.\n\n" +
                "12 : Si vous n'avez pas utilisé tous les Éclairs de Doigt de Feu, ou toutes les " +
                "Boules de Feu dont vous disposiez au cours de votre dernière mission, vous " +
                "pourrez les ajouter à ceux que vous vous procurerez peut-être au cours de cette " +
                "présente mission. Ils opéreront cette fois de façon légèrement différente, " +
                "comme vous le découvrirez.\n\n" +
                "13. Vous pouvez prendre jusqu'à 10 points des points permanents de vie que " +
                "vous avez gagnés au cours de votre mission dans Le Château des Ténèbres, et les " +
                "ajouter à votre total de départ de points de vie. Notez dans la case Équipement de " +
                "votre Feuille d'Aventure ce que vous désirez emporter avec vous, et rendez-vous " +
                "au [4].";
    }

    @Override
    public Execution execute(Pip pip) {
        return pip.goToPage(PageNumber.of(4));
    }
}
