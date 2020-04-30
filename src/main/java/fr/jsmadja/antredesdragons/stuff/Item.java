package fr.jsmadja.antredesdragons.stuff;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Item {
    FER_A_CHEVAL("Fer à cheval"),
    GHOST_RING("Anneau du fantôme"),
    FIREBALL("Boule de feu");

    private String name;
}
