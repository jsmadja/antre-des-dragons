package fr.jsmadja.antredesdragons.pages.content;

import fr.jsmadja.antredesdragons.pages.types.Execution;
import fr.jsmadja.antredesdragons.dices.DiceWay;
import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.pages.types.Page;

import java.util.Scanner;

public class Page27 extends Page {
    @Override
    public String getText() {
        return "Allez-vous réussir cette descente vertigineuse? La falaise est extrêmement abrupte. " +
                "Et même avec des cordes et des crampons, il faut être un peu inconscient pour s'y " +
                "aventurer. Si vous hésitez, VOUS pouvez retourner immédiatement au [7] pour réfléchir " +
                "de nouveau aux choix qui s'offrent à vous. Mais si vous décidez de tenter l'aventure, " +
                "lancez deux dés.\n" +
                "Si vous faites :\n" +
                "de 2 à 8 : rendez-vous au 49.\n" +
                "de 9 à 12 : rendez-vous au 59.";
    }

    @Override
    public Execution execute(Pip pip) {
        System.out.println("Retourner au 7 ? (O/N)");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("o")) {
            return pip.goToPage(PageNumber.of(7));
        }
        if (answer.equalsIgnoreCase("n")) {
            return pip.rollAndGo(
                    new DiceWay(2, 8, PageNumber.of(49)),
                    new DiceWay(9, 12, PageNumber.of(59))
            );
        }
        return execute(pip);
    }
}
