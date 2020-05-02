package fr.jsmadja.antredesdragons.pages.types;

import fr.jsmadja.antredesdragons.ui.Prompt;
import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.pages.content.PageNumber;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

import static java.text.MessageFormat.format;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public abstract class ManualChoicePage extends Page {

    @Override
    public Execution execute(Pip pip) {
        return askWhichWay(pip);
    }

    public Execution askWhichWay(Pip pip) {
        Paths possiblesPath = getPossiblesPath();
        possiblesPath.print();
        Prompt.NumberAnswer path = Prompt.question("Quel chemin prendre", possiblesPath.getPages());
        return pip.goToPage(PageNumber.of(path.getAnswer()));
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
            paths.stream().sorted(comparing(Path::getPage)).forEach(System.out::println);
        }

        private List<Integer> getPages() {
            return paths.stream().map(Path::getPage).collect(toList());
        }
    }

    @Builder
    @Getter
    public static class Path {
        private Integer page;
        private String description;

        @Override
        public String toString() {
            return format("- {0}{1} ?", page, description == null ? "" : " - " + description);
        }
    }

}
