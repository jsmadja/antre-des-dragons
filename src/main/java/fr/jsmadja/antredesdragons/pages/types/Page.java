package fr.jsmadja.antredesdragons.pages.types;

import fr.jsmadja.antredesdragons.entities.Pip;

import java.util.Scanner;

public abstract class Page {
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

    public boolean isValidYesOrNoAnswer(String answer) {
        return answer.equalsIgnoreCase("o") || answer.equalsIgnoreCase("n");
    }

}
