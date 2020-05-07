package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.chapters.Execution;
import fr.jsmadja.antredesdragons.chapters.Chapter;

public class Chapter201 extends Chapter {
    @Override
    public String getText() {
        return "• Il y aura un banquet, bien entendu, déclara Merlin d'un air pensif, et un tournoi et " +
                "ainsi de suite, avec moi-même comme invité d'honneur, et une place pour toi au haut " +
                "bout de la table, jeune Pip, pour célébrer l'exploit que tu as accompli en débarrassant " +
                "le Royaume de ce monstre.\n" +
                "• Est-ce que je peux amener mon ami Ethelbert ? demanda Pip.\n" +
                "• S'il fait un peu de toilette, répondit Merlin d'un ton appuyé.\n" +
                "Son regard se voila de nouveau tandis qu'il s'absorbait dans ses réflexions. " +
                "Ma pension me sera rendue ; peut-être même sera-t-elle augmentée, car Arthur a " +
                "tendance à se montrer fort généreux dans des situations comme celle-ci. Tu peux " +
                "garder tous les trésors que tu as ramassés, Pip. Achète-toi un château ou je ne sais " +
                "quoi, une belle ferme peut-être pour tes parents adoptifs. Le Roi sera peut-être même " +
                "tenté de t'ano- blir. Tu es encore un peu jeune pour ça, mais qui sait ? A mon avis, " +
                "nous allons disposer de pas mal de temps pour être heureux avant que les ennuis ne " +
                "recommencent.\n" +
                "• Les ennuis ? fit Pip, en clignant des paupières.\n" +
                "• Eh oui, dit Merlin. Tu as fait du très beau travail en tuant le Dragon de Bronze, " +
                "aucun doute à ce sujet. Mais la Porte est toujours ouverte.\n" +
                "• La Porte, répéta Pip.\n" +
                "• La Porte du Sinistre Royaume des Morts, précisa sèchement Merlin. Je t'en ai " +
                "parlé, rappelle-toi. Tant qu'elle restera ouverte le Royaume courra toutes sortes de " +
                "dangers. Enfin, tu pourras toujours régler ce problème lorsque tu auras repris ton " +
                "souffle, savouré le festin et ainsi de suite. Ta bataille avec le Dragon de Bronze, je te " +
                "le signale, n'était qu'une plaisanterie comparée aux dangers que tu devras affronter " +
                "quand tu entreras dans le Sinistre Royaume des Morts. Il sourit. Mais j'ai toute " +
                "confiance en toi maintenant, Pip. Oui, vraiment. Si quelqu'un peut réussir, c'est bien " +
                "toi, j'en suis persuadé. Alors ne t'inquiète de rien. Retourne dans ton propre Temps " +
                "pour te reposer un peu, et je t'appellerai de nouveau quand j'aurai besoin de toi pour " +
                "attaquer le Sinistre Royaume.\n" +
                "Oui. Ce sera votre prochaine aventure, Pip. Votre prochaine victoire, si vous y " +
                "survivez. Un endroit terrifiant, bien sûr, mais vous triompherez une fois de plus. " +
                "Sans aucun doute. Et je ferai appel à vous. Sans aucun doute.";
    }

    @Override
    public Execution execute(Pip pip) {
        return Execution.empty();
    }
}
