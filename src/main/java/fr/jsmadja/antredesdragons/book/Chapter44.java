package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.dices.Roll;
import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.chapters.DeadlyChapter;
import fr.jsmadja.antredesdragons.chapters.Execution;

import static fr.jsmadja.antredesdragons.stuff.Item.CLEATS;

public class Chapter44 extends DeadlyChapter {
    @Override
    public String getText() {
        return "Vous pénétrez dans la chaumière et vous tombez dans une trappe. Désolé d'être aussi " +
                "brutal, Pip. mais quand vous avez des ennuis, il est indispensable que vous le sachiez " +
                "immédiatement. Et peut-être avez-vous de graves ennuis.\n" +
                "Tout d'abord, le fond de la fosse est hérissé de pointes acérées. Lancez deux dés pour " +
                "savoir si l'une ou l'autre vous a embroché. Si vous faites de 2 à 6 " +
                "l’une au moins vous a blessé. Si vous faites de 7 à 12, vous les avez évitées par " +
                "miracle. Si vous êtes embroché, lancez vos dés de nouveau pour savoir quels " +
                "dommages ont subi vos POINTS DE VIE vous n'avez plus de points, vous êtes mort, et" +
                "rendez-vous au [14]. Si vous êtes toujours en vie, les mauvaises nouvelles ne font que " +
                "commencer : les piques sont empoisonnées. Lancez deux dés de nouveau pour savoir " +
                "si vous êtes naturellement immunisé. De 2 à 6, le poison ne vous fait aucun mal. De 7 à " +
                "12, le poison est mortel ; rendez-vous au [14]. Même si vous n'êtes pas tombé sur les " +
                "piques, il vous faut néanmoins sortir de là. Si vous avez emporté du matériel " +
                "d'escalade, comme des crampons et une corde, vous pouvez remonter assez facilement. " +
                "Reprenez votre carte et explorez une autre partie du village. Si vous ne disposez pas du " +
                "matériel nécessaire, vous êtes prisonnier de la fosse où vous allez mourir de faim. " +
                "Rendez-vous au [14].";
    }

    @Override
    public Execution execute(Pip pip) {
        Roll spikesRoll = pip.roll2Dices();
        if (spikesRoll.isBetween(2, 6)) {
            pip.wounds(pip.roll2Dices().getValue());
            if (pip.isDead()) {
                return super.execute(pip);
            }
            if (pip.roll2Dices().isBetween(7, 12)) {
                return super.execute(pip);
            }
        }
        if (pip.has(CLEATS)) {
            return pip.goToChapter(10);
        }

        return super.execute(pip);
    }
}
