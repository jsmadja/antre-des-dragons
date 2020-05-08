package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.GoNextChapter;

public class Chapter37 extends GoNextChapter {
    @Override
    public int getNextChapter() {
        return 13;
    }

    @Override
    public String getText() {
        return "Ouille, ouille, ouille ! Quel combat ! Pendant un moment, vous avez bien cru que vous " +
                "n'alliez pas vous en tirer. Cela montre ce qu'on peut accomplir grâce au courage, à " +
                "l'habileté et à la détermination. vous vous attardez un moment pour reprendre des " +
                "forces, puis vous poursuivez votre chemin. Rendez- vous au [13].";
    }
}
