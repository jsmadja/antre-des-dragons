package fr.jsmadja.antredesdragons.core.chapters;


import fr.jsmadja.antredesdragons.core.execution.Action;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class YesOrNoQuestion {
    private final UUID id = UUID.randomUUID();
    private final String text;

    private YesOrNoQuestion(String question) {
        this.text = question;
    }

    public static YesOrNoQuestion question(String text) {
        return new YesOrNoQuestion(text + " ?");
    }

    public List<Action> toActionsForChapter(ChapterNumber chapter) {
        Action yes = Action.builder().question(text).answer("Oui").suffix("/questions/" + id + "/yes").chapter(chapter).build();
        Action non = Action.builder().question(text).answer("Non").suffix("/questions/" + id + "/no").chapter(chapter).build();
        return List.of(yes, non);
    }
}
