package fr.jsmadja.antredesdragons.core.entities;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class FoeTest {

    @Test
    void isFoe() {
        Foe foe = Foe.builder().build();
        Assertions.assertThat(foe.isFoe()).isTrue();
    }
}
