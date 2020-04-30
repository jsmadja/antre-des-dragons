package fr.jsmadja.antredesdragons.stuff;

import fr.jsmadja.antredesdragons.dices.HitRollRange;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Sword {
    private HitRollRange hitRollRange;
    private int damagePoints;
}
