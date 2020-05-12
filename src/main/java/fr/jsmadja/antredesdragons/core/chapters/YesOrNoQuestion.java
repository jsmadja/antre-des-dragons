package fr.jsmadja.antredesdragons.core.chapters;


import fr.jsmadja.antredesdragons.core.execution.Action;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

@EqualsAndHashCode
@Getter
public class YesOrNoQuestion {
    private final String id;
    private final String text;

    private YesOrNoQuestion(String id, String question) {
        this.id = id;
        this.text = question;
    }

    public static YesOrNoQuestion question(String id, String text) {
        return new YesOrNoQuestion(id, text + " ?");
    }

    public List<Action> toActionsForChapter(ChapterNumber chapter) {
        Action yes = Action.builder().question(text).answer("Oui").suffix("/questions/" + getId() + "/yes").chapter(chapter).build();
        Action non = Action.builder().question(text).answer("Non").suffix("/questions/" + getId() + "/no").chapter(chapter).build();
        return List.of(yes, non);
    }
}
