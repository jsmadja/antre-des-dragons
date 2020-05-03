package fr.jsmadja.antredesdragons.stuff;

import fr.jsmadja.antredesdragons.dices.HitRollRange;
import lombok.Getter;

@Getter
public enum Item {
    HORSESHOE("Fer à cheval"),
    GHOST_RING("Anneau du fantôme"),
    FIREBALL("Boule de feu"),
    TINKLE_RING("Anneau tintant"),
    ROPE("Corde"),
    CLEATS("Crampons d'escalade"),
    BACKPACK("Sac à dos"),
    BAG("Sac"),
    CARPENTER_HAMMER("Marteau de charpentier"),
    AXE("Hâche"),
    TORCH("Torches"),
    BOTTLE_OF_WATER("Gourde"),
    TENT("Tente"),
    BLANKET("Couverture"),
    LAMP("Lampe"),
    OIL_CAN("Bidon d'huile"),
    FISHING_HOOKS("Hameçons pour la pêche"),
    HARP("Harpe"),
    LUTH("Luth"),
    HORN("Trompe"),
    BANDAGES("Bandages"),
    KNIFE("Couteau"),
    STONE_LIGHTER("Briquet à pierre"),
    STAKES("Pieux"),
    SPARE_CLOTHES("Vêtements de rechange"),
    SPARE_BOOTS("Bottes de rechange"),
    PARCHMENT("Parchemin"),
    PEN_AND_GOOSE_INK("Plume d'oie et encre en poudre"),
    FOOD("Nourriture"),
    COOKING_TOOLS("Ustensiles de cuisine"),
    HEALING_POTION("Potion curative"),

    THATCHED_CREATURE_DAGGERS("Dagues de créature de chaumière"),

    HATCHET("Hâche d'armes", DamagePoint.damage(4)),
    DAGGER("Poignard", DamagePoint.damage(2)),
    FLAIL("Fléau", DamagePoint.damage(2)),
    MACE("Masse d'armes", DamagePoint.damage(3)),
    CLUB("Massue", DamagePoint.damage(5)),
    SWORD("Epée", DamagePoint.damage(4)),
    EXCALIBUR_JUNIOR("ExcaliburJunior", DamagePoint.damage(5), new HitRollRange(4)),
    TROLL_SWORD("Epée de Troll", DamagePoint.damage(2), new HitRollRange(6)),
    GHOST_SWORD("Epée de Fantôme", DamagePoint.damage(3), new HitRollRange(5)),
    RABBIT_FANGS("Croc de lapon", DamagePoint.damage(3), new HitRollRange(5)),
    MONK_FIGHTING("Poings de moine", DamagePoint.damage(3), new HitRollRange(4)),
    STONEMAN_SWORD("Epée de l'Homme de Pierre", DamagePoint.damage(4), new HitRollRange(8)),
    EXCALIBUR_JUNIOR_DRAGON_SLAYER("ExcaliburJunior (Dragon DMG+10)", DamagePoint.damage(5), new HitRollRange(4)),

    CHAINMAIL("Cotte de mailles", ArmorPoint.armor(3)),
    LEATHER_DOUBLE("Pourpoint en cuir", ArmorPoint.armor(2)),
    ARMOR_PLATE("Plaque d'armure", ArmorPoint.armor(4)),
    TROLL_ARMOR("Armure de Troll", ArmorPoint.armor(1)),
    WOLF_SKIN("Peau de loup", ArmorPoint.armor(1)),
    STONEMONSTER_ARMOR("Armure du monstre de pierre",ArmorPoint.armor(1));

    Item(String name, ArmorPoint armorPoint, DamagePoint damagePoint, boolean equipable, HitRollRange hitRollRange, boolean weapon, boolean armor) {
        this.name = name;
        this.armorPoint = armorPoint;
        this.damagePoint = damagePoint;
        this.equipable = equipable;
        this.hitRollRange = hitRollRange;
        this.weapon = weapon;
        this.armor = armor;
    }

    private final String name;
    private final ArmorPoint armorPoint;
    private final DamagePoint damagePoint;
    private final boolean equipable;
    private final HitRollRange hitRollRange;
    private final boolean weapon;
    private final boolean armor;

    // Object Constructor
    Item(String name) {
        this(name, ArmorPoint.armor(0), DamagePoint.damage(0), false, null, false, false);
    }

    // Weapon Constructor
    Item(String name, DamagePoint damagePoint) {
        this(name, damagePoint, null);
    }

    Item(String name, DamagePoint damagePoint, HitRollRange hitRollRange) {
        this(name, ArmorPoint.armor(0), damagePoint, true, hitRollRange, true, false);
    }

    // Armor Constructor
    Item(String name, ArmorPoint armorPoint) {
        this(name, armorPoint, DamagePoint.damage(0), true, null, false, true);
    }

}
