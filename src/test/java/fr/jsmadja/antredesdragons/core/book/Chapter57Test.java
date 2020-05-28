package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.dices.Dice;
import fr.jsmadja.antredesdragons.core.entities.Pip;
import fr.jsmadja.antredesdragons.core.execution.Execution;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static fr.jsmadja.antredesdragons.core.inventory.Item.EXCALIBUR_JUNIOR;

class Chapter57Test {

    @Test
    public void should_multiple_fight() {
        Pip pip = new Pip(new Dice());
        pip.initialize();
        pip.addAndEquip(EXCALIBUR_JUNIOR);

        Chapter57 chapter57 = new Chapter57();
        Execution execution = chapter57.execute(pip);
        Assertions.assertThat(pip.isDead()).isFalse();
        execution.getLogEntries().toList().forEach(System.err::println);
    }

}
