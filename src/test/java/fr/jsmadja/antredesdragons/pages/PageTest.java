package fr.jsmadja.antredesdragons.pages;

import fr.jsmadja.antredesdragons.pages.types.Execution;
import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.pages.types.ManualChoicePage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ManualChoicePageTest {

    @Test
    void isValidAnswer() {
        ManualChoicePage page = new ManualChoicePage() {
            @Override
            public String getText() {
                return "";
            }

            @Override
            public Execution execute(Pip pip) {
                return Execution.empty();
            }

            @Override
            public Paths getPossiblesPath() {
                return new Paths(
                        Path.builder().page(1).build(),
                        Path.builder().page(2).build(),
                        Path.builder().page(3).build());
            }
        };
        assertEquals(page.isValidAnswer(1), true);
        assertEquals(page.isValidAnswer(2), true);
        assertEquals(page.isValidAnswer(3), true);
        assertEquals(page.isValidAnswer(4), false);
    }
}
