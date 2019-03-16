package fr.jsmadja.antredesdragons;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class AntreDesDragonsTest {

    private AntreDesDragons antre;

    @BeforeEach
    void setUp() {
        antre = new AntreDesDragons();
    }

    @Test
    void should_have_a_pip_character() {
        Pip pip = antre.getPip();
        assertNotNull(pip);
    }
}
