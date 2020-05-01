package fr.jsmadja.antredesdragons.pages.types;

import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.pages.content.PageNumber;
import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

@Setter
@Getter
public abstract class Page {

    private boolean visited;

    public abstract String getText();

    public abstract Execution execute(Pip pip);

    protected String getYesOrNoAnswer() {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextLine()) {
            String answer = sc.nextLine();
            if (isValidYesOrNoAnswer(answer)) {
                return answer;
            }
        }
        return getYesOrNoAnswer();
    }

    protected PageNumber getPageAnswer() {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int answer = sc.nextInt();
            if (isValidPageAnswer(answer)) {
                return PageNumber.of(answer);
            }
        }
        return getPageAnswer();
    }

    private boolean isValidPageAnswer(int answer) {
        return answer > 0;
    }

    public boolean isValidYesOrNoAnswer(String answer) {
        return answer.equalsIgnoreCase("o") || answer.equalsIgnoreCase("n");
    }

    public boolean isYesAnswer(String answer) {
        return answer.equalsIgnoreCase("o");
    }

}
