package fr.jsmadja.antredesdragons.core.ui;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.text.MessageFormat.format;

public class Prompt {
    public static YesNoAnswer answerTo(String question) {
        Events.questionEvent(format("{0} ?", question));
        return getYesNoAnswer();
    }

    public static YesNoAnswer getYesNoAnswer() {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextLine()) {
            YesNoAnswer answer = YesNoAnswer.of(sc.nextLine());
            if (answer.isValid()) {
                return answer;
            }
        }
        return getYesNoAnswer();
    }

    public static NumberAnswer answerTo(String question, List<Integer> validAnswers) {
        Events.questionEvent(format("{0} ?", question));
        return getNumberAnswer(validAnswers);
    }

    private static NumberAnswer getNumberAnswer(List<Integer> validAnswers) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            NumberAnswer answer = NumberAnswer.of(sc.nextInt(), validAnswers);
            if (answer.isValid()) {
                return answer;
            }
        }
        return getNumberAnswer(validAnswers);
    }

    @AllArgsConstructor(staticName = "of")
    public static class NumberAnswer {
        private final int answer;
        private final List<Integer> validAnswers;

        public boolean isValid() {
            return validAnswers.contains(answer);
        }

        public int getAnswer() {
            return answer;
        }
    }

    @AllArgsConstructor(staticName = "of")
    public static class YesNoAnswer {
        private final String answer;

        public boolean isValid() {
            return isYes() || isNo();
        }

        public boolean isYes() {
            return Arrays.stream(new String[]{"y", "yes", "o", "oui"})
                    .anyMatch(answer::equalsIgnoreCase);
        }

        public boolean isNo() {
            return Arrays.stream(new String[]{"n", "no", "non"})
                    .anyMatch(answer::equalsIgnoreCase);
        }
    }

}
