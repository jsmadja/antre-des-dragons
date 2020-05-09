package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.Execution;
import fr.jsmadja.antredesdragons.core.chapters.GoNextChapter;
import fr.jsmadja.antredesdragons.core.entities.Pip;
import fr.jsmadja.antredesdragons.core.inventory.Item;

public class Chapter63 extends GoNextChapter {
    @Override
    public int getNextChapter() {
        return 10;
    }

    @Override
    public Execution execute(Pip pip) {
        pip.restoreAllHealthPoints();
        if (pip.has(Item.COOKING_TOOLS)) {
            pip.add(Item.FOOD);
        }
        return super.execute(pip);
    }

    @Override
    public String getText() {
        return "En approchant de cette chaumière, vous savez aussitôt qu'elle doit être habitée " +
                "puisqu'un filet de fumée sort de la cheminée. Cette supposition se confirme quand, " +
                "après avoir frappé poliment, vous entendez une voix répondre : Entrez !\n" +
                "Cette voix vous est vaguement familière : non que vous l'ayez déjà entendue mais ses " +
                "inflexions ne vous sont pas inconnues. Vous entrez et vous voyez, assis dans un " +
                "fauteuil à bascule devant le feu, une pipe en écume fichée entre les dents... un Vieux " +
                "du Pays en personne !\n" +
                "— Je pensais bien que vous alliez arriver d'un moment à l'autre, déclare-t-il en vous " +
                "dévisageant d'un regard à la fois soulagé, soupçonneux et vindicatif. Vous êtes à la " +
                "recherche du Dragon de Bronze, pas vrai ?\n" +
                "—Eh bien, à vrai dire... commencez-vous. Mais comme la plupart des Vieux du Pays, " +
                "il parle plus qu' il n'écoute et il vous interrompt en secouant la " +
                "tete.\n" +
                "—Eh bien, jeune homme, c'est pas ici que vous le trouverez, faites-moi confiance.\n" +
                "Tous les présages sont mauvais.\n" +
                "—Non, répondez-vous. Je ne m'attendais pas vraiment à trouver...\n" +
                "—Il faut aller jeter un coup d'oeil dans l'Antre du Dragon, vous coupe-t-il. C'est là que " +
                "vous avez le plus de chance de le trouver, s'il n'est pas en train de ravager et de piller " +
                "le pays, et de dévorer des évêques presbytériens ou autres personnages du même " +
                "acabit.\n" +
                "—Ma foi, en réalité, je cherchais justement l'Antre du Dragon. Vous ne savez pas, par " +
                "hasard, où...\n" +
                "—Et ne me demandez pas où peut bien se trouver l'Antre du Dragon, interrompt " +
                "encore une fois le Vieux du Pays. Je n'approuve pas ce genre d'endroits. Ce sont des " +
                "repaires d'iniquités, je les évite donc.\n" +
                "Il se lève, la pipe toujours fermement coincée entre ses dents.\n" +
                "—Vous mangeriez bien un peu de ragoût, je parie. Les jeunes de votre âge ont toujours " +
                "faim.\n" +
                "—Non, sincèrement... dites-vous poliment, bien qu'en vérité vous vous sentiez un petit " +
                "creux.\n" +
                "—C'est bien ce que je pensais, dit le Vieux du Pays. Je vais vous en donner un bol " +
                "maintenant et un bol à emporter, si vous avez de quoi le transporter. Il contient de la " +
                "feuille de laurier et de l'armoise, et il guérira tous les maux dont vous souffrez.\n" +
                "Un ragoût curatif ? demandez-vous en regardant la marmite noire posée sur le feu.\n" +
                "— Oui da, et n'ayez pas l'air aussi surpris. Vous ne connaissez pas le vieux proverbe :\n" +
                "Si la maladie te ronge,\n" +
                "Qu'elle s'aggrave et se prolonge,\n" +
                "Prends donc, il n 'est rien de mieux,\n" +
                "Un bol de ragoût des Vieux.\n" +
                "— Eh bien, non, avouez-vous. Je ne le connaissais pas du tout.\n" +
                "Maintenant vous le connaissez, dit-il d'un ton abrupt. Un bol suffit pour guérir " +
                "n'importe quelle maladie, n'importe quelle blessure. Vous sentirez les points de vie " +
                "circuler en vous comme la sève au printemps. Et, se servant d'une louche accrochée à " +
                "un clou près de la cheminée, il vous remplit un bol. Lequel bol va vous restituer " +
                "naturellement la totalité de vos points de vie si, par hasard, vous en avez perdu, et " +
                "guérir toute maladie que vous auriez pu contracter durant votre aventure. De plus, si " +
                "vous avez eu la bonne idée d'emporter des ustensiles de cuisine, vous pouvez prendre " +
                "avec vous un bol de ragoût que vous avalerez plus tard si vous perdez d'autres points " +
                "de vie. (Mais il faut que vous ayez des ustensiles de cuisine, car le ragoût du Vieux " +
                "n'opère que s'il est consommé chaud.) Pour l'instant, retournez à la carte du village et " +
                "continuez votre exploration.";
    }
}
