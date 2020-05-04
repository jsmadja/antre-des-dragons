package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.pages.Execution;
import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.pages.GoPage;
import fr.jsmadja.antredesdragons.stuff.Item;

public class Page1 extends GoPage {


    @Override
    public String getText() {
        return "—E. J. ! vous exclamez-vous ! Vous avez gardé E J. !\n" +
                "—Bonjour, Pip, vous dit Excalibur Junior, l'épée parlante.\n\n" +
                "Vous la regardez avec émotion, vous souvenant de l'aide qu'elle vous a apportée tout " +
                "au long de vos aventures dans Le Château des Ténèbres, pour vaincre le redoutable " +
                "Sorcier Ansalom. La présence d'E.J. est vraiment une bonne surprise. Car, grâce à " +
                "cette épée merveilleuse, il vous suffira seulement d'obtenir un 4 en lançant les dés, " +
                "pour porter le premier coup lorsque vous l'utiliserez dans un combat. De plus, lorsque " +
                "vous obtiendrez des Points de Dommage, vous ajouterez 5 points supplémentaires (par " +
                "exemple, si, en lançant les dés vous obtenez 7, les Points de Dommage que vous " +
                "devrez soustraire des POINTS DE VIE de votre adversaire seront de : 7 — 4 = 3, + 5 = " +
                "8). La mauvaise nouvelle , bien sûr, est qu'E.J. parle trop. Mais il va falloir vous en " +
                "accommoder, comme la dernière fois ! Pendant que vous évoquez vos souvenirs avec " +
                "E.J., Merlin sort un autre objet de son coffre : l'élégant pourpoint en peau de dragon " +
                "que vous avez porté durant votre dernière mission, qui a le pouvoir d'annuler 4 Points " +
                "de Dommage chaque fois que vous recevrez un coup. Voilà deux accessoires d'une " +
                "grande importance, qui pourraient faire toute la différence entre la vie et la mort au " +
                "cours de la périlleuse mission dans laquelle vous allez vous engager. Maintenant, " +
                "rendez-vous [3].";
    }

    @Override
    public Execution execute(Pip pip) {
        pip.addAndEquip(Item.EXCALIBUR_JUNIOR);
        return super.execute(pip);
    }

    @Override
    public int getNextPage() {
        return 3;
    }
}
