package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.GoNextChapter;
import fr.jsmadja.antredesdragons.core.entities.Pip;
import fr.jsmadja.antredesdragons.core.execution.Execution;

public class Chapter61 extends GoNextChapter {
    @Override
    public int getNextChapter() {
        return 10;
    }

    @Override
    public Execution execute(Pip pip) {
        pip.restoreAllHealthPoints();
        return super.execute(pip);
    }

    @Override
    public String getText() {
        return "Vous savez quoi ? Pour la première fois dans ce village rébarbatif, vous avez trouvé un " +
                "endroit qui degage une plaisante atmosphère. Vous vous attardez sur le seuil de la " +
                "chaumière, vous laissant envahir par cette agréable sensation. Si vous étiez à court de " +
                "POINTS DE VIE, cette demeure vous a rendu toute votre force, et vous vous retrouvez " +
                "donc en possession de votre total de départ de POINTS DE VIE. Qu'est-ce que vous " +
                "en dites ? Qui plus est, vous pouvez revenir ici après (mais pas pendant) l'exploration " +
                "de n'importe quel endroit du village pour retrouver vos POINTS DE VIE à condition, " +
                "bien entendu, que vous soyez encore dans le village. Maintenant reprenez votre carte " +
                "et explorez ailleurs et ne vous plaignez pas qu'il ne vous arrive jamais rien d'agréable.";
    }
}
