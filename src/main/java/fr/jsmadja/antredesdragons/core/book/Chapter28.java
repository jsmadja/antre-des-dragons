package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.ChapterNumber;
import fr.jsmadja.antredesdragons.core.chapters.DiceWay;
import fr.jsmadja.antredesdragons.core.chapters.RollAndGoChapter;
import fr.jsmadja.antredesdragons.core.entities.Pip;

import java.util.List;

public class Chapter28 extends RollAndGoChapter {
    @Override
    protected List<DiceWay> getDiceWays(Pip pip) {
        return List.of(
                DiceWay.builder().from(2).to(6).chapterNumber(ChapterNumber.chapter(67)).build(),
                DiceWay.builder().from(7).to(10).chapterNumber(ChapterNumber.chapter(70)).build(),
                DiceWay.builder().from(11).to(12).chapterNumber(ChapterNumber.chapter(75)).build()
        );
    }

    @Override
    public String getText() {
        return "Des poireaux et des laitues en pierre, des choux en pierre, des petits pois en pierre, des " +
                "carottes en pierre, des épinards en pierre, et même des pommes de terre en pierre. Et " +
                "un peu plus loin, vous voyez nettement des fleurs en pierre : des roses, des jacinthes, " +
                "des rhododendrons, du muguet, des boutons d'or et des marguerites. Il doit y avoir une " +
                "belle quantité de chaux dans le sol par ici. Et les statues de monstres n'ont rien de bien " +
                "plaisant. Ce sont de gigantesques créatures aux gueules hérissées de crocs, aux " +
                "poitrines velues, aux pattes griffues. Absolument hideuses à voir. Et qui ont l'air " +
                "vivantes. On s'attend presque d'un instant à l'autre à en voir une remuer. D'ailleurs, il y " +
                "en a une, là-bas, dans le coin, qui semble bouger effectivement. Un effet de la lumière " +
                "sans doute. Le sol n'est pas en pierre. C'est de la terre ordinaire, comme dans un vrai " +
                "jardin. Sauf qu'il y pousse des plantes en pierre. Quel endroit bizarre. Pourquoi " +
                "quelqu'un aurait-il envie de faire pousser des végétaux en pierre et de décorer ensuite " +
                "tout son jardin de statues de monstres? Etes-vous bien sûr que celui-ci n'a pas bougé ? " +
                "Non, il ne peut pas avoir bougé. Vous tirez, à titre d'expérience, sur un chou-fleur en " +
                "pierre, et il s'arrache du sol, racines comprises. Des racines en pierre, bien entendu. " +
                "Plus que bizarre, cet endroit. Avez-vous remarqué comme il fait froid soudain ? " +
                "Le Monstre a bel et bien bougé ! Il se tourne vers vous, bombant sa poitrine velue, " +
                "montrant les crocs ! Rapide comme l'éclair, vous portez la main à votre épée... mais  " +
                "voilà que votre bras vous refuse tout service ! Fuyez, Pip, fuyez ! Vos jambes elles " +
                "aussi sont paralysées. Vous avez froid. Tellement froid ! Vous ne pouvez bouger un " +
                "seul muscle et vous êtes glacé ! Désespérément, vous essayez de prononcer un " +
                "sortilège, mais vos lèvres et votre langue elles-mêmes vous refusent tout service. Vous " +
                "êtes en train de vous transformer en statue de pierre, voilà ce qui vous arrive. Aucun " +
                "doute n'est permis ! Le Monstre n'est plus qu'à quelques mètres de vous. Il ouvre une " +
                "large gueule hérissée de crocs. Au moins, vous pouvez encore lancer les dés. lancez-en " +
                "deux maintenant pour voir si vous pouvez vous sortir de ce guêpier. " +
                "si vous obtenez : \n" +
                "de 2 à 6 : rendez-vous au [67].\n" +
                "de 7 à 10 : rendez-vous au [70].\n" +
                "11 ou 12 : rendez-vous au [75].";
    }
}
