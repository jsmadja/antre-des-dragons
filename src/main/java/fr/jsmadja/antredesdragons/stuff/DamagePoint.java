package fr.jsmadja.antredesdragons.stuff;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(staticName = "damage")
public class DamagePoint {
    private final int value;
}
