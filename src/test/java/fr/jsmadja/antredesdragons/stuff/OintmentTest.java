package fr.jsmadja.antredesdragons.stuff;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OintmentTest {

    @Test
    public void should_have_5_hp() {
        Ointment ointment = new Ointment();
        assertThat(ointment.isUsable()).isTrue();
        HealthPoints healthPoints = ointment.use();
        assertThat(healthPoints.getValue()).isEqualTo(5);
        assertThat(ointment.isUsable()).isFalse();
    }

}
