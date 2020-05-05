package fr.jsmadja.antredesdragons.pages;

import fr.jsmadja.antredesdragons.book.PageNumber;
import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.ui.Prompt;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

import static java.text.MessageFormat.format;
import static java.util.Arrays.asList;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public abstract class ManualChoicePage extends Page {

    @Override
    public Execution execute(Pip pip) {
        this.beforeLeavingPage(pip);
        return askWhichWay(pip);
    }

    protected void beforeLeavingPage(Pip pip) {
    }

    public Execution askWhichWay(Pip pip) {
        Paths possiblesPath = getPossiblesPath(pip);
        possiblesPath.print();
        Prompt.NumberAnswer path = Prompt.answerTo("Quel est votre choix", possiblesPath.getPages());
        return pip.goToPage(PageNumber.page(path.getAnswer()));
    }

    public abstract Paths getPossiblesPath(Pip pip);

    public static class Paths {
        private final List<Path> paths;

        public Paths(Path... paths) {
            this(List.of(paths));
        }

        public Paths(List<Path> paths) {
            this.paths = paths;
        }

        public void print() {
            paths.stream().sorted(comparing(Path::getPage)).forEach(System.out::println);
        }

        private List<Integer> getPages() {
            return paths.stream().map(Path::getPage).collect(toList());
        }

        public void add(Path... paths) {
            this.paths.addAll(asList(paths));
        }
    }

    @Builder
    @Getter
    public static class Path {
        private Integer page;
        private String description;

        @Override
        public String toString() {
            return format("- {0}{1}", page, description == null ? "" : " - " + description);
        }
    }

}
