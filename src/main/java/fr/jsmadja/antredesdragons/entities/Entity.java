package fr.jsmadja.antredesdragons.entities;

import fr.jsmadja.antredesdragons.dices.Dice;
import fr.jsmadja.antredesdragons.dices.HitRollRange;
import fr.jsmadja.antredesdragons.dices.Roll;
import fr.jsmadja.antredesdragons.fight.Attack;
import fr.jsmadja.antredesdragons.skills.SpecialSkill;
import fr.jsmadja.antredesdragons.spellcasting.SpellBook;
import fr.jsmadja.antredesdragons.stuff.ArmorPoint;
import fr.jsmadja.antredesdragons.stuff.DamagePoint;
import fr.jsmadja.antredesdragons.stuff.Item;
import fr.jsmadja.antredesdragons.ui.Events;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static fr.jsmadja.antredesdragons.fight.Attack.Status.MISSED;
import static fr.jsmadja.antredesdragons.fight.Attack.Status.TOUCHED;
import static java.lang.Integer.MAX_VALUE;
import static java.text.MessageFormat.format;

public abstract class Entity {
    @Getter
    private final String name;

    private final Dice dice;

    @Setter
    @Getter
    private int initialHealthPoints;

    private int currentHealthPoints;
    @Getter
    @Setter
    private int maximumHealthPoints;

    private HitRollRange hitRollRange = new HitRollRange(6);
    @Setter
    private HitRollRange forcedMinimumHitRoll;
    private final Integer constantHitDamage;
    private final boolean immuneToPhysicalDamages;

    @Getter
    @Setter
    private boolean immuneToPoison;

    @Getter
    @Setter
    private boolean ableToStrikeTwice;

    @Getter
    private ArmorPoint magicArmorPoints = ArmorPoint.armor(0);

    @Getter
    private DamagePoint magicDamagePoints = DamagePoint.damage(0);

    @Getter
    private final Inventory inventory = new Inventory();

    @Getter
    private boolean loseInitiative;

    @Setter
    private int rollMalus;

    public static final HitRollRange DEFAULT_MINIMUM_HIT_ROLL = new HitRollRange(6, 12);

    @Getter
    private DamagePoint temporaryDamagePointsMalus = DamagePoint.damage(0);

    @Getter
    @Setter
    private boolean poisoned;

    @Getter
    @Setter
    private boolean invisible;

    @Getter
    private final int requiredStrikesToHitInvisible;

    @Getter
    private int strikes;

    @Setter
    @Getter
    private int strikesInARow;

    @Setter
    private Roll invisibleRequiredMinimumHitRoll;
    @Setter
    @Getter
    private int missMalusCount;

    @Getter
    private List<SpellBook> spellsToCastDuringFight = new ArrayList<>();

    @Getter
    private List<SpecialSkill> specialSkills = new ArrayList<>();

    Entity(String name, Dice dice, int initialHealthPoints, HitRollRange hitRollRange, Integer constantHitDamage, boolean immuneToPhysicalDamages, Integer requiredStrikesToHitInvisible) {
        this.name = name;
        this.dice = dice;
        if (hitRollRange != null) {
            this.hitRollRange = hitRollRange;
        }
        this.initialHealthPoints = this.currentHealthPoints = initialHealthPoints;
        this.constantHitDamage = constantHitDamage;
        this.immuneToPhysicalDamages = immuneToPhysicalDamages;
        this.maximumHealthPoints = this.initialHealthPoints;
        this.requiredStrikesToHitInvisible = requiredStrikesToHitInvisible == null ? MAX_VALUE : requiredStrikesToHitInvisible;
    }

    public abstract boolean isFoe();

    public void restoreHealthPoints(int restoredHealthPoints) {
        this.currentHealthPoints = Math.min(this.currentHealthPoints + restoredHealthPoints, this.maximumHealthPoints);
    }

    public void restoreAllHealthPoints() {
        this.restoreHealthPoints(this.maximumHealthPoints);
    }

