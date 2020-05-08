package fr.jsmadja.antredesdragons.entities;

import fr.jsmadja.antredesdragons.book.ChapterNumber;
import fr.jsmadja.antredesdragons.book.Book;
import fr.jsmadja.antredesdragons.dices.Dice;
import fr.jsmadja.antredesdragons.dices.Roll;
import fr.jsmadja.antredesdragons.fight.Fight;
import fr.jsmadja.antredesdragons.market.GoldenCoins;
import fr.jsmadja.antredesdragons.market.MarketItem;
import fr.jsmadja.antredesdragons.market.SilverCoins;
import fr.jsmadja.antredesdragons.chapters.DiceWay;
import fr.jsmadja.antredesdragons.chapters.Execution;
import fr.jsmadja.antredesdragons.chapters.Chapter;
import fr.jsmadja.antredesdragons.spellcasting.SpellBook;
import fr.jsmadja.antredesdragons.spellcasting.SpellEffectResult;
import fr.jsmadja.antredesdragons.spellcasting.SpellUsages;
import fr.jsmadja.antredesdragons.stuff.Item;
import fr.jsmadja.antredesdragons.ui.Events;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import static fr.jsmadja.antredesdragons.spellcasting.SpellEffectResult.FAILURE;
import static fr.jsmadja.antredesdragons.spellcasting.SpellEffectResult.SUCCESS;
import static fr.jsmadja.antredesdragons.ui.Events.chapterEvent;
import static fr.jsmadja.antredesdragons.ui.Events.spellEvent;
import static fr.jsmadja.antredesdragons.ui.Events.statusEvent;
import static java.text.MessageFormat.format;

public class Pip extends Entity {

    public static final int NUMBER_OF_EXPERIENCE_POINTS_TO_LEVEL_UP = 20;
    private final Book book = new Book();
    private final List<SpellBook> spells = new ArrayList<>();
    private final Set<Skill> skills = new HashSet<>();
    private SilverCoins silverCoins = SilverCoins.of(0);
    private SpellUsages spellUsages = new SpellUsages();

    @Setter
    @Getter
    private boolean ableToOpenAnyItem;

    @Getter
    private ChapterNumber previousChapter;
    private int experiencePoints;
    private int level = 1;
    private ChapterNumber currentChapter;
    private List<SpellBook> usedSpellsInCurrentChapter = new ArrayList<>();

    public Pip(Dice dice) {
        super("Pip", dice, computeInitialHealthPoints(dice), DEFAULT_MINIMUM_HIT_ROLL, null, false, null, null);
    }

    private static int computeInitialHealthPoints(Dice dice) {
        return IntStream.range(1, 4).map(i -> dice.roll(2) * 4).max().getAsInt();
    }

    @Override
    public boolean isFoe() {
        return false;
    }

    public void sleep() {
        int face = this.roll1Dice().getValue();
        if (face >= 5) {
            int restoredHealthPoints = this.roll2Dices().getValue();
            this.restoreHealthPoints(restoredHealthPoints);
        }
    }

    // Fighting
    public void fight(List<Foe> foes, int mininumDeadFoes) {
        new Fight(this, foes, mininumDeadFoes).start();
        if (!this.isDead()) {
            this.addExperiencePoints(foes.size());
        }
    }

    public void fight(List<Foe> foes) {
        this.fight(foes, foes.size());
    }

    public void addExperiencePoints(int points) {
        this.experiencePoints += points;
        if (this.experiencePoints >= this.level * NUMBER_OF_EXPERIENCE_POINTS_TO_LEVEL_UP) {
            this.level++;
            this.addMaximumHealthPoints(1);
        }
    }

    private void addMaximumHealthPoints(int points) {
        this.setMaximumHealthPoints(this.getMaximumHealthPoints() + points);
    }

    // Navigation
    public Execution goToChapter(int chapter) {
        return goToChapter(ChapterNumber.chapter(chapter));
    }

    public Execution goToPreviousChapter() {
        return goToChapter(getPreviousChapter());
    }

    public Execution goToChapter(ChapterNumber chapterNumber) {
        onChapterEnd();
        this.currentChapter = chapterNumber;
        chapterEvent("Pip se rend au chapitre " + this.currentChapter.getChapter());
        statusEvent(this.toString());
        Chapter chapter = book.get(this.currentChapter.getChapter());
        System.err.println(chapter.getText() + "\n");
        chapter.setVisited(true);
        return chapter.execute(this);
    }

    private void onChapterEnd() {
        this.previousChapter = currentChapter;
        this.usedSpellsInCurrentChapter.forEach(s -> s.getSpell().onChapterEnd(this));

    }

    public Execution rollAndGo(List<DiceWay> diceWays) {
        Roll roll = this.roll2Dices();
        DiceWay way = diceWays.stream().filter(diceWay -> diceWay.matches(roll)).findFirst().get();
        return goToChapter(way.getChapterNumber());
    }

    // Spell
    public boolean hasSpell(SpellBook spell) {
        return this.spells.contains(spell);
    }

    public void removeSpell(SpellBook spell) {
        this.spells.remove(spell);
    }

    public SpellEffectResult use(SpellBook spell) {
        if (this.getCurrentHealthPoints() <= spell.getSpell().getDamagePoints().getValue()) {
            spellEvent(this.getName() + " ne peut pas utiliser ce sort car il est trop couteux en points de vie");
            return FAILURE;
        }
        if (this.canUse(spell) && this.roll2Dices().isGreaterThan(Roll.of(6))) {
            Events.spellEvent(this.getName() + " utilise le sort " + spell.name());
            spell.getSpell().onCast(this);
            this.wounds(spell.getSpell().getDamagePoints().getValue());
            this.spellUsages.increment(spell);
            this.addUsedSpellsInCurrentChapter(spell);
            return SUCCESS;
        }
        spellEvent(this.getName() + " ne peut pas utiliser ce sort car il a été utilisé trop de fois");
        return FAILURE;
    }

    private void addUsedSpellsInCurrentChapter(SpellBook spell) {
        this.usedSpellsInCurrentChapter.add(spell);
    }

    public boolean canUse(SpellBook spell) {
        return this.spellUsages.getUsagesOf(spell) < spell.getSpell().getMaxUsages();
    }

    // Skill
    public boolean hasSkill(Skill skill) {
        return this.skills.contains(skill);
    }

    @Override
    public String toString() {
        return format("{0} ~ HP: {1}/{6}, XP: {6}, STR: {2}, TCH: {3}, ARMOR: {4}, SC: {5}", this.getName(), this.getCurrentHealthPoints(), this.getAdditionalDamagePoints(), this.getHitRollRange().getMin(), this.getArmorPoints(), this.silverCoins, this.getMaximumHealthPoints(), this.experiencePoints);
    }

    @Override
    protected boolean isDragon() {
        return false;
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

    public void remove(GoldenCoins goldenCoins) {
        this.silverCoins = this.silverCoins.minus(goldenCoins.toSilverCoins());
    }

    public boolean has(GoldenCoins goldenCoins) {
        return has(goldenCoins.toSilverCoins());
    }

    public void add(Skill skill) {
        this.skills.add(skill);
    }

    public void removeAll(Item item) {
        this.getInventory().removeAll(item);
    }
}
