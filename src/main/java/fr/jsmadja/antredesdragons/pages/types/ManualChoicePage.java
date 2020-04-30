package fr.jsmadja.antredesdragons.pages.types;

import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.pages.content.PageNumber;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.Scanner;

import static java.util.Comparator.comparing;

public abstract class ManualChoicePage extends Page {

    @Override
    public Execution execute(Pip pip) {
        return askWhichWay(pip);
    }

    public Execution askWhichWay(Pip pip) {
        Paths possiblesPath = getPossiblesPath();
        System.out.println("\nQuel chemin prendre ?\n");
        possiblesPath.print();
        return pip.goToPage(PageNumber.of(this.getAnswer()));
    }

    private int getAnswer() {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int answer = sc.nextInt();
            if (isValidAnswer(answer)) {
                return answer;
            }
        }
        return getAnswer();
    }

    public boolean isValidAnswer(int answer) {
        return getPossiblesPath().isValidPath(answer);
    }

    public abstract Paths getPossiblesPath();

    public static class Paths {
        private List<Path> paths;

        public Paths(Path... paths) {
            this(List.of(paths));
        }

        public Paths(List<Path> paths) {
            this.paths = paths;
        }

        public void print() {
            paths.stream().sorted(comparing(Path::getPage)).forEach(path -> System.out.println("- " + path.getPage() + (path.getDescription() == null ? "" : " - " + path.getDescription()) + " ?"));
        }

        public boolean isValidPath(int page) {
            return this.paths.stream().anyMatch(path -> path.getPage().equals(page));
        }
    }


    @Builder
    @Getter
    public static class Path {
        private Integer page;
        private String description;
    }

}
