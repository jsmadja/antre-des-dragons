package fr.jsmadja.antredesdragons.api;

import fr.jsmadja.antredesdragons.core.chapters.Answer;
import fr.jsmadja.antredesdragons.core.chapters.Chapter;
import fr.jsmadja.antredesdragons.core.dices.Dice;
import fr.jsmadja.antredesdragons.core.entities.Pip;
import fr.jsmadja.antredesdragons.core.execution.Execution;
import fr.jsmadja.antredesdragons.core.inventory.HealingItem;
import fr.jsmadja.antredesdragons.core.inventory.Item;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static fr.jsmadja.antredesdragons.core.chapters.ChapterNumber.chapter;

@RestController
@RequestMapping(path = "/")
public class AntreDesDragonsController {

    public static Pip pip = new Pip(new Dice());

    @RequestMapping(path = "")
    @ResponseBody
    public Step createNewRun() {
        pip = new Pip(new Dice());
        Chapter currentChapter = pip.getCurrentChapter();
        Execution execution = currentChapter.execute(pip);
        return Step.builder()
                .pip(pip)
                .actions(execution.getActions())
                .build();
    }

    @RequestMapping(path = "/chapter/{chapterNumber}")
    public Step read(@PathVariable("chapterNumber") int chapterNumber) {
        Execution execution = pip.goToChapter(chapter(chapterNumber));
        return createStep(execution);
    }

    @RequestMapping(path = "/inventory/healingItems/{healingItemName}:use")
    public Step useHealingItem(@PathVariable("healingItemName") String healingItemName) {
        Optional<HealingItem> healingItem = pip.getHealingItemByName(healingItemName);
        pip.getDiary().openNewPage();
        healingItem.ifPresent(item -> pip.use(item));
        return Step.builder()
                .pip(pip)
                .logEntries(pip.getCurrentChapterLogEntries().toList())
                .build();
    }

    @RequestMapping(path = "/inventory/items/{itemName}:equip")
    public Step equipItem(@PathVariable("itemName") String itemName) {
        Optional<Item> item = pip.getItemByName(itemName);
        pip.getDiary().openNewPage();
        item.ifPresent(i -> pip.equip(i));
        return Step.builder()
                .pip(pip)
                .logEntries(pip.getCurrentChapterLogEntries().toList())
                .build();
    }

    @RequestMapping(path = "/inventory/items/{itemName}:unequip")
    public Step unequipItem(@PathVariable("itemName") String itemName) {
        Optional<Item> item = pip.getItemByName(itemName);
        pip.getDiary().openNewPage();
        item.ifPresent(i -> pip.unequip(i));
        return Step.builder()
                .pip(pip)
                .logEntries(pip.getCurrentChapterLogEntries().toList())
                .build();
    }

    private Step createStep(Execution execution) {
        return Step.builder()
                .pip(pip)
                .foes(execution.getFoes())
                .actions(execution.getActions())
                .logEntries(execution.getLogEntries().toList())
                .build();
    }

    @RequestMapping(path = "/chapter/{chapterNumber}/questions/{questionId}/{answer}")
    public Step answer(@PathVariable("chapterNumber") int chapterNumber, @PathVariable("questionId") String questionId, @PathVariable("answer") String answer) {
        Execution execution = pip.goToChapter2WithAnswer(chapter(chapterNumber), questionId, Answer.of(answer));
        return createStep(execution);
    }

}
