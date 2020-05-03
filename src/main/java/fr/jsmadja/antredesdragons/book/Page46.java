package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.pages.ManualChoicePage;

public class Page46 extends ManualChoicePage {
    @Override
    public Paths getPossiblesPath() {
        return new Paths(
                Path.builder().description("Faire confiance à l'arbre").page(77).build(),
                Path.builder().description("Ne pas faire confiance à l'arbre").page(11).build()
        );
    }

    @Override
    public String getText() {
        return "— Bonjour, petite personne, déclare quelque part au dessus de vous une voix " +
                "profonde, mais curieusement bruyante.\n" +
                "Vous levez la tête vers les branches de l'arbre, mas vous ne voyez personne.\n" +
                "— Non, bien sûr, reprend clairement la voix. Ou plutôt si. C'est moi que vous regardez.\n" +
                "— Mais je ne vous vois pas, protestez-vous.\n" +
                "— Si, vous me voyez.\n" +
                "— Vous voulez dire ... que vous êtes l'arbre? Un arbre qui parle ?\n" +
                "— Oui, mais je ne suis pas un vieil arbre ordinaire, dit la voix. Je suis le Chêne du " +
                "Druide. C'est là un arbre tout à fait spécial. Entre parenthèses, méfiez-vous du Lapin, " +
                "il a des dents empoisonnées.\n" +
                "— Merci de me prévenir, répliquez-vous poliment bien qu'abasourdi de parler à un " +
                "arbre (ou du moins de parler à un arbre qui répond). Vous ne savez pas, par hasard, " +
                "comment on sort de cette forêt ?\n" +
                "— Si, bien sûr. Je vis ici depuis cent ans, pas vrai et une de ses grosses branches " +
                "s'incline, comme ployée par un vent violent, et vous indique le nord-est.\n" +
                "Si vous décidez de faire confiance à l'arbre, rendez- vous au [77]. " +
                "Sinon, retournez au [11] et faites un nouveau choix";
    }
}
