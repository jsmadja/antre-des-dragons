package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.pages.DiceWay;
import fr.jsmadja.antredesdragons.pages.Execution;
import fr.jsmadja.antredesdragons.pages.RollAndGoPage;

import java.util.List;

public class Page171 extends RollAndGoPage {
    @Override
    protected List<DiceWay> getDiceWays(Pip pip) {
        return List.of(
                DiceWay.builder().from(2).to(4).pageNumber(PageNumber.page(156)).build(),
                DiceWay.builder().from(5).to(12).pageNumber(PageNumber.page(14)).build()
        );
    }

    @Override
    public Execution execute(Pip pip) {
        if (pip.isImmuneToPoison()) {
            return pip.goToPage(156);
        }
        return super.execute(pip);
    }

    @Override
    public String getText() {
        return "Une aiguille jaillit du moraillon et vous perce le pouce. Vous ressentez aussitôt une " +
                "douleur cuisante qui se transforme très vite en une brûlure intolérable, tandis que " +
                "votre bras tout entier se met à enfiler. Bien inquiétant, non ? Cette aiguille, de toute " +
                "évidence, était empoisonnée, Pip. Si vous n'êtes pas protégé contre le poison, lancez " +
                "deux dés.\n" +
                "Si vous faites de 2 à 4, vous êtes naturellement immunisé. Retournez au [156], et " +
                "essayez une autre méthode (plus sûre, espérons-le) pour ouvrir le coffre.\n" +
                "Si vous faites de 5 à 12, le poison vous terrasse. Rendez-vous au 14.";
    }
}