    @Override
    public String toString() {
        return format("{0} ~ HP: {1}/{5}, STR: {2}, TCH: {3}, ARMOR: {4}", this.name, this.currentHealthPoints, this.getAdditionalDamagePoints(), this.hitRollRange.getMin(), this.getArmorPoints(), this.getMaximumHealthPoints());
    }

    // Rolling
    public Roll roll1Dice() {
        return Roll.of(this.dice.roll() - rollMalus);
    }

    public Roll roll2Dices() {
        int result = this.dice.roll(2) - rollMalus;
        Events.diceEvent(this.name + " lance 2 dés et fait " + result);
        return Roll.of(result);
    }

    public Roll roll3Dices() {
        int result = this.dice.roll(3) - rollMalus;
        Events.diceEvent(this.name + " lance 3 dés et fait " + result);
        return Roll.of(result);
    }

    public Roll roll4Dices() {
        int result = this.dice.roll(4) - rollMalus;
        Events.diceEvent(this.name + " lance 4 dés et fait " + result);
        return Roll.of(result);
    }

    // Status
    public int getAdditionalDamagePoints() {
        return this.getEquipedWeapon().map(i -> i.getDamagePoint().getValue()).orElse(0);
    }

    public HitRollRange getHitRollRange() {
        return hitRollRange;
    }

    public void setHitRollRange(HitRollRange hitRollRange) {
        this.hitRollRange = hitRollRange;
    }

    public int getCurrentHealthPoints() {
        return this.currentHealthPoints;
    }

    public HitRollRange getAdjustedHitRollRange() {
        if (this.forcedMinimumHitRoll != null) {
            return this.forcedMinimumHitRoll;
        }
        return this.getEquipedWeapon().map(Item::getHitRollRange).orElse(hitRollRange);
    }

    public int getArmorPoints() {
        return this.inventory.getEquipedItems().stream().map(i -> i.getArmorPoint().getValue()).reduce(0, Integer::sum);
    }

    public void addMagicalArmorPoints(ArmorPoint armorPoint) {
        this.magicArmorPoints = ArmorPoint.armor(this.magicArmorPoints.getValue() + armorPoint.getValue());
    }

    public void removeAllMagicEffects() {
        this.magicArmorPoints = ArmorPoint.armor(0);
        this.magicDamagePoints = DamagePoint.damage(0);
    }

    public void addMagicDamagePoints(DamagePoint damagePoint) {
        this.magicDamagePoints = DamagePoint.damage(this.magicDamagePoints.getValue() + damagePoint.getValue());
    }

    public boolean isDead() {
        return this.currentHealthPoints <= 0;
    }

    public boolean isStuned() {
        return this.initialHealthPoints > 5 && this.currentHealthPoints > 0 && this.currentHealthPoints <= 5;
    }

    // Fighting
    public void die() {
        this.currentHealthPoints = 0;
    }

    public void loseInitiative() {
        this.loseInitiative = true;
    }

    public boolean isAbleToFight() {
        return !this.isStuned() && !this.isDead();
    }

    public void attacks(int damagePoints, Entity target) {
        Events.fightEvent(this.getName() + " cause " + damagePoints + " de dommages à " + target.getName());
        Events.statusEvent(target.toString());
        target.wounds(damagePoints);
    }

    private boolean hasTouchedTargetWithPhysic(Roll roll, Entity target) {
        if (target.isInvisible() && !isAbleToTouchInvisibleTarget(target, roll)) {
            return false;
        }
        if (target.immuneToPhysicalDamages) {
            Events.fightEvent(target.getName() + " est immunisé contre les attaques physiques !");
            return false;
        }
        if (this.getMissMalusCount() > 0) {
            this.setMissMalusCount(this.getMissMalusCount() - 1);
            return false;
        }
        return this.getAdjustedHitRollRange().contains(roll.getValue());
    }

