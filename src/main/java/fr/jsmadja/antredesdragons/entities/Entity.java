package fr.jsmadja.antredesdragons.entities;

import fr.jsmadja.antredesdragons.dices.Dice;
import fr.jsmadja.antredesdragons.dices.HitRollRange;
import fr.jsmadja.antredesdragons.dices.Roll;
import fr.jsmadja.antredesdragons.fight.PhysicalAttack;
import fr.jsmadja.antredesdragons.stuff.Inventory;
import fr.jsmadja.antredesdragons.stuff.Item;
import fr.jsmadja.antredesdragons.ui.Events;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

import static fr.jsmadja.antredesdragons.fight.PhysicalAttack.Status.MISSED;
import static fr.jsmadja.antredesdragons.fight.PhysicalAttack.Status.TOUCHED;
import static java.text.MessageFormat.format;

public abstract class Entity {
    @Getter
    private final String name;
    private final Dice dice;

    private final int initialHealthPoints;
    private int currentHealthPoints;
    private final int maximumHealthPoints;

    private HitRollRange hitRollRange = new HitRollRange(6);
    private final Integer constantHitDamage;
    private final boolean immuneToPhysicalDamages;
    private final Inventory inventory = new Inventory();

    @Getter
    private boolean loseInitiative;

    @Setter
    private int rollMalus;

    public static final HitRollRange DEFAULT_MINIMUM_HIT_ROLL = new HitRollRange(6, 12);

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

    void restoreHealthPoints(int restoredHealthPoints) {
        this.currentHealthPoints = Math.min(this.currentHealthPoints + restoredHealthPoints, this.maximumHealthPoints);
    }

    @Override
    public String toString() {
        return format("{0} ~ HP: {1}, STR: {2}, TCH: {3}, ARMOR: {4}", this.name, this.currentHealthPoints, this.getAdditionalDamagePoints(), this.hitRollRange.getMin(), this.getArmorPoints());
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
        return this.getEquipedWeapon().map(Item::getHitRollRange).orElse(hitRollRange);
    }
    public int getArmorPoints() {
        return this.inventory.getEquipedItems().stream().map(i -> i.getArmorPoint().getValue()).reduce(0, Integer::sum);
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
    private boolean touchOpponent(int roll, Entity target) {
        if (target.immuneToPhysicalDamages) {
            Events.fightEvent(target.getName() + " est immunisé contre les attaques physiques !");
            return false;
        }
        return this.getAdjustedHitRollRange().contains(roll);
    }
    public void wounds(int damagePoints) {
        this.currentHealthPoints -= damagePoints;
        if (this.currentHealthPoints < 0) {
            this.currentHealthPoints = 0;
        }
    }
    public PhysicalAttack attacks(Entity target) {
        int roll = this.roll2Dices().getValue();
        return new PhysicalAttack(computeDamages(roll, target), touchOpponent(roll, target) ? TOUCHED : MISSED);
    }
    private int computeDamages(int roll, Entity target) {
        if (this.constantHitDamage != null) {
            return constantHitDamage;
        }
        // System.out.println(roll+" - tch:"+this.getAdjustedHitRollRange().getMin()+" - arm:"+target.getArmor()+" + sw:"+getAdditionalDamagePoints());
        int damages = roll - this.getAdjustedHitRollRange().getMin() - target.getArmorPoints() + getAdditionalDamagePoints();
        return Math.max(0, damages);
    }

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
        Events.inventoryEvent(this.getName()+" ajoute " + item.getName() + " dans son inventaire");
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

}
