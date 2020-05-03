package fr.jsmadja.antredesdragons.entities;

import fr.jsmadja.antredesdragons.dices.Dice;
import fr.jsmadja.antredesdragons.dices.HitRollRange;
import fr.jsmadja.antredesdragons.dices.Roll;
import fr.jsmadja.antredesdragons.fight.Attack;
import fr.jsmadja.antredesdragons.stuff.ArmorPoint;
import fr.jsmadja.antredesdragons.stuff.DamagePoint;
import fr.jsmadja.antredesdragons.stuff.Item;
import fr.jsmadja.antredesdragons.ui.Events;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

import static fr.jsmadja.antredesdragons.fight.Attack.Status.MISSED;
import static fr.jsmadja.antredesdragons.fight.Attack.Status.TOUCHED;
import static java.text.MessageFormat.format;

public abstract class Entity {
    @Getter
    private final String name;
    private final Dice dice;

    private final int initialHealthPoints;
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

    Entity(String name, Dice dice, int initialHealthPoints, HitRollRange hitRollRange, Integer constantHitDamage, boolean immuneToPhysicalDamages) {
        this.name = name;
        this.dice = dice;
        if (hitRollRange != null) {
            this.hitRollRange = hitRollRange;
        }
        this.initialHealthPoints = this.currentHealthPoints = initialHealthPoints;
        this.constantHitDamage = constantHitDamage;
        this.immuneToPhysicalDamages = immuneToPhysicalDamages;
        this.maximumHealthPoints = this.initialHealthPoints;
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
    int roll1Dice() {
        return this.dice.roll() - rollMalus;
    }

    public Roll roll2Dices() {
        int result = this.dice.roll(2) - rollMalus;
        Events.diceEvent(this.name + " lance 2 dés et fait " + result);
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

    public int getInitialHealthPoints() {
        return this.initialHealthPoints;
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
    public void kill() {
        this.currentHealthPoints = 0;
    }

    public void loseInitiative() {
        this.loseInitiative = true;
    }

    public boolean canFight() {
        return !this.isStuned() && !this.isDead();
    }

    public void attacks(int damagePoints, Entity target) {
        Events.fightEvent(this.getName() + " cause " + damagePoints + " de dommages à " + target.getName());
        Events.statusEvent(target.toString());
        target.wounds(damagePoints);
    }

    private boolean touchOpponentWithPhysic(int roll, Entity target) {
        if (target.immuneToPhysicalDamages) {
            Events.fightEvent(target.getName() + " est immunisé contre les attaques physiques !");
            return false;
        }
        return this.getAdjustedHitRollRange().contains(roll);
    }

    private boolean touchOpponentWithMagic(Entity target) {
        return true;
    }

    public void wounds(int damagePoints) {
        this.currentHealthPoints -= damagePoints;
        if (this.currentHealthPoints < 0) {
            this.currentHealthPoints = 0;
        }
    }

    public Attack createPhysicAttack(Entity target) {
        int roll = this.roll2Dices().getValue();
        return new Attack(computeDamages(roll, target), touchOpponentWithPhysic(roll, target) ? TOUCHED : MISSED);
    }

    public Attack createMagicAttack(Entity target) {
        return new Attack(getMagicDamagePoints().getValue(), touchOpponentWithMagic(target) ? TOUCHED : MISSED);
    }

    private int computeDamages(int roll, Entity target) {
        if (this.constantHitDamage != null) {
            return constantHitDamage;
        }
        // System.out.println(roll+" - tch:"+this.getAdjustedHitRollRange().getMin()+" - arm:"+target.getArmor()+" + sw:"+getAdditionalDamagePoints());
        int damages = roll - this.getAdjustedHitRollRange().getMin() - target.getArmorPoints() - target.magicArmorPoints.getValue() + getAdditionalDamagePoints() - getTemporaryDamagePointsMalus().getValue();
        if(this.has(Item.EXCALIBUR_JUNIOR_DRAGON_SLAYER) && target.isDragon()) {
            damages += 10;
        }
        return Math.max(0, damages);
    }

    protected abstract boolean isDragon();

    // Inventory
    public void equip(Item item) {
        this.inventory.equip(item);
    }

    public void unequip(Item item) {
        this.inventory.unequip(item);
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

    public void removeOne(Item item) {
        this.inventory.removeOne(item);
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

}