    private boolean hasTouchedOpponentWithMagic(Entity target) {
        if (target.isInvisible() && !isAbleToTouchInvisibleTarget(target, null)) {
            return false;
        }
        if (this.getMissMalusCount() > 0) {
            this.setMissMalusCount(this.getMissMalusCount() - 1);
            return false;
        }
        return true;
    }

    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    private boolean isAbleToTouchInvisibleTarget(Entity target, Roll roll) {
        if (this.hasEnoughStrikesInRowToHit(target)) {
            return true;
        }
        return roll != null && this.hasEnoughRollToHit(target, roll);
    }

    public boolean hasEnoughStrikesInRowToHit(Entity target) {
        return this.getStrikesInARow() >= target.getRequiredStrikesToHitInvisible();
    }

    public boolean hasEnoughRollToHit(Entity target, Roll roll) {
        return roll.getValue() >= target.invisibleRequiredMinimumHitRoll.getValue();
    }

    public void wounds(int damagePoints) {
        this.currentHealthPoints -= damagePoints;
        if (this.currentHealthPoints < 0) {
            this.currentHealthPoints = 0;
        }
    }

    public Attack createPhysicAttack(Entity target) {
        Roll roll = this.roll2Dices();
        return new Attack(computeDamages(roll, target), hasTouchedTargetWithPhysic(roll, target) ? TOUCHED : MISSED);
    }

    public Attack createMagicAttack(Entity target) {
        return new Attack(getMagicDamagePoints().getValue(), hasTouchedOpponentWithMagic(target) ? TOUCHED : MISSED);
    }

    private int computeDamages(Roll roll, Entity target) {
        if (this.constantHitDamage != null) {
            return constantHitDamage;
        }
        // System.out.println(roll+" - tch:"+this.getAdjustedHitRollRange().getMin()+" - arm:"+target.getArmor()+" + sw:"+getAdditionalDamagePoints());
        int damages = roll.getValue() - this.getAdjustedHitRollRange().getMin() - target.getArmorPoints() - target.magicArmorPoints.getValue() + getAdditionalDamagePoints() - getTemporaryDamagePointsMalus().getValue();
        if (this.has(Item.EXCALIBUR_JUNIOR_DRAGON_SLAYER) && target.isDragon()) {
            damages += 10;
        }
        return Math.max(0, damages);
    }

    protected abstract boolean isDragon();

    // Inventory
    public void equip(Item item) {
        this.inventory.equip(item);
    }

    public Item unequip(Item item) {
        this.inventory.unequip(item);
        return item;
    }

    public Optional<Item> getEquipedWeapon() {
        return this.inventory.getEquipedWeapon();
    }

    public void addAndEquip(Item item) {
        this.add(item);
        this.equip(item);
    }

    public void add(Item item) {
        Events.inventoryEvent(this.getName() + " ajoute " + item.getName() + " dans son inventaire");
        this.inventory.add(item);
    }

    public boolean has(Item item) {
        return this.inventory.contains(item);
    }

    public void remove(Item item) {
        this.inventory.remove(item);
    }

    public void equipAll() {
        this.inventory.equipAll();
    }

    public void addTemporaryDamagePointsMalus(DamagePoint damage) {
        this.temporaryDamagePointsMalus = DamagePoint.damage(damage.getValue() + temporaryDamagePointsMalus.getValue());
    }

    public void removeTemporaryBonusAndMalus() {
        this.temporaryDamagePointsMalus = DamagePoint.damage(0);
    }

    public boolean hasPoisonedWeapon() {
        return this.getEquipedWeapon().map(Item::isPoisoned).orElse(false);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return name.equals(entity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public boolean isPip() {
        return !this.isFoe();
    }

    public void addSpellToCast(SpellBook spell) {
        this.spellsToCastDuringFight.add(spell);
    }

    public void removeSpellToCast(SpellBook spell) {
        this.spellsToCastDuringFight.remove(spell);
    }

    public void add(SpecialSkill specialSkill) {
        this.specialSkills.add(specialSkill);
    }
}
