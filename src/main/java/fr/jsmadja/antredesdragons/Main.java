package fr.jsmadja.antredesdragons;

import fr.jsmadja.antredesdragons.book.ChapterNumber;
import fr.jsmadja.antredesdragons.book.Book;
import fr.jsmadja.antredesdragons.dices.Dice;
import fr.jsmadja.antredesdragons.entities.Pip;

public class Main {
    public static void main(String[] args) {
        int startAt = Book.DEBUT;//108;//10;//64;//78;
        Dice dice = new Dice();
        Pip pip = new Pip(dice);
        pip.goToChapter(ChapterNumber.chapter(startAt));
    }
}
