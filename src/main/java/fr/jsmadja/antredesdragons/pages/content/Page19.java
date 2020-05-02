package fr.jsmadja.antredesdragons.pages.content;

import fr.jsmadja.antredesdragons.pages.types.ManualChoicePage;

public class Page19 extends ManualChoicePage {
    @Override
    public Paths getPossiblesPath() {
        return new Paths(
                Path.builder().description("Combattre avec des armes").page(15).build(),
                Path.builder().description("Utiliser la magie").page(12).build(),
                Path.builder().description("Utiliser une arme magique").page(32).build()
        );
    }

    @Override
    public String getText() {
        return "Quelqu'un avance dans votre direction le long de la route. Une créature gigantesque. " +
                "Elle a une curieuse démarche en outre, se balançant d'un côté sur l'autre comme si elle " +
                "éprouvait quelque difficulté à garder son équilibre. Elle doit peser une tonne : le sol " +
                "tremble sous ses pas. Et elle est d'une étrange couleur : une sorte de gris ardoise. Tout " +
                "cela ne présage rien de bon Pip ! Elle marche droit sur vous. Nom d'un petit " +
                "bonhomme ce n'est pas un homme du tout. C'est... c'est... c'est une statue ! Une statue " +
                "qui marche ! Un Homme de Pierre ! Et qui tient une épée de pierre !\n" +
                "— Dites donc, un instant ! lancez-vous en voyant l'Homme de Pierre arriver " +
                "pesamment sur vous. Mais c'est peine perdue. Déjà il brandit son épée. Il va falloir " +
                "combattre, Pip. Vous ne pouvez l'éviter, quel que soit votre amour de la paix. Il faut " +
                "tuer, ou être tué ici même. Mais vos armes seront-elles efficaces contre un Homme de " +
                "Pierre? Il n'y a qu'une façon de le savoir.\n" +
                "Allez-vous essayer de combattre avec des armes ? Rendez-vous au [15].\n" +
                "Décidez-vous d'utiliser la magie ? Rendez-vous au [12].\n" +
                "Si vous préférez vous servir d'une arme magique (E.J. par exemple), rendez-vous au\n" +
                "[32].";
    }
}
