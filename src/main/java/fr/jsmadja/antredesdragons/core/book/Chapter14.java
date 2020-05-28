package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.GoNextChapter;

public class Chapter14 extends GoNextChapter {
    @Override
    public String getText() {
        return "Vous ouvrez lentement les yeux. Quelque part dam le lointain, un orchestre invisible " +
                "joue une Marche Funèbre. Vous êtes au milieu de la Grotte de Cristal Merlin est " +
                "penché sur vous, l'air extrêmement mécontent.\n" +
                "— Alors, tu as réussi à te faire tuer, n'est-ce pas ? Quelle négligence ! Eh bien, tu n'as " +
                "plus qu'à recommencer depuis le début. Et tâche de mieux t'y prendre à l'avenir, " +
                "sinon c'en est fait à tout jamais de ma pension. Jette les dés comme je te l'ai déjà " +
                "montré pour te procurer un peu d'argent. Car il faut que tu remplaces le matériel que " +
                "tu as perdu. Tiens, voilà les listes. Tu as toujours ta carte au moins ? C'est heureux ! " +
                "Allez ! va retrouver ta vache, et choisis le bon chemin, cette fois.\n" +
                "Là-dessus, il s'éloigne en marmonnant dans sa barbe à propos des jeunes de nos " +
                "jours... tandis que lentement , mais inexorablement, la grotte commence à s'effacer, " +
                "pour disparaître bientôt complètement.";
    }

    @Override
    public int getNextChapter() {
        return Book.DEBUT;
    }

}
