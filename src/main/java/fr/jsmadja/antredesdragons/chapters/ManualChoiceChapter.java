package fr.jsmadja.antredesdragons.chapters;

import fr.jsmadja.antredesdragons.book.ChapterNumber;
import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.ui.Prompt;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

import static java.text.MessageFormat.format;
import static java.util.Arrays.asList;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public abstract class ManualChoiceChapter extends Chapter {

    @Override
    public Execution execute(Pip pip) {
        this.beforeLeavingChapter(pip);
        return askWhichWay(pip);
    }

    public Execution askWhichWay(Pip pip) {
        Paths possiblesPath = getPossiblesPath(pip);
        possiblesPath.print();
        Prompt.NumberAnswer path = Prompt.answerTo("Quel est votre choix", possiblesPath.getChapter());
        return pip.goToChapter(ChapterNumber.chapter(path.getAnswer()));
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
            paths.stream().sorted(comparing(Path::getChapter)).forEach(System.out::println);
        }

        private List<Integer> getChapter() {
            return paths.stream().map(Path::getChapter).collect(toList());
        }

        public void add(Path... paths) {
            this.paths.addAll(asList(paths));
        }
    }

    @Builder
    @Getter
    public static class Path {
        private Integer chapter;
        private String description;

        @Override
        public String toString() {
            return format("- {0}{1}", chapter, description == null ? "" : " - " + description);
        }
    }

}
