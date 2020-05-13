package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.Answer;
import fr.jsmadja.antredesdragons.core.chapters.Chapter;
import fr.jsmadja.antredesdragons.core.chapters.YesOrNoQuestion;
import fr.jsmadja.antredesdragons.core.entities.Pip;
import fr.jsmadja.antredesdragons.core.execution.Action;
import fr.jsmadja.antredesdragons.core.execution.Execution;

import java.util.ArrayList;
import java.util.List;

import static fr.jsmadja.antredesdragons.core.chapters.ChapterNumber.chapter;
import static fr.jsmadja.antredesdragons.core.inventory.Item.MAGIC_WAND;
import static fr.jsmadja.antredesdragons.core.spellcasting.SpellBook.FIREBALL;

public class Chapter151 extends Chapter {
    @Override
    public String getText() {
        return "La galerie que vous suivez maintenant, est creusée à même le roc, et donne plutôt " +
                "l'impression d'une fissure naturelle, élargie par endroits pour faciliter le passage. " +
                "Tandis que vous progressez dans ce passage, une pensée vous vient à l'esprit. Quelle " +
                "que soit la raison de la présence de cette invraisemblable machine à l'époque du roi " +
                "Arthur, il est évident qu'elle vous a expédié ailleurs, et qu'il vous est impossible de " +
                "revenir sur vos pas. Qu'importe après tout ! Un aventurier courageux doit toujours aller " +
                "de l'avant. Et c'est précisément ce que vous faites : soudain, une nouvelle caverne se " +
                "présente à vous. Vous avez un instant d'hésitation, car elle est totalement différente de " +
                "celles que vous avez visitées jusqu'à présent. On dirait qu'elle a été formée de roches " +
                "liquides, car ses parois sont lisses, et sa forme évoque celle d'un gigantesque " +
                "entonnoir. Vous avancez avec précaution. La pente est de plus en plus raide, et la " +
                "caverne se rétrécit autour de vous. Tous les sens en alerte, vous progressez maintenant " +
                "pas à pas, et... oh, non ! le fond de la caverne est obstrué par un énorme rocher ! Que " +
                "faire ? Apparemment, le rocher semble impossible à déplacer.\n" +
                "Vous pouvez lancer les dés, mais une seule fois. Si vous obtenez 10, 11 ou 12, le " +
                "rocher n'est pas aussi pesant que vous l'imaginiez, et vous parvenez à le faire basculer " +
                "sur le côté.\n" +
                "Si vous ne sortez pas ces chiffres, une Boule de Feu peut dégager le passage. S'il ne " +
                "vous reste plus de Boules de Feu, ou si vous préférez ne pas en utiliser ici, vous " +
                "pouvez vous servir d'une baguette magique (si vous en avez trouvé une). Elle " +
                "dissoudra lentement le bloc de rocher, et le transformera en boue... mais au prix " +
                "exorbitant de 25 POINTS DE VIE. Vous pouvez perdre la vie dans cette affaire : " +
                "aussi, avant d'agiter la baguette, vérifier bien votre total de POINTS DE VIE, pour ne " +
                "pas échouer, une fois de plus, au [14].\n" +
                "\n" +
                "Dès que vous aurez réussi à franchir cet obstacle, rendez-vous au [153]. Sinon, " +
                "impossible de faire demi-tour : les parois de la caverne sont trop lisses, et la pente " +
                "trop abrupte. Vous allez vous ennuyer un bon moment dans ce sinistre lieu, avant de " +
                "vous retrouver au [14].";
    }

    @Override
    public Execution execute(Pip pip, String questionId, Answer answer) {
        if (questionId == null) {
            List<Action> actions = new ArrayList<>();
            if (pip.canUse(FIREBALL)) {
                YesOrNoQuestion question = YesOrNoQuestion.question("Q151-1", "Utiliser une boule de feu");
                actions.addAll(question.toActionsForChapter(chapter(151)));
            }
            if (pip.has(MAGIC_WAND)) {
                YesOrNoQuestion question = YesOrNoQuestion.question("Q151-2", "Utiliser la baguette magique");
                actions.addAll(question.toActionsForChapter(chapter(151)));
            }
            if (!actions.isEmpty()) {
                return Execution.builder().logEntries(pip.getCurrentChapterLogEntries()).actions(actions).build();
            }
            if (pip.roll2Dices().isBetween(10, 12)) {
                return goToNextChapter(pip);
            }
        }
        if (questionId.equals("Q151-1") && answer.isYes() && pip.canUse(FIREBALL)) {
            if (pip.use(FIREBALL).withSuccess()) {
                return goToNextChapter(pip);
            }
            return pip.goToChapter(151);
        }
        if (questionId.equals("Q151-2") && answer.isYes() && pip.has(MAGIC_WAND)) {
            pip.wounds(25);
            if (pip.isDead()) {
                return pip.goToChapter(14);
            }
            return goToNextChapter(pip);
        }
        return pip.goToChapter(14);
    }

    private Execution goToNextChapter(Pip pip) {
        return pip.goToChapter(153);
    }

}
