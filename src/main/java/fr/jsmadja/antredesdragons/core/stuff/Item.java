package fr.jsmadja.antredesdragons.core.stuff;

import fr.jsmadja.antredesdragons.core.dices.HitRollRange;
import lombok.Getter;

import static fr.jsmadja.antredesdragons.core.stuff.ArmorPoint.armor;
import static fr.jsmadja.antredesdragons.core.stuff.DamagePoint.damage;

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
    // NOSFERAX_LOLLIPOP("Sucette de Nosferax"),
    MINOTAUR_MAGICAL_LOCKED_SMALL_CHEST("Cassette du Minotaure à ouvrir après avoir vu Merlin (chapitre 143)"),
    MINOTAUR_KEY("Clef"),
    MAGIC_WAND("Baguette Magique"),
    FINGER_OF_FIRE("Doigt de Feu"),

    THATCHED_CREATURE_DAGGERS("Dagues de créature de chaumière"),

    HATCHET("Hâche d'armes", damage(4)),
    DAGGER("Poignard", damage(2)),
    FLAIL("Fléau", damage(2)),
    MACE("Masse d'armes", damage(3)),
    CLUB("Massue", damage(5)),
    SWORD("Epée", damage(4)),
    EXCALIBUR_JUNIOR("ExcaliburJunior", damage(5), new HitRollRange(4)),
    TROLL_SWORD("Epée de Troll", damage(2), new HitRollRange(6)),
    GHOST_SWORD("Epée de Fantôme", damage(3), new HitRollRange(5)),
    RABBIT_FANGS("Croc de lapon", damage(3), new HitRollRange(5)),
    MONK_FIGHTING("Poings de moine", damage(3), new HitRollRange(4)),
    STONEMAN_SWORD("Epée de l'Homme de Pierre", damage(4), new HitRollRange(8)),
    EXCALIBUR_JUNIOR_DRAGON_SLAYER("ExcaliburJunior (Dragon DMG+10)", damage(5), new HitRollRange(4)),
    RAT_TEETH("Dents de Rat-Loup", damage(2), new HitRollRange(5), true),
    DWARF_SWORD("Epée de Nain", damage(3), new HitRollRange(8)),
    MEDUSA_WEAPON("Coups de Méduse", damage(0), new HitRollRange(8)),
    MONSTER_CLAW("Griffes de monstres", damage(2), new HitRollRange(5)),
    DRAGON_FANG("Griffe de Dragon de Bronze", damage(5), new HitRollRange(5)),
    DRAGON_BLOW("Souffle du Dragon de Bronze", damage(10), new HitRollRange(5)),
    RAMPANT_TONGUE("Langue de Rampant", damage(0), new HitRollRange(8)),
    BLACK_KNIGHT_SPEAR("Lance du Chevalier Noir", damage(10)),
    CANTERBURY_SPEAR("Lance de Canterbury", damage(12), true),
    OGRE_CLUB("Massue d'ogre", damage(15)),

    CHAINMAIL("Cotte de mailles", armor(3)),
    LEATHER_DOUBLE("Pourpoint en cuir", armor(2)),
    ARMOR_PLATE("Plaque d'armure", armor(4)),
    TROLL_ARMOR("Armure de Troll", armor(1)),
    WOLF_SKIN("Peau de loup", armor(1)),
    STONEMONSTER_ARMOR("Armure du monstre de pierre", armor(1)),
    DREAM_ARMOR("Armure de rêve", armor(5), true),
    BLACK_KNIGHT_ARMOR("Armure du Chevalier Noir", armor(6));

    private final boolean dreamItem;

    private final String name;
    private final ArmorPoint armorPoint;
    private final DamagePoint damagePoint;
    private final boolean equipable;
    private final HitRollRange hitRollRange;
    private final boolean weapon;
    private final boolean armor;
    private final boolean poisoned;

    Item(String name, ArmorPoint armorPoint, DamagePoint damagePoint, boolean equipable, HitRollRange hitRollRange, boolean weapon, boolean armor, boolean poisoned, boolean dreamItem) {
        this.name = name;
        this.armorPoint = armorPoint;
        this.damagePoint = damagePoint;
        this.equipable = equipable;
        this.hitRollRange = hitRollRange;
        this.weapon = weapon;
        this.armor = armor;
        this.poisoned = poisoned;
        this.dreamItem = dreamItem;
    }

    // Object Constructor
    Item(String name) {
        this(name, armor(0), damage(0), false, null, false, false, false, false);
    }

    // Weapon Constructor
    Item(String name, DamagePoint damagePoint) {
        this(name, damagePoint, null, false);
    }

    Item(String name, DamagePoint damagePoint, HitRollRange hitRollRange) {
        this(name, armor(0), damagePoint, true, hitRollRange, true, false, false, false);
    }

    Item(String name, DamagePoint damagePoint, HitRollRange hitRollRange, boolean poisoned) {
        this(name, armor(0), damagePoint, true, hitRollRange, true, false, poisoned, false);
    }

    Item(String name, DamagePoint damagePoint, boolean dreamItem) {
        this(name, armor(0), damagePoint, true, null, true, false, false, dreamItem);
    }

    // Armor Constructor
    Item(String name, ArmorPoint armorPoint) {
        this(name, armorPoint, false);
    }

    Item(String name, ArmorPoint armorPoint, boolean dreamItem) {
        this(name, armorPoint, damage(0), true, null, false, true, false, dreamItem);
    }
}
