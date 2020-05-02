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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static fr.jsmadja.antredesdragons.fight.PhysicalAttack.Status.MISSED;
import static fr.jsmadja.antredesdragons.fight.PhysicalAttack.Status.TOUCHED;
import static java.text.MessageFormat.format;

public abstract class Entity {
    private Dice dice;
    private final int initialHealthPoints;
    private final int armor;
    private final String name;
    private HitRollRange hitRollRange = new HitRollRange(6, 12);
    private int healthPoints;
    private int maximumHealthPoints;
    private Integer constantHitDamage;
    private boolean immuneToPhysicalDamages;
    private List<Item> equipedItems = new ArrayList<>();
    private Inventory inventory = new Inventory();

    @Getter
    private boolean loseInitiative;

    @Setter
    private int rollMalus;

    public static final HitRollRange DEFAULT_MINIMUM_HIT_ROLL = new HitRollRange(6, 12);

    Entity(String name, Dice dice, int initialHealthPoints, int armor, HitRollRange hitRollRange, Integer constantHitDamage, boolean immuneToPhysicalDamages) {
        this.name = name;
        this.dice = dice;
        this.armor = armor;
        if (hitRollRange != null) {
            this.hitRollRange = hitRollRange;
        }
        this.initialHealthPoints = this.healthPoints = initialHealthPoints;
        this.constantHitDamage = constantHitDamage;
        this.immuneToPhysicalDamages = immuneToPhysicalDamages;
        this.maximumHealthPoints = this.initialHealthPoints;
    }

    int roll1Dice() {
        return this.dice.roll() - rollMalus;
    }

    public Roll roll2Dices() {
        int result = this.dice.roll(2) - rollMalus;
        Events.diceEvent(this.name + " lance 2 dés et fait " + result);
        return new Roll(result);
    }

    public int getInitialHealthPoints() {
        return this.initialHealthPoints;
    }

    public int getHealthPoints() {
        return this.healthPoints;
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
        int damages = roll - this.getAdjustedHitRollRange().getMin() - target.getArmor() - target.getAdditionalArmorPoints() + getAdditionalDamagePoints();
        return Math.max(0, damages);
    }

    private int getAdditionalArmorPoints() {
        return this.equipedItems.stream().map(i -> i.getArmorPoint().getValue()).reduce(0, Integer::sum);
    }

    protected int getArmor() {
        return armor;
    }

    private boolean touchOpponent(int roll, Entity target) {
        if (target.immuneToPhysicalDamages) {
            Events.fightEvent(target.getName() + " est immunisé contre les attaques physiques !");
            return false;
        }
        return this.getAdjustedHitRollRange().contains(roll);
    }

    public void wounds(int damagePoints) {
        this.healthPoints -= damagePoints;
        if (this.healthPoints < 0) {
            this.healthPoints = 0;
        }
    }

    public boolean isDead() {
        return this.healthPoints <= 0;
    }

    public boolean isStuned() {
        return this.initialHealthPoints > 5 && this.healthPoints > 0 && this.healthPoints <= 5;
    }

    public abstract boolean isFoe();

    public HitRollRange getAdjustedHitRollRange() {
        return this.getEquipedWeapon().map(Item::getHitRollRange).orElse(hitRollRange);
    }

    void restoreHealthPoints(int restoredHealthPoints) {
        this.healthPoints = Math.min(this.healthPoints + restoredHealthPoints, this.maximumHealthPoints);
    }

    public void kill() {
        this.healthPoints = 0;
    }

    @Override
    public String toString() {
        return format("{0} ~ HP: {1}, STR: {2}, TCH: {3}, ARMOR: {4}", this.name, this.healthPoints, this.getAdditionalDamagePoints(), this.hitRollRange.getMin(), this.armor);
    }

    public String getName() {
        return name;
    }

    public boolean canFight() {
        return !this.isStuned() && !this.isDead();
    }

    public void attacks(int damagePoints, Entity target) {
        Events.fightEvent(this.getName() + " cause " + damagePoints + " de dommages à " + target.getName());
        Events.statusEvent(target.toString());
        target.wounds(damagePoints);
    }

    public int getAdditionalDamagePoints() {
        return this.getEquipedWeapon().map(i -> i.getDamagePoint().getValue()).orElse(0);
    }

    public HitRollRange getHitRollRange() {
        return hitRollRange;
    }

    public void setHitRollRange(HitRollRange hitRollRange) {
        this.hitRollRange = hitRollRange;
    }

    public void equip(Item item) {
        this.equipedItems.add(item);
    }

    public void unequip(Item item) {
        this.equipedItems.remove(item);
    }

    public Optional<Item> getEquipedWeapon() {
        return this.equipedItems.stream().filter(Item::isWeapon).findFirst();
    }

    public void addAndEquip(Item item) {
        this.addInInventory(item);
        this.equip(item);
    }

    public void addInInventory(Item item) {
        Events.inventoryEvent(this.getName()+" ajoute " + item.getName() + " dans son inventaire");
        this.inventory.add(item);
    }

    public boolean hasItem(Item item) {
        return this.inventory.contains(item);
    }

    public void removeOne(Item item) {
        this.inventory.removeOne(item);
    }

    public void equipAll() {
        this.inventory.getAllEquipables().forEach(this::equip);
    }

    public void loseInitiative() {
        this.loseInitiative = true;
    }
}
