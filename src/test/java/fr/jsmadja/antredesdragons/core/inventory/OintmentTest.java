package fr.jsmadja.antredesdragons.core.inventory;

import fr.jsmadja.antredesdragons.core.stuff.HealthPoints;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OintmentTest {

    @Test
    public void should_have_5_hp() {
        Ointment ointment = new Ointment();
        assertThat(ointment.isUsable()).isTrue();
        HealthPoints healthPoints = ointment.use();
        assertThat(healthPoints.getHealthPoints()).isEqualTo(5);
        assertThat(ointment.isUsable()).isFalse();
    }

}
