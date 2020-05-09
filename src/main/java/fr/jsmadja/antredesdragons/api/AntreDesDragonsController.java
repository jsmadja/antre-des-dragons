package fr.jsmadja.antredesdragons.api;

import fr.jsmadja.antredesdragons.core.Answer;
import fr.jsmadja.antredesdragons.core.chapters.Chapter;
import fr.jsmadja.antredesdragons.core.dices.Dice;
import fr.jsmadja.antredesdragons.core.entities.Pip;
import fr.jsmadja.antredesdragons.core.execution.Execution2;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static fr.jsmadja.antredesdragons.core.chapters.ChapterNumber.chapter;

@RestController
public class AntreDesDragonsController {

    public static Pip pip = new Pip(new Dice());

    @RequestMapping(path = "/")
    @ResponseBody
    public Step createNewRun() {
        pip = new Pip(new Dice());
        Chapter currentChapter = pip.getCurrentChapter();
        Execution2 execution2 = currentChapter.execute2(pip);
        return Step.builder()
                .pip(pip)
                .actions(execution2.getActions())
                .build();
    }

    @RequestMapping(path = "/chapter/{chapterNumber}")
    public Step read(@PathVariable("chapterNumber") int chapterNumber) {
        Execution2 execution2 = pip.goToChapter2(chapter(chapterNumber));
        return Step.builder()
                .pip(pip)
                .actions(execution2.getActions())
                .logEntries(execution2.getLogEntries().toList())
                .build();
    }

    @RequestMapping(path = "/chapter/{chapterNumber}/questions/{questionId}/{answer}")
    public Step answer(@PathVariable("chapterNumber") int chapterNumber, @PathVariable("questionId") UUID questionId, @PathVariable("answer") String answer) {
        Execution2 execution2 = pip.goToChapter2WithAnswer(chapter(chapterNumber), questionId, Answer.of(answer));
        return Step.builder()
                .pip(pip)
                .actions(execution2.getActions())
                .logEntries(execution2.getLogEntries().toList())
                .build();
    }

}
