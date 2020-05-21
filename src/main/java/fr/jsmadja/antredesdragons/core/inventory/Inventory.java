package fr.jsmadja.antredesdragons.core.inventory;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@Data
@Getter
public class Inventory {
    private final List<Item> items = new ArrayList<>();
    private final List<Item> equipedItems = new ArrayList<>();
    private final List<HealingItem> healingItems = new ArrayList<>();

    public void add(Item item) {
        this.items.add(item);
    }

    public boolean contains(Item item) {
        return this.items.contains(item);
    }

    public void remove(Item item) {
        this.items.remove(item);
    }

    @JsonIgnore
    public List<Item> getAllEquipables() {
        return items.stream().filter(Item::isEquipable).collect(toList());
    }

    public void equipAll() {
        this.getAllEquipables().forEach(this::equip);
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

    public Stream<Item> stream() {
        return this.items.stream();
    }

    public void removeAll(Item item) {
        while (this.items.contains(item)) {
            this.remove(item);
        }
    }

    public List<HealingItem> getHealingItemsOfType(Class<? extends HealingItem> clazz) {
        return this.healingItems.stream().filter(i -> i.getClass().isAssignableFrom(clazz)).collect(Collectors.toList());
    }

    public void add(HealingItem healingItem) {
        this.healingItems.add(healingItem);
    }

    public void remove(HealingItem healingItem) {
        this.healingItems.remove(healingItem);
    }

    public Optional<HealingItem> getHealingItemByName(String healingItemName) {
        return this.healingItems.stream().filter(item -> item.getName().equalsIgnoreCase(healingItemName)).findFirst();
    }

    public Optional<Item> getItemByName(String itemName) {
        return this.items.stream().filter(item -> item.getName().equalsIgnoreCase(itemName)).findFirst();
    }
}
