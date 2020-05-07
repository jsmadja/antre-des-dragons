package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.dices.Roll;
import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.chapters.DeadlyChapter;
import fr.jsmadja.antredesdragons.chapters.Execution;

public class Chapter26 extends DeadlyChapter {
    @Override
    public String getText() {
        return "Vous venez d'être empoisonné. Ce petit monstre féroce avait des crocs venimeux. " +
                "Quel désastre lancez vite deux dés. " +
                "Si vous faites :\n" +
                "de 2 à 4 : rendez-vous au redoutable [14].\n" +
                "de 5 à 8 : vous êtes naturellement immunisé contre le poison. Revenez au [6], et " +
                "poursuivez le combat.\n" +
                "9 : le Lapin Blanc meurt d'une allergie brutale pour vous avoir trop mordu. Rendez-vous au 6, et voyez ce que vous devez faire, maintenant que vous êtes débarrassé de " +
                "ce maudit rongeur.\n" +
                "de 10 à 12 : vous avez perdu la moitié de vos POINTS DE VIE, et la faiblesse qui " +
                "vous gagne vous fait perdre connaissance. Lorsque vous revenez à vous, vous " +
                "constatez que le Lapin Blanc a réussi (et vous vous demandez bien comment) à vous " +
                "traîner jusque dans les bois, où il a dû disparaître. Rendez-vous au [5].";
    }

    @Override
    public Execution execute(Pip pip) {
        Roll roll = pip.roll2Dices();
        if (roll.isBetween(2, 4)) {
            return super.execute(pip);
        }
        if (roll.isBetween(5, 8)) {
            return pip.goToChapter(6);
        }
        if (roll.is(9)) {
            return pip.goToChapter(6);
        }
        if (roll.isBetween(10, 12)) {
            pip.wounds(pip.getCurrentHealthPoints() / 2);
            return pip.goToChapter(5);
        }
        return super.execute(pip);
    }
}
