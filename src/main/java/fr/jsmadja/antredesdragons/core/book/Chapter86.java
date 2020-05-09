package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.GoNextChapter;
import fr.jsmadja.antredesdragons.core.entities.Pip;
import fr.jsmadja.antredesdragons.core.inventory.Item;

public class Chapter86 extends GoNextChapter {

    @Override
    public String getText() {
        return "— Non! Non! glapit E.J., paniquée, quand vous avancez d'un pas. J'ai un affreux " +
                "pressentiment ! Une terrible intuition ! J'ai... Mais la stupeur lui coupe la parole. " +
                "Le passage secret vous a amené dans une vaste caverne souterraine, grande comme " +
                "une cathédrale et taillée (à en juger par les murs) par la main de l'homme directement " +
                "dans le socle rocheux en dessous du village de Pierre-qui-Mue. La caverne est " +
                "illuminée par des cristaux étincelants sertis dans les parois et dans les colonnes de " +
                "pierre naturelle qui supportent la voûte. Et sous cette voûte, montant du sol de pierre, " +
                "s'épanouissent des fleurs, des buissons, des champignons de cristal, de toutes les " +
                "tailles, formes et couleurs possibles, tous translucides ou transparents, reflétant la " +
                "lumière, brillant de mille feux, transformant le décor en une véritable féérie. Et peut-être se trouve-t-on vraiment au Pays des Fées, à en juger par les petites créatures ailées " +
                "qui volètent parmi les fleurs. Vous vous immobilisez, le souffle coupé par ce " +
                "spectacle. Les petites créatures ailées (se pourrait-il que ce soient vraiment des Fées ?) " +
                "ne vous prêtent aucune attention. Mais il y a une autre créature dans cette caverne, plus " +
                "grande et beaucoup plus majestueuse. Un être mince, de haute taille, avec une peau " +
                "d'argent et de grands yeux dorés. Ces yeux se fixent sur vous à l'instant même oû vous " +
                "entrez. A votre côté, vous sentez E.J. qui se met à vibrer.\n" +
                "La créature — l'être le plus beau peut-être que vous ayez jamais vu — se dirige vers " +
                "vous, s'arrêtant à moins de dix mètres. Ses yeux dorés semblent vous fixer jusqu'au " +
                "fond de l'âme. Elle prend la parole.\n" +
                "Les mortels qui pénètrent ici sont souvent obligés d'y rester à jamais.\n" +
                "Je te l'avais dit ! chuchote E.J. d'une voix sifflante. Cette fois, tu as réussi !\n" +
                "Mais la créature continue à parler, et sa voix mélodieuse résonne dans votre esprit.\n" +
                "Mais je sens que ton âme est pure et qu'une tâche urgente t'attend. Par conséquent, tu " +
                "peux prendre ce que tu cherches et repartir en paix. Et elle se détourne pour " +
                "s'éloigner.\n" +
                "Ce que vous cherchez ? Mais vous ne savez même pas ce que vous cherchez !\n" +
                "Excusez-moi, lancez-vous. Excusez moi... monsieur. La royale créature se retourne et " +
                "attend. Je crains de ne pas savoir du tout où je me trouve, balbutiez-vous.\n" +
                "Tu es parvenu à l'entrée du Royaume du Sidhe. Ton destin, je le vois, va peut-être " +
                "t'entraîner un jour à t'y aventurer. Mais, pour le moment, tu ne peux pas aller au-delà " +
                "de cette caverne.\n" +
                "Tout cela ne signifie pas grand-chose. Mais vous enchaînez précipitamment : " +
                "En réalité, je ne cherche rien, vous savez. Je suis tombé par hasard sur ce passage et " +
                "j'étais intrigué. Puis, une soudaine inspiration vous pousse à ajouter : Mon épée m'a " +
                "dit de venir ici.\n" +
                "La créature sourit.\n" +
                "Peut-être bien. Et puisque tu ne veux rien, la coutume de ma race veut que nous te " +
                "donnions quelque chose. Donne-moi ton épée, je te prie.\n" +
                "Non ! hurle E.J. qui, prise de faiblesse, s'évanouit et sombre dans le silence. Poussé par " +
                "une force inconnue, vous tendez E.J. à la créature d'argent qui passe rapidement la " +
                "main sur la lame. Puis, elle vous rend votre épée.\n" +
                "Quand ton épée s'éveillera, elle sera légèrement différente. Dorénavant, elle infligera " +
                "10 Points de Dommage supplémentaires aux Dragons, quand tu les combattras. Va, " +
                "maintenant.\n" +
                "Et cette fois, lorsque la créature d'argent se détourne, les cristaux perdent peu à peu de " +
                "leur éclat. Vous vous hâtez de repartir par le passage secret. Quelle histoire ! Respirez " +
                "profondément pour vous calmer, et reprenez la carte du village. Mais n'oubliez pas : " +
                "E.J. infligera 10 Points de Dommage supplémentaires aux Dragons, quand vous les " +
                "combattrez";
    }

    @Override
    protected void beforeLeavingChapter(Pip pip) {
        pip.unequip(Item.EXCALIBUR_JUNIOR);
        pip.equip(Item.EXCALIBUR_JUNIOR_DRAGON_SLAYER);
        super.beforeLeavingChapter(pip);
    }

    @Override
    public int getNextChapter() {
        return 10;
    }
}
