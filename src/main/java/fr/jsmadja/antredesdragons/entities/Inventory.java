package fr.jsmadja.antredesdragons.entities;

import fr.jsmadja.antredesdragons.stuff.Item;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@Getter
public class Inventory {
    private final List<Item> items = new ArrayList<>();
    private final List<Item> equipedItems = new ArrayList<>();

    public void add(Item item) {
        this.items.add(item);
    }

    public boolean contains(Item item) {
        return this.items.contains(item);
    }

    public void removeOne(Item item) {
        this.items.remove(item);
    }

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
}
