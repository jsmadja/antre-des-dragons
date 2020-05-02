package fr.jsmadja.antredesdragons.entities;

import fr.jsmadja.antredesdragons.book.PageNumber;
import fr.jsmadja.antredesdragons.book.Pages;
import fr.jsmadja.antredesdragons.dices.Dice;
import fr.jsmadja.antredesdragons.dices.Roll;
import fr.jsmadja.antredesdragons.fight.Fight;
import fr.jsmadja.antredesdragons.market.GoldenCoins;
import fr.jsmadja.antredesdragons.market.MarketItem;
import fr.jsmadja.antredesdragons.market.SilverCoins;
import fr.jsmadja.antredesdragons.pages.DiceWay;
import fr.jsmadja.antredesdragons.pages.Execution;
import fr.jsmadja.antredesdragons.pages.Page;
import fr.jsmadja.antredesdragons.ui.Events;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static fr.jsmadja.antredesdragons.ui.Events.pageEvent;
import static java.text.MessageFormat.format;

public class Pip extends Entity {

    private final Pages pages = new Pages();
    private final List<Spell> spells = new ArrayList<>();
    private final List<Skill> skills = new ArrayList<>();
    private SilverCoins silverCoins = SilverCoins.of(0);

    @Getter
    private PageNumber previousPage;

    public Pip(Dice dice) {
        super("Pip", dice, dice.roll(2) * 4, DEFAULT_MINIMUM_HIT_ROLL, null, false);
    }

    @Override
    public boolean isFoe() {
        return false;
    }

    public void sleep() {
        int face = this.roll1Dice();
        if (face >= 5) {
            int restoredHealthPoints = this.roll2Dices().getValue();
            this.restoreHealthPoints(restoredHealthPoints);
        }
    }

    // Fighting
    public void fight(Foe foe) {
        new Fight(this, foe).start();
    }

    public void fight(List<Foe> foes) {
        new Fight(this, foes).start();
    }

    // Navigation
    public Execution goToPage(int page) {
        return goToPage(PageNumber.page(page));
    }

    public Execution goToPreviousPage() {
        return goToPage(getPreviousPage());
    }

    public Execution goToPage(PageNumber pageNumber) {
        pageEvent("Pip se rend à la page " + pageNumber.getPage());
        Page page = pages.get(pageNumber.getPage());
        System.out.println(page.getText() + "\n");
        Execution execution = page.execute(this);
        page.setVisited(true);
        this.previousPage = pageNumber;
        return execution;
    }

    public Execution rollAndGo(List<DiceWay> diceWays) {
        Roll roll = this.roll2Dices();
        DiceWay way = diceWays.stream().filter(diceWay -> diceWay.matches(roll)).findFirst().get();
        return goToPage(way.getPageNumber());
    }

    // Spell
    public boolean hasSpell(Spell spell) {
        return this.spells.contains(spell);
    }

    public void removeSpell(Spell spell) {
        this.spells.remove(spell);
    }

    public void use(Spell spell) {
        Events.spellEvent(this.getName() + " utilise le sort " + spell.name());
    }

    // Skill
    public boolean hasSkill(Skill skill) {
        return this.skills.contains(skill);
    }

    @Override
    public String toString() {
        return format("{0} ~ HP: {1}, STR: {2}, TCH: {3}, ARMOR: {4}, SC: {5}", this.getName(), this.getCurrentHealthPoints(), this.getAdditionalDamagePoints(), this.getHitRollRange().getMin(), this.getArmorPoints(), this.silverCoins);
    }

    // Money
    public void addSilverCoins(SilverCoins silverCoins) {
        Events.event("Pip obtient " + silverCoins + " pièces d'argent");
        this.silverCoins = this.silverCoins.plus(silverCoins);
    }

    public void add(GoldenCoins goldenCoins) {
        this.addSilverCoins(goldenCoins.toSilverCoins());
    }

    public boolean has(SilverCoins coins) {
        return this.silverCoins.getValue() > coins.getValue();
    }

    public void buy(MarketItem marketItem) {
        IntStream.range(0, marketItem.getQuantity().getValue())
                .forEach(mi -> {
                    this.silverCoins = this.silverCoins.minus(marketItem.getPrice());
                    this.add(marketItem.getItem());
                });

    }
}
