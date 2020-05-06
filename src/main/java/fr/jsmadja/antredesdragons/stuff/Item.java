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
    PARTIAL_MAP_OF_THE_DRAGONS_LAIR("Carte partielle de l'antre du dragon"),
    NOSFERAX_SNUFFBOX("Tabatière de Nosferax"),
    NOSFERAX_LOLLIPOP("Sucette de Nosferax"),
    MINOTAUR_MAGICAL_LOCKED_SMALL_CHEST("Cassette du Minotaure à ouvrir après avoir vu Merlin (chapitre 143)"),
    MINOTAUR_KEY("Clef"),
    MAGIC_WAND("Baguette Magique"),
    FINGER_OF_FIRE("Doigt de Feu"),

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
    RAT_TEETH("Dents de Rat-Loup", DamagePoint.damage(2), new HitRollRange(5), true),
    DWARF_SWORD("Epée de Nain", DamagePoint.damage(3), new HitRollRange(8)),
    MEDUSA_WEAPON("Coups de Méduse", DamagePoint.damage(0), new HitRollRange(8)),
    MONSTER_CLAW("Griffes de monstres", DamagePoint.damage(2), new HitRollRange(5)),
    DRAGON_FANG("Griffe de Dragon de Bronze", DamagePoint.damage(5), new HitRollRange(5)),
    DRAGON_BLOW("Souffle du Dragon de Bronze", DamagePoint.damage(10), new HitRollRange(5)),
    RAMPANT_TONGUE("Langue de Rampant", DamagePoint.damage(0), new HitRollRange(8)),

    CHAINMAIL("Cotte de mailles", ArmorPoint.armor(3)),
    LEATHER_DOUBLE("Pourpoint en cuir", ArmorPoint.armor(2)),
    ARMOR_PLATE("Plaque d'armure", ArmorPoint.armor(4)),
    TROLL_ARMOR("Armure de Troll", ArmorPoint.armor(1)),
    WOLF_SKIN("Peau de loup", ArmorPoint.armor(1)),
    STONEMONSTER_ARMOR("Armure du monstre de pierre", ArmorPoint.armor(1));

    Item(String name, ArmorPoint armorPoint, DamagePoint damagePoint, boolean equipable, HitRollRange hitRollRange, boolean weapon, boolean armor, boolean poisoned) {
        this.name = name;
        this.armorPoint = armorPoint;
        this.damagePoint = damagePoint;
        this.equipable = equipable;
        this.hitRollRange = hitRollRange;
        this.weapon = weapon;
        this.armor = armor;
        this.poisoned = poisoned;
    }

    private final String name;
    private final ArmorPoint armorPoint;
    private final DamagePoint damagePoint;
    private final boolean equipable;
    private final HitRollRange hitRollRange;
    private final boolean weapon;
    private final boolean armor;
    private final boolean poisoned;

    // Object Constructor
    Item(String name) {
        this(name, ArmorPoint.armor(0), DamagePoint.damage(0), false, null, false, false, false);
    }

    // Weapon Constructor
    Item(String name, DamagePoint damagePoint) {
        this(name, damagePoint, null, false);
    }

    Item(String name, DamagePoint damagePoint, HitRollRange hitRollRange) {
        this(name, ArmorPoint.armor(0), damagePoint, true, hitRollRange, true, false, false);
    }

    Item(String name, DamagePoint damagePoint, HitRollRange hitRollRange, boolean poisoned) {
        this(name, ArmorPoint.armor(0), damagePoint, true, hitRollRange, true, false, poisoned);
    }

    // Armor Constructor
    Item(String name, ArmorPoint armorPoint) {
        this(name, armorPoint, DamagePoint.damage(0), true, null, false, true, false);
    }

}
