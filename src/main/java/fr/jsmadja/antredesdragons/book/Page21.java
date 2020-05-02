package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.pages.ManualChoicePage;

public class Page21 extends ManualChoicePage {
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
    public Paths getPossiblesPath() {
        return new Paths(
                Path.builder().page(18).description("Sauter").build(),
                Path.builder().page(7).description("Utiliser une hâche").build(),
                Path.builder().page(5).description("Retourner dans la forêt").build()
        );
    }
}
