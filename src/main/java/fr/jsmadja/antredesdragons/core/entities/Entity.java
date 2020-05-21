package fr.jsmadja.antredesdragons.core.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fr.jsmadja.antredesdragons.core.chapters.Chapter;
import fr.jsmadja.antredesdragons.core.diary.Diary;
import fr.jsmadja.antredesdragons.core.diary.LogEntry;
import fr.jsmadja.antredesdragons.core.dices.Dice;
import fr.jsmadja.antredesdragons.core.dices.HitRollRange;
import fr.jsmadja.antredesdragons.core.dices.Roll;
import fr.jsmadja.antredesdragons.core.fight.Attack;
import fr.jsmadja.antredesdragons.core.inventory.HealingItem;
import fr.jsmadja.antredesdragons.core.inventory.Inventory;
import fr.jsmadja.antredesdragons.core.inventory.Item;
import fr.jsmadja.antredesdragons.core.skills.SpecialSkill;
import fr.jsmadja.antredesdragons.core.spellcasting.SpellBook;
import fr.jsmadja.antredesdragons.core.stuff.ArmorPoints;
import fr.jsmadja.antredesdragons.core.stuff.DamagePoints;
import fr.jsmadja.antredesdragons.core.stuff.HealthPoints;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static fr.jsmadja.antredesdragons.core.dices.Roll.roll;
import static fr.jsmadja.antredesdragons.core.fight.Attack.Status.MISSED;
import static fr.jsmadja.antredesdragons.core.fight.Attack.Status.TOUCHED;
import static fr.jsmadja.antredesdragons.core.stuff.HealthPoints.hp;
import static java.lang.Integer.MAX_VALUE;
import static java.text.MessageFormat.format;

public abstract class Entity {
    @Getter
    private final String name;

    @JsonIgnore
    @Getter
    private final Dice dice;

    @Setter
    @Getter
    private int initialHealthPoints;

    @Setter
    private int currentHealthPoints;

    @Getter
    @Setter
    private int maximumHealthPoints;

    private HitRollRange hitRollRange = new HitRollRange(6);
    @Setter
    private HitRollRange forcedMinimumHitRoll;
    private Integer constantHitDamage;
    private boolean immuneToPhysicalDamages;

    @Getter
    @Setter
    private boolean immuneToPoison;

    @Getter
    @Setter
    private boolean ableToStrikeTwice;

    @Getter
    private ArmorPoints magicArmorPoints = ArmorPoints.armor(0);

    @Getter
    private DamagePoints magicDamagePoints = DamagePoints.damage(0);

    @Getter
    private final Inventory inventory = new Inventory();

    @Getter
    private boolean loseInitiative;

    @Setter
    private int rollMalus;

    @Getter
    @Setter
    private boolean sleeping;

    @Getter
    private DamagePoints temporaryDamagePointsMalus = DamagePoints.damage(0);

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
    private final List<SpellBook> spellsToCastDuringFight = new ArrayList<>();

    @Getter
    private final List<SpecialSkill> specialSkills = new ArrayList<>();

    @Setter
    @Getter
    private HealthPoints lostHealthPointsDuringCurrentFight = hp(0);

    @JsonIgnore
    @Getter
    private final Diary diary = new Diary();

    Entity(String name, Dice dice, HealthPoints initialHealthPoints, HitRollRange hitRollRange, Integer constantHitDamage, boolean immuneToPhysicalDamages, Integer requiredStrikesToHitInvisible) {
        this.name = name;
        this.dice = dice;
        if (hitRollRange != null) {
            this.hitRollRange = hitRollRange;
        }
        this.initialHealthPoints = this.currentHealthPoints = initialHealthPoints.getHealthPoints();
        this.constantHitDamage = constantHitDamage;
        this.immuneToPhysicalDamages = immuneToPhysicalDamages;
        this.maximumHealthPoints = this.initialHealthPoints;
        this.requiredStrikesToHitInvisible = requiredStrikesToHitInvisible == null ? MAX_VALUE : requiredStrikesToHitInvisible;
    }

    Entity(String name, Dice dice) {
        this.name = name;
        this.dice = dice;
        this.requiredStrikesToHitInvisible = MAX_VALUE;
    }

    @JsonIgnore
    public abstract boolean isFoe();

    public void restoreHealthPoints(int restoredHealthPoints) {
        log("regagne " + restoredHealthPoints + " points de vie");
        this.currentHealthPoints = Math.min(this.currentHealthPoints + restoredHealthPoints, this.maximumHealthPoints);
    }

    public void restoreAllHealthPoints() {
        log("regagne tous ses points de vie");
        this.restoreHealthPoints(this.maximumHealthPoints);
    }

    // Rolling
    public Roll roll1Dice() {
        Roll roll = roll(this.dice.roll() - rollMalus);
        log(roll);
        return roll;
    }

    public Roll roll2Dices() {
        Roll roll = this.dice.roll(2);
        int result = roll.getValue() - rollMalus;
        log(roll);
        return roll(result);
    }

    public Roll roll3Dices() {
        Roll roll = this.dice.roll(3);
        int result = roll.getValue() - rollMalus;
        log(roll);
        return roll(result);
    }

    public Roll roll4Dices() {
        Roll roll = this.dice.roll(4);
        int result = roll.getValue() - rollMalus;
        log(roll);
        return roll(result);
    }

