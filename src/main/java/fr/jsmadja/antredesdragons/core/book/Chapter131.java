package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.MultipleFightChapter;
import fr.jsmadja.antredesdragons.core.dices.Roll;
import fr.jsmadja.antredesdragons.core.entities.Foe;
import fr.jsmadja.antredesdragons.core.entities.Pip;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Chapter131 extends MultipleFightChapter {
    @Override
    protected int getSuccessChapter() {
        return 134;
    }

    @Override
    protected List<Foe> createFoes(Pip pip) {
        Roll roll = pip.roll2Dices();
        return IntStream.range(1, 13)
                .mapToObj(i -> getFoeFactory().createDwarf(roll, i))
                .collect(toList());
    }

    @Override
    public int getRequiredDeadFoesSize(Pip pip) {
        return 10;
    }

    @Override
    public String getText() {
        return "Chacun de ces affreux Nains possède 10 POINTS DE VIE. Ils se déplacent avec une " +
                "telle lenteur, que vous pouvez avoir, à coup sûr, l'initiative de l'attaque. Lancez deux " +
                "dés pour savoir combien de Nains vous pourrez frapper avant qu'ils ne ripostent. (Si " +
                "vous faites un double 6, cela signifie que vous pouvez tous les frapper.) Lorsque vous " +
                "aurez porté votre premier coup, les Nains répliqueront à tour de rôle. Ils ne sont guère " +
                "doués pour le combat, et il leur faut au minimum un 8 pour vous atteindre. En " +
                "revanche, ils sont armés de redoutables épées qui infligent 3 Points de Dommage " +
                "supplémentaires.\n" +
                "Si les Nains vous font passer de vie à trépas, on vous attend au [14].\n" +
                "Si vous réussissez à vous débarasser de dix d'entre eux, les deux autres s'enfuiront en " +
                "direction de la grotte du Minotaure, vous laissant libre d'agir à votre guise dans cette " +
                "caverne. Rendez-vous alors au [134].";
    }
}
