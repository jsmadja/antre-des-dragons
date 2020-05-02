package fr.jsmadja.antredesdragons.market;

import fr.jsmadja.antredesdragons.stuff.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;

import static java.text.MessageFormat.format;

@AllArgsConstructor
public enum MarketItem {
    BACKPACK(Item.BACKPACK, SilverCoin.of(1), Quantity.of(1)),

    CARPENTER_HAMMER(Item.CARPENTER_HAMMER, SilverCoin.of(1)),
    AXE(Item.AXE, SilverCoin.of(1)),
    ROPE(Item.ROPE, SilverCoin.of(2)),
    TORCH(Item.TORCH, SilverCoin.of(1), Quantity.of(12)),
    BOTTLE_OF_WATER(Item.BOTTLE_OF_WATER, SilverCoin.of(1)),
    TENT(Item.TENT, SilverCoin.of(10)),
    BAG(Item.BAG, SilverCoin.of(0.5), Quantity.of(6)),
    BLANKET(Item.BLANKET, SilverCoin.of(1)),
    LAMP(Item.LAMP, SilverCoin.of(2)),
    OIL_CAN(Item.OIL_CAN, SilverCoin.of(1)),
    CLEATS(Item.CLEATS, SilverCoin.of(0.5), Quantity.of(12)),
    FISHING_HOOKS(Item.FISHING_HOOKS, SilverCoin.of(1), Quantity.of(12)),
    HARP(Item.HARP, SilverCoin.of(5)),
    LUTH(Item.LUTH, SilverCoin.of(4)),
    HORN(Item.HORN, SilverCoin.of(3)),
    BANDAGES(Item.BANDAGES, SilverCoin.of(0.5)),
    KNIFE(Item.KNIFE, SilverCoin.of(1)),
    STONE_LIGHTER(Item.STONE_LIGHTER, SilverCoin.of(0.5)),
    STAKES(Item.STAKES, SilverCoin.of(0.5), Quantity.of(12)),
    SPARE_CLOTHES(Item.SPARE_CLOTHES, SilverCoin.of(10)),
    PARCHMENT(Item.PARCHMENT, SilverCoin.of(0.5)),
    PEN_AND_GOOSE_INK(Item.PEN_AND_GOOSE_INK, SilverCoin.of(1)),
    FOOD(Item.FOOD, SilverCoin.of(5), Quantity.of(5)),
    COOKING_TOOLS(Item.COOKING_TOOLS, SilverCoin.of(10)),
    HEALING_POTION(Item.HEALING_POTION, SilverCoin.of(3), Quantity.of(12)),

    HATCHET(Item.HATCHET, SilverCoin.of(20)),
    DAGGER(Item.DAGGER, SilverCoin.of(5)),
    FLAIL(Item.FLAIL, SilverCoin.of(5)),
    MACE(Item.MACE, SilverCoin.of(15)),
    CLUB(Item.CLUB, SilverCoin.of(20)),
    SWORD(Item.SWORD, SilverCoin.of(20)),

    CHAINMAIL(Item.CHAINMAIL, SilverCoin.of(100)),
    LEATHER_DOUBLET(Item.LEATHER_DOUBLE, SilverCoin.of(50)),
    ARMOR_PLATE(Item.ARMOR_PLATE, SilverCoin.of(120));

    @Getter
    private final Item item;

    @Getter
    private final SilverCoin price;

    @Getter
    private final Quantity quantity;

    MarketItem(Item item, SilverCoin price) {
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