    // Status
    public int getAdditionalDamagePoints() {
        return this.getEquipedWeapon()
                .filter(i -> !isSleeping() || i.isDreamItem())
                .map(i -> i.getDamagePoints().getDamagePoints()).orElse(0);
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
        return this.inventory.getEquipedItems()
                .stream()
                .filter(item -> !isSleeping() || item.isDreamItem())
                .map(i -> i.getArmorPoints().getArmorPoints())
                .reduce(0, Integer::sum);
    }

    public void addMagicalArmorPoints(ArmorPoints armorPoints) {
        this.magicArmorPoints = ArmorPoints.armor(this.magicArmorPoints.getArmorPoints() + armorPoints.getArmorPoints());
    }

    public void removeAllMagicEffects() {
        this.magicArmorPoints = ArmorPoints.armor(0);
        this.magicDamagePoints = DamagePoints.damage(0);
    }

    public void addMagicDamagePoints(DamagePoints damagePoints) {
        this.magicDamagePoints = DamagePoints.damage(this.magicDamagePoints.getDamagePoints() + damagePoints.getDamagePoints());
    }

    public boolean isDead() {
        return hasBeenInitialized() && this.currentHealthPoints <= 0;
    }

    public boolean hasBeenInitialized() {
        return this.initialHealthPoints > 0;
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
        this.logFight(this.getName() + " cause " + damagePoints + " de dommages à " + target.getName());
        target.wounds(damagePoints);
    }

    private boolean hasTouchedTargetWithPhysic(Roll roll, Entity target) {
        if (target.isInvisible() && !isAbleToTouchInvisibleTarget(target, roll)) {
            return false;
        }
        if (target.immuneToPhysicalDamages) {
            target.logFight(target.getName() + " est immunisé contre les attaques physiques !");
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
        this.lostHealthPointsDuringCurrentFight = hp(this.lostHealthPointsDuringCurrentFight.getHealthPoints() + damagePoints);
        this.currentHealthPoints -= damagePoints;
        if (this.currentHealthPoints < 0) {
            this.currentHealthPoints = 0;
        }
    }

    public Attack createPhysicAttack(Entity target) {
        Roll roll = this.roll2Dices();
        return new Attack(getPhysicalDamagePoints(roll, target), hasTouchedTargetWithPhysic(roll, target) ? TOUCHED : MISSED);
    }

    public Attack createMagicAttack(Entity target) {
        return new Attack(getMagicDamagePoints().getDamagePoints(), hasTouchedOpponentWithMagic(target) ? TOUCHED : MISSED);
    }

    private int getPhysicalDamagePoints(Roll roll, Entity target) {
        if (this.constantHitDamage != null) {
            return constantHitDamage;
        }
        int damages = roll.getValue();
        damages -= this.getAdjustedHitRollRange().getMin();
        damages -= target.getArmorPoints();
        damages -= target.magicArmorPoints.getArmorPoints();
        damages += getAdditionalDamagePoints();
        damages -= getTemporaryDamagePointsMalus().getDamagePoints();
        if (!sleeping && has(Item.EXCALIBUR_JUNIOR_DRAGON_SLAYER) && target.isDragon()) {
            damages += 10;
        }
        return Math.max(0, damages);
    }

    @JsonIgnore
    protected abstract boolean isDragon();

    // Inventory
    public void equip(Item item) {
        this.log(format("s''équipe de {0}", item.getName()));
        this.inventory.equip(item);
    }

    public Item unequip(Item item) {
        this.log(format("se déséquipe de {0}", item.getName()));
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
        this.getDiary().log(this.getName(), item);
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

    public Optional<HealingItem> getHealingItemByName(String healingItemName) {
        return this.inventory.getHealingItemByName(healingItemName);
    }

    public Optional<Item> getItemByName(String itemName) {
        return this.inventory.getItemByName(itemName);
    }

    public void addTemporaryDamagePointsMalus(DamagePoints damage) {
        this.temporaryDamagePointsMalus = DamagePoints.damage(damage.getDamagePoints() + temporaryDamagePointsMalus.getDamagePoints());
    }

    public void removeTemporaryBonusAndMalus() {
        this.temporaryDamagePointsMalus = DamagePoints.damage(0);
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

    @JsonIgnore
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

    public void wounds(HealthPoints healthPoints) {
        this.wounds(healthPoints.getHealthPoints());
    }

    public void log(Roll roll) {
        this.diary.log(getName(), roll);
    }

    public void log(HealingItem healingItem) {
        this.diary.log(getName(), healingItem);
    }

    public void log(Chapter chapter) {
        this.diary.log(getName(), chapter);
    }

    public void logFight(String message) {
        this.diary.log(getName(), LogEntry.Type.FIGHT, message);
    }

    public void incrementStrikes() {
        this.strikes++;
    }

    public void resetStrikes() {
        this.strikes = 0;
    }

    public void logSpell(String message) {
        this.diary.log(getName(), LogEntry.Type.SPELL, message);
    }

    public void log(String message) {
        this.diary.log(getName(), LogEntry.Type.MISC, message);
    }

    @Override
    public String toString() {
        return String.format("%s (%d/%d)", name, currentHealthPoints, maximumHealthPoints);
    }

}
