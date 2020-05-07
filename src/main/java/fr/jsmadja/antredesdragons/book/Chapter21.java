package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.chapters.ManualChoiceChapter;
import fr.jsmadja.antredesdragons.stuff.Item;

import java.util.ArrayList;
import java.util.List;

public class Chapter21 extends ManualChoiceChapter {
    @Override
    public String getText() {
        return "Vous suivez le chemin, bordé de part et d'autre par la forêt, en direction du nord-est. " +
                "Les arbres sont toujours aussi serrés, aussi sombres et menaçants mais, du moins, le " +
                "sentier devant vous semble dégagé et libre de tout obstacle. Jusqu'au moment en fait, " +
                "où vous arrivez au bord d'un gouffre. Mmmm... Vous vous en approchez. A vos pieds " +
                "s'ouvre un à-pic de près de soixante mètres. Tout au fond coule une rivière turbulante, " +
                "rapide. Levant les yeux, vous constatez que le sentier reprend de l'autre côté de " +
                "l'abîme, dont vous estimez la largeur à environ cinq ou six mètres. Si vous prenez " +
                "suffisamment d'élan, peut-être pourriez-vous le franchir d'un bond. Mais, par ailleurs, " +
                "vous êtes fatigué et lourdement chargé. Vérifions de quel matériel vous disposez. " +
                "Si vous possédez dans votre équipement une corde, des crampons d'escalade ou une " +
                "hâche (ou une hâche d'armes), rendez-vous au [7]. si vous voulez tenter de sauter, " +
                "rendez-vous au [18]. Si vous pensez pouvoir trouver un moyen de traverser en pénétrant " +
                "de nouveau dans la forêt, rendez-vous au [5].";
    }

    @Override
    public Paths getPossiblesPath(Pip pip) {
        List<Path> paths = new ArrayList<>();
        paths.add(Path.builder().chapter(18).description("Sauter").build());
        paths.add(Path.builder().chapter(5).description("Retourner dans la forêt").build());
        if (pip.has(Item.AXE)) {
            paths.add(Path.builder().chapter(7).description("Utiliser une hâche").build());
        }
        return new Paths(paths);
    }
}
