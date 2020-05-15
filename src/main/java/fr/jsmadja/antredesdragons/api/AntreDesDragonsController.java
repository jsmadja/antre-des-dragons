package fr.jsmadja.antredesdragons.api;

import fr.jsmadja.antredesdragons.core.chapters.Answer;
import fr.jsmadja.antredesdragons.core.chapters.Chapter;
import fr.jsmadja.antredesdragons.core.dices.Dice;
import fr.jsmadja.antredesdragons.core.entities.Pip;
import fr.jsmadja.antredesdragons.core.execution.Execution;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
        Execution execution = pip.goToChapter2(chapter(chapterNumber));
        return createStep(execution);
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
