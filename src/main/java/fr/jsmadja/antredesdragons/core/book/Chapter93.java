package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.ManualChoiceChapter;
import fr.jsmadja.antredesdragons.core.entities.Pip;

public class Chapter93 extends ManualChoiceChapter {
    @Override
    public Paths getPossiblesPath(Pip pip) {
        return new Paths(
                Path.builder().description("Aller à la tour en ruine").chapter(30).build(),
                Path.builder().description("Retourner au village").chapter(10).build()
        );
    }

    @Override
    public String getText() {
        return "Et si c'était un Gnome de Zurich ? Vous n'imaginez pas le nombre de fois où il a " +
                "compté et recompté votre argent avant de le ranger avec soin dans une bourse en cuir " +
                "fermée d'une serrure. Vous vous rendez compte ! Une bourse avec une serrure ! Mais " +
                "il semble décidé à vous en donner pour votre argent, ce qui est déjà bien. Il vous " +
                "explique que vous pouvez en effet trouver le chemin pour arriver à l'Antre du Dragon " +
                "depuis le village de la Pierre-qui- Mue ; il précise également que ce n'est pas très loin. " +
                "Il vous suffit de vous rendre à la tour en ruine au [30] et d'y chercher une trappe qui " +
                "donne accès à un tunnel, conduisant à son tour au sentier qui vous amènera à l'Antre " +
                "du Dragon. Au comble de l'excitation, vous voulez vous ruer sur-le-champ à la tour en " +
                "ruine. Mais d'un geste, le Gnome vous arrête.\n" +
                "— Un petit conseil dit-il, et gratuit en plus. Il serait peut-être plus sûr de ne pas vous " +
                "rendre à l'Antre du Dragon avant d'avoir exploré à fond le village de la Pierre-quiMue. C'est un endroit dangereux, je ne le sais que trop, mais quelque part y sont " +
                "cachés un ou deux objets qui pourraient faire toute la différence entre la vie et la mort " +
                "quand vous pénétrerez dans l'Antre. Votre vie et votre mort, s'entend.\n" +
                "Mais quels sont ces objets et où vais-je les trouver ? vous exclamez-vous. Le Gnome " +
                "secoue sa tête de gnome.\n" +
                "Le roi Arthur lui-même ne posséderait pas suffisamment d'or dans le Trésor Royal " +
                "pour payer ce genre de renseignements. Et après vous avoir salué poliment, il disparaît " +
                "à l'intérieur de la chaumière, refermant la porte derrière lui.\n" +
                "Lorsque vous tentez de le suivre (ce qui va de soi), VOUS constatez que la porte, qui " +
                "semblait en bois, est faite en réalité de quelque métal d'une grande rareté, et que les " +
                "fenêtres sont garnies de vitres en verre magiquement renforcé et tout à fait incassable. " +
                "La chaumière est aussi impénétrable qu'une chambre forte. Et comme le Gnome refuse " +
                "de ressortir, il ne vous reste plus qu'à consulter de nouveau la carte du village de la " +
                "Pierre-qui-Mue, et à prendre une décision : pousser plus avant votre exploration pour " +
                "essayer de découvrir les objets dont il vous a parlé, ou bien vous rendre " +
                "immédiatement à la tour en ruine.";
    }
}
