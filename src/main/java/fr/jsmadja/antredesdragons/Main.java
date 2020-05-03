package fr.jsmadja.antredesdragons;

import fr.jsmadja.antredesdragons.book.Pages;
import fr.jsmadja.antredesdragons.dices.Dice;
import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.book.PageNumber;

public class Main {
    public static void main(String[] args) {
        int startAt = Pages.DEBUT;//108;//10;//64;//78;
        Dice dice = new Dice();
        Pip pip = new Pip(dice);
        pip.goToPage(PageNumber.page(startAt));
    }
}
