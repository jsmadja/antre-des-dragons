package fr.jsmadja.antredesdragons.market;

import fr.jsmadja.antredesdragons.stuff.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;

import static java.text.MessageFormat.format;

@AllArgsConstructor
public enum MarketItem {
    BACKPACK(Item.BACKPACK, SilverCoins.of(1), Quantity.of(1)),

    CARPENTER_HAMMER(Item.CARPENTER_HAMMER, SilverCoins.of(1)),
    AXE(Item.AXE, SilverCoins.of(1)),
    ROPE(Item.ROPE, SilverCoins.of(2)),
    TORCH(Item.TORCH, SilverCoins.of(1), Quantity.of(12)),
    BOTTLE_OF_WATER(Item.BOTTLE_OF_WATER, SilverCoins.of(1)),
    TENT(Item.TENT, SilverCoins.of(10)),
    BAG(Item.BAG, SilverCoins.of(0.5), Quantity.of(6)),
    BLANKET(Item.BLANKET, SilverCoins.of(1)),
    LAMP(Item.LAMP, SilverCoins.of(2)),
    OIL_CAN(Item.OIL_CAN, SilverCoins.of(1)),
    CLEATS(Item.CLEATS, SilverCoins.of(0.5), Quantity.of(12)),
    FISHING_HOOKS(Item.FISHING_HOOKS, SilverCoins.of(1), Quantity.of(12)),
    HARP(Item.HARP, SilverCoins.of(5)),
    LUTH(Item.LUTH, SilverCoins.of(4)),
    HORN(Item.HORN, SilverCoins.of(3)),
    BANDAGES(Item.BANDAGES, SilverCoins.of(0.5)),
    KNIFE(Item.KNIFE, SilverCoins.of(1)),
    STONE_LIGHTER(Item.STONE_LIGHTER, SilverCoins.of(0.5)),
    STAKES(Item.STAKES, SilverCoins.of(0.5), Quantity.of(12)),
    SPARE_CLOTHES(Item.SPARE_CLOTHES, SilverCoins.of(10)),
    PARCHMENT(Item.PARCHMENT, SilverCoins.of(0.5)),
    PEN_AND_GOOSE_INK(Item.PEN_AND_GOOSE_INK, SilverCoins.of(1)),
    FOOD(Item.FOOD, SilverCoins.of(5), Quantity.of(5)),
    COOKING_TOOLS(Item.COOKING_TOOLS, SilverCoins.of(10)),
    HEALING_POTION(Item.HEALING_POTION, SilverCoins.of(3), Quantity.of(12)),

    HATCHET(Item.HATCHET, SilverCoins.of(20)),
    DAGGER(Item.DAGGER, SilverCoins.of(5)),
    FLAIL(Item.FLAIL, SilverCoins.of(5)),
    MACE(Item.MACE, SilverCoins.of(15)),
    CLUB(Item.CLUB, SilverCoins.of(20)),
    SWORD(Item.SWORD, SilverCoins.of(20)),

    CHAINMAIL(Item.CHAINMAIL, SilverCoins.of(100)),
    LEATHER_DOUBLET(Item.LEATHER_DOUBLE, SilverCoins.of(50)),
    ARMOR_PLATE(Item.ARMOR_PLATE, SilverCoins.of(120));

    @Getter
    private final Item item;

    @Getter
    private final SilverCoins price;

    @Getter
    private final Quantity quantity;

    MarketItem(Item item, SilverCoins price) {
        this(item, price, Quantity.of(1));
    }

    @Override
    public String toString() {
        if(quantity.getValue() > 1) {
            return format("{0} {1}", pad(item.getName()+" ("+quantity+")"), price);
        }
        return format("{0} {1}", pad(item.getName()),price);
    }

    private static String pad(String message) {
        return String.format("%-30s ", message);
    }

}
