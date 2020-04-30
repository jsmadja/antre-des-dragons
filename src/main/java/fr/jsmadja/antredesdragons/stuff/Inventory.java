package fr.jsmadja.antredesdragons.stuff;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Item> items = new ArrayList<>();

    public void add(Item item) {
        this.items.add(item);
    }

    public boolean contains(Item item) {
        return this.items.contains(item);
    }

    public void removeOne(Item item) {
        this.items.remove(item);
    }
}
