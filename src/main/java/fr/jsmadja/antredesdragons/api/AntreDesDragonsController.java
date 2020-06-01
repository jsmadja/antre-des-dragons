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

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static fr.jsmadja.antredesdragons.core.chapters.ChapterNumber.chapter;

@RestController
@RequestMapping(path = "/")
public class AntreDesDragonsController {

    public static Map<String, Pip> pips = new HashMap<>();

    @RequestMapping(path = "")
    @ResponseBody
    public Step createNewRun() {
        Pip pip = new Pip(new Dice());
        addPipRun(pip);
        Chapter currentChapter = pip.getCurrentChapter();
        Execution execution = currentChapter.execute(pip);
        return Step.builder()
                .pip(pip)
                .actions(execution.getActions())
                .build();
    }

    public void addPipRun(Pip pip) {
        pips.put(pip.getId(), pip);
    }

    @RequestMapping(path = "{pipId}/chapter/{chapterNumber}")
    public Step read(@PathVariable("pipId") String pipId, @PathVariable("chapterNumber") int chapterNumber) {
        Pip pip = getPipById(pipId);
        if (pip.isDead()) {
            pip = new Pip(new Dice());
            addPipRun(pip);
        }
        Execution execution = pip.goToChapter(chapter(chapterNumber));
        return createStep(pip, execution);
    }

    private Pip getPipById(String pipId) {
        Pip pip = pips.get(pipId);
        if (pip == null) {
            throw new RuntimeException("Pip not found");
        }
        return pip;
    }

    @RequestMapping(path = "{pipId}/inventory/healingItems/{healingItemName}:use")
    public Step useHealingItem(@PathVariable("pipId") String pipId, @PathVariable("healingItemName") String healingItemName) {
        Pip pip = getPipById(pipId);
        Optional<HealingItem> healingItem = pip.getHealingItemByName(healingItemName);
        pip.getDiary().openNewPage();
        healingItem.ifPresent(pip::use);
        return Step.builder()
                .pip(pip)
                .logEntries(pip.getCurrentChapterLogEntries().toList())
                .build();
    }

    @RequestMapping(path = "{pipId}/inventory/items/{itemName}:equip")
    public Step equipItem(@PathVariable("pipId") String pipId, @PathVariable("itemName") String itemName) {
        Pip pip = getPipById(pipId);
        Optional<Item> item = pip.getItemByName(itemName);
        pip.getDiary().openNewPage();
        item.ifPresent(pip::equip);
        return Step.builder()
                .pip(pip)
                .logEntries(pip.getCurrentChapterLogEntries().toList())
                .build();
    }

    @RequestMapping(path = "{pipId}/inventory/items/{itemName}:unequip")
    public Step unequipItem(@PathVariable("pipId") String pipId, @PathVariable("itemName") String itemName) {
        Pip pip = getPipById(pipId);
        Optional<Item> item = pip.getItemByName(itemName);
        pip.getDiary().openNewPage();
        item.ifPresent(pip::unequip);
        return Step.builder()
                .pip(pip)
                .logEntries(pip.getCurrentChapterLogEntries().toList())
                .build();
    }

    private Step createStep(Pip pip, Execution execution) {
        return Step.builder()
                .pip(pip)
                .foes(execution.getFoes())
                .actions(execution.getActions())
                .logEntries(execution.getLogEntries().toList())
                .build();
    }

    @RequestMapping(path = "{pipId}/chapter/{chapterNumber}/questions/{questionId}/{answer}")
    public Step answer(@PathVariable("pipId") String pipId, @PathVariable("chapterNumber") int chapterNumber, @PathVariable("questionId") String questionId, @PathVariable("answer") String answer) {
        Pip pip = getPipById(pipId);
        Execution execution = pip.goToChapter2WithAnswer(chapter(chapterNumber), questionId, Answer.of(answer));
        return createStep(pip, execution);
    }

}
