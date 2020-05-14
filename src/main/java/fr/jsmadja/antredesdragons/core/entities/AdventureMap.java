package fr.jsmadja.antredesdragons.core.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum AdventureMap {
    VILLAGE_WEST("Carte Est du Village de la Pierre Qui Mue"),
    VILLAGE_EAST("Carte Ouest du Village de la Pierre Qui Mue"),
    BEGINNER_MAP("Carte du début de l'aventure"),
    PARTIAL_DRAGONS_LAIR_MAP("Carte partielle de l'antre du dragon");
    @Getter
    private String name;
}
