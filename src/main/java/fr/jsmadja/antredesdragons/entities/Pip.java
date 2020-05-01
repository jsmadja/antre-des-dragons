package fr.jsmadja.antredesdragons.entities;

import fr.jsmadja.antredesdragons.*;
import fr.jsmadja.antredesdragons.dices.Dice;
import fr.jsmadja.antredesdragons.dices.DiceWay;
import fr.jsmadja.antredesdragons.dices.Roll;
import fr.jsmadja.antredesdragons.fight.Fight;
import fr.jsmadja.antredesdragons.pages.*;
import fr.jsmadja.antredesdragons.pages.content.PageNumber;
import fr.jsmadja.antredesdragons.pages.types.Execution;
import fr.jsmadja.antredesdragons.pages.types.Page;
import fr.jsmadja.antredesdragons.stuff.Inventory;
import fr.jsmadja.antredesdragons.stuff.Item;

import java.util.ArrayList;
import java.util.List;

import static fr.jsmadja.antredesdragons.Events.pageEvent;

public class Pip extends Entity {

    private final Pages pages = new Pages();
    private Inventory inventory = new Inventory();
    private List<Spell> spells = new ArrayList<>();
    private List<Skill> skills = new ArrayList<>();

    public Pip(Dice dice) {
        super("Pip", dice, dice.roll(2) * 4, 0, DEFAULT_MINIMUM_HIT_ROLL, null, false, null);
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

    public Execution goToPage(PageNumber pageNumber) {
        pageEvent("Pip se rend à la page " + pageNumber.getValue());
        Page page = pages.get(pageNumber.getValue());
        System.out.println(page.getText() + "\n");
        Execution execution = page.execute(this);
        page.setVisited(true);
        return execution;
    }

    public Execution rollAndGo(DiceWay... diceWays) {
        return this.rollAndGo(List.of(diceWays));
    }

    public Execution rollAndGo(List<DiceWay> diceWays) {
        Roll roll = this.roll2Dices();
        DiceWay way = diceWays.stream().filter(diceWay -> diceWay.matches(roll)).findFirst().get();
        return goToPage(way.getPageNumber());
    }

    public void addInInventory(Item item) {
        Events.inventoryEvent("Pip ajoute " + item.getName() + " dans son inventaire");
        this.inventory.add(item);
    }

    public void fight(Foe foe) {
        new Fight(this, foe).start();
    }

    public void fight(List<Foe> foes, boolean pipInitiative) {
        Fight fight = new Fight(this, foes);
        if (pipInitiative) {
            fight.setFirstAttacker(this);
        }
        fight.start();
    }

    public Execution goToPage(int page) {
        return goToPage(PageNumber.of(page));
    }

    public boolean hasSpell(Spell spell) {
        return this.spells.contains(spell);
    }

    public void removeSpell(Spell spell) {
        this.spells.remove(spell);
    }

    public boolean hasItem(Item item) {
        return this.inventory.contains(item);
    }

    public void removeOne(Item item) {
        this.inventory.removeOne(item);
    }

    public void use(Spell spell) {
        Events.spellEvent(this.getName()+" utilise le sort "+spell.name());
    }

    public boolean hasSkill(Skill skill) {
        return this.skills.contains(skill);
    }
}
