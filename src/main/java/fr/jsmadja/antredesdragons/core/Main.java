package fr.jsmadja.antredesdragons.core;

import fr.jsmadja.antredesdragons.core.book.Book;
import fr.jsmadja.antredesdragons.core.chapters.ChapterNumber;
import fr.jsmadja.antredesdragons.core.dices.Dice;
import fr.jsmadja.antredesdragons.core.entities.Pip;

public class Main {
    public static void main(String[] args) {
        int startAt = Book.DEBUT;//108;//10;//64;//78;
        Dice dice = new Dice();
        Pip pip = new Pip(dice);
        pip.goTo(ChapterNumber.chapter(startAt));
    }
}
