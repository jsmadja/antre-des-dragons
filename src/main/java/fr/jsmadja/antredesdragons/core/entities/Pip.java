package fr.jsmadja.antredesdragons.core.entities;

import fr.jsmadja.antredesdragons.core.book.Book;
import fr.jsmadja.antredesdragons.core.chapters.Chapter;
import fr.jsmadja.antredesdragons.core.chapters.ChapterNumber;
import fr.jsmadja.antredesdragons.core.chapters.DiceWay;
import fr.jsmadja.antredesdragons.core.chapters.Execution;
import fr.jsmadja.antredesdragons.core.diary.LogEntries;
import fr.jsmadja.antredesdragons.core.dices.Dice;
import fr.jsmadja.antredesdragons.core.dices.Roll;
import fr.jsmadja.antredesdragons.core.execution.Execution2;
import fr.jsmadja.antredesdragons.core.fight.Fight;
import fr.jsmadja.antredesdragons.core.inventory.HealingItem;
import fr.jsmadja.antredesdragons.core.inventory.HealingPotion;
import fr.jsmadja.antredesdragons.core.inventory.Item;
import fr.jsmadja.antredesdragons.core.inventory.Ointment;
import fr.jsmadja.antredesdragons.core.market.GoldenCoins;
import fr.jsmadja.antredesdragons.core.market.MarketItem;
import fr.jsmadja.antredesdragons.core.market.SilverCoins;
import fr.jsmadja.antredesdragons.core.skills.Skill;
import fr.jsmadja.antredesdragons.core.sleep.Sleep;
import fr.jsmadja.antredesdragons.core.spellcasting.SpellBook;
import fr.jsmadja.antredesdragons.core.spellcasting.SpellEffectResult;
import fr.jsmadja.antredesdragons.core.spellcasting.SpellUsages;
import fr.jsmadja.antredesdragons.core.stuff.HealthPoints;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static fr.jsmadja.antredesdragons.core.book.Book.DEBUT;
import static fr.jsmadja.antredesdragons.core.chapters.ChapterNumber.chapter;
import static fr.jsmadja.antredesdragons.core.execution.Action.goChapter;
import static fr.jsmadja.antredesdragons.core.spellcasting.SpellEffectResult.FAILURE;
import static fr.jsmadja.antredesdragons.core.spellcasting.SpellEffectResult.SUCCESS;
import static fr.jsmadja.antredesdragons.core.stuff.HealthPoints.hp;
import static java.text.MessageFormat.format;
import static java.util.stream.IntStream.range;

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

    private ChapterNumber currentChapterNumber = chapter(DEBUT);

    private List<SpellBook> usedSpellsInCurrentChapter = new ArrayList<>();

    @Setter
    @Getter
    private boolean nosferaxSnuffBoxUsed;

    public Pip(Dice dice) {
        super("Pip", dice);
    }

    public void initialize() {
        setInitialHealthPoints(computeInitialHealthPoints().getHealthPoints());
        setCurrentHealthPoints(getInitialHealthPoints());
        setMaximumHealthPoints(getInitialHealthPoints());
        range(0, 3).mapToObj(i -> new HealingPotion(this.getDice())).forEach(this::add);
        range(0, 5).mapToObj(i -> new Ointment()).forEach(this::add);
    }

    private HealthPoints computeInitialHealthPoints() {
        return hp(range(1, 4).map(i -> {
            Roll roll = this.getDice().roll(2);
            this.log(roll);
            return roll.getValue();
        }).max().orElse(0) * 4);
    }

    public HealingItem add(HealingItem healingItem) {
        super.log(healingItem);
        this.getInventory().add(healingItem);
        return healingItem;
    }

    @Override
    public boolean isFoe() {
        return false;
    }

    public Execution sleep() {
        this.setSleeping(true);
        Sleep sleep = new Sleep(this);
        if (sleep.isGood()) {
            HealthPoints healthPoints = sleep.getHealthPoints();
            this.restoreHealthPoints(healthPoints.getHealthPoints());
            this.setSleeping(false);
            return this.goToPreviousChapter();
        }
        return book.getDreamChapter(sleep.getDreamChapterNumber().getChapter()).execute(this);
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
        return goTo(chapter(chapter));
    }

    public Execution2 goToChapter2(ChapterNumber chapterNumber) {
        LogEntries currentChapterLogEntries = getCurrentChapterLogEntries();
        this.getDiary().openNewPage();
        if (this.isDead()) {
            return Execution2.builder()
                    .logEntries(currentChapterLogEntries)
                    .actions(List.of(goChapter(chapter(14))))
                    .build();
        }
        onChapterEnd();
        super.log(chapterNumber);
        this.currentChapterNumber = chapterNumber;
        Chapter chapter = book.get(this.currentChapterNumber.getChapter());
        chapter.setVisited(true);
        return chapter.execute2(this);
    }

    public LogEntries getCurrentChapterLogEntries() {
        return getDiary().getCurrentPage().getLogEntries();
    }

    public Execution goToPreviousChapter() {
        return goTo(getPreviousChapter());
    }

    public Execution goTo(ChapterNumber chapterNumber) {
        if (this.isDead()) {
            return goTo(chapter(14));
        }

        onChapterEnd();
        this.currentChapterNumber = chapterNumber;
        log(this.currentChapterNumber);
        Chapter chapter = book.get(this.currentChapterNumber.getChapter());
        System.err.println(chapter.getText() + "\n");
        chapter.setVisited(true);
        return chapter.execute(this);
    }

    private void onChapterEnd() {
        this.previousChapter = currentChapterNumber;
        this.usedSpellsInCurrentChapter.forEach(s -> s.getSpell().onChapterEnd(this));

    }

    public Execution rollAndGo(List<DiceWay> diceWays) {
        Roll roll = this.roll2Dices();
        DiceWay way = diceWays.stream().filter(diceWay -> diceWay.matches(roll)).findFirst().orElse(diceWays.get(0));
        return goTo(way.getChapterNumber());
    }

    public Execution2 rollAndGo2(List<DiceWay> diceWays) {
        Roll roll = this.roll2Dices();
        log(roll);
        DiceWay way = diceWays.stream().filter(diceWay -> diceWay.matches(roll)).findFirst().orElse(diceWays.get(0));
        return Execution2.builder()
                .logEntries(this.getCurrentChapterLogEntries())
                .actions(List.of(way.toAction()))
                .build();
    }

    // Spell
    public boolean hasSpell(SpellBook spell) {
        return this.spells.contains(spell);
    }

    public void removeSpell(SpellBook spell) {
        this.spells.remove(spell);
    }

    public SpellEffectResult use(SpellBook spell) {
        if (this.getCurrentHealthPoints() <= spell.getSpell().getDamagePoints().getDamagePoints()) {
            this.logSpell(this.getName() + " ne peut pas utiliser ce sort car il est trop couteux en points de vie");
            return FAILURE;
        }
        if (this.canUse(spell) && this.roll2Dices().isGreaterThan(Roll.roll(6))) {
            this.logSpell(this.getName() + " utilise le sort " + spell.name());
            spell.getSpell().onCast(this);
            this.wounds(spell.getSpell().getDamagePoints().getDamagePoints());
            this.spellUsages.increment(spell);
            this.addUsedSpellsInCurrentChapter(spell);
            return SUCCESS;
        }
        this.logSpell(this.getName() + " ne peut pas utiliser ce sort car il a été utilisé trop de fois");
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
        super.log("Pip obtient " + silverCoins + " pièces d'argent");
        this.silverCoins = this.silverCoins.plus(silverCoins);
    }

    public void add(GoldenCoins goldenCoins) {
        this.addSilverCoins(goldenCoins.toSilverCoins());
    }

    public boolean has(SilverCoins coins) {
        return this.silverCoins.getValue() > coins.getValue();
    }

    public void buy(MarketItem marketItem) {
        range(0, marketItem.getQuantity().getValue())
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

    public List<HealingItem> getHealingItemsOfType(Class<? extends HealingItem> clazz) {
        return this.getInventory().getHealingItemsOfType(clazz);
    }

    public Execution goToDreamChapter(ChapterNumber dreamChapterNumber) {
        return Execution.empty();
    }

    public Chapter getCurrentChapter() {
        return this.book.get(currentChapterNumber);
    }

}
