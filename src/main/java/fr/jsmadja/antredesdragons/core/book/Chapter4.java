package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.GoNextChapter;
import fr.jsmadja.antredesdragons.core.entities.Pip;
import fr.jsmadja.antredesdragons.core.market.GoldenCoins;

import static fr.jsmadja.antredesdragons.core.book.Book.MARKET;
import static fr.jsmadja.antredesdragons.core.entities.AdventureMap.BEGINNER_MAP;

public class Chapter4 extends GoNextChapter {

    public static final int DICE_GOLDEN_COIN = 1;

    @Override
    public String getText() {
        return "- C'est tout ? demandez-vous en fronçant les sourcils.\n" +
                "- Mais non, répond Merlin. Ne sois pas si impatient. Parfois, tu rencontreras " +
                "des créatures qui te paraîtront dangereuses, mais qui en fait ne le seront " +
                "peut-être pas autant qu'elles en auront l'air. Pour le savoir, tu lanceras une " +
                "fois un dé pour chacune d'elles, et trois fois un dé pour toi. Si le total des " +
                "points que tu obtiens alors est inférieur au chiffre obtenu par la créature qui " +
                "te fait face, elle aura à ton égard une Réaction Amicale, et tu pourras " +
                "continuer ton chemin sans encombre. Si tout ce que je viens de te dire te " +
                "dépasse, saches que tu peux essayer de récupérer quelques points de vie en " +
                "dormant, et ce en toute circonstance, sauf lorsque tu te trouveras engager " +
                "dans un combat. Mais cela n'est quand même pas aussi simple qu'il y paraît. " +
                "D'ailleurs, je me demande bien ce qui peut être encore simple depuis que ce " +
                "maudit Dragon de Bronze s'est échappé ! Enfin, peu importe... Nous parlions " +
                "de quoi déjà ? Ah oui ! des points que tu peux gagner en dormant. Toutes les " +
                "fois que tu voudras dormir, tu lanceras un dé. Si tu obtiens 1, 2, 3 ou 4, ton " +
                "sommeil sera agité de songes, et tu devras te reporter au chapitre intitulé " +
                "Temps du Rêve, à la fin du volume page 207). Mais n'oublie pas ceci : tu " +
                "risques alors de perdre des points de vie au lieu d'en gagner. Si tu fais 5 ou " +
                "6, ton sommeil aura été profond et t'aura «donné des forces. Lance alors " +
                "deux dés : le chiffre que tu obtiendras correspondra au nombre de points que " +
                "tu pourras ajouter à ton total de points de vie. Tu vois qu'il est risqué de " +
                "dormir à mon époque. De toute façon, tu seras certainement trop occupé à " +
                "combattre pour le faire et donc, tu vas avoir besoin d’un solide équipement, " +
                "d'armes...\n" +
                "- Et de la magie ! ajoutez-vous vivement, vous demandant dans quelle " +
                "invraisemblable situation vous vous trouvez.\n" +
                "- Et de la magie. Car sans magie, tu n'irais pas bien loin contre un Dragon de " +
                "Bronze. Tiens, prends ceci. Et des plis de sa robe, il sort un parchemin qu'il " +
                "vous tend et que vous déroulez. Comme tous les parchemins de Merlin, il est " +
                "constellé de toutes sortes de taches. Vous espériez qu'il s'agissait de quelque " +
                "chose de magique, mais ce n'est pas le cas. néanmoins, votre nom est écrit " +
                "dessus, interloqué, vous levez les yeux vers Merlin.\n" +
                "- Qu'est-ce que c'est ?\n" +
                "Il semble gêné, et évite votre regard.\n" +
                "- Une liste de courses... quelques objets dont tu pourrais avoir besoin.\n" +
                "- Mais pourquoi le prix est-il indiqué auprès de chacun d'eux ?\n" +
                "Merlin toussotte.\n" +
                "- Tu vas être obligé d'acheter ton propre matériel, je le crains. Comme le roi " +
                "risque de me supprimer ma pension, je ne peux me permettre de t'équiper.\n" +
                "- Mais je n'ai pas d'argent ! protestez-vous.\n" +
                "— Tout à fait exact, acquiesce Merlin. Et cela aurait pu être un vrai problème si je ne " +
                "l'avais prévu. Il se dirige vers un petit placard en cristal qu il ouvre, et dont il sort " +
                "deux cubes transparents qui, constatez-vous en les regardant de plus près, sont des " +
                "dés.\n" +
                "— Des dés magiques, précise-t-il d'un ton bref,ils transforment l'enthousiasme en " +
                "argent. Je ne peux les utiliser moi-même, car il ne me reste plus guère d'enthousiasme " +
                "depuis qu'Arthur a évoqué le sort qu'il réserve à ma pension. Mais un intrépide aven" +
                "turier comme toi doit déborder d'enthousiasme. Prends-les, et jette-les à terre d'une " +
                "main ferme. Vous suivez ses instructions et, à peine les dés ont- ils touché le sol qu'ils " +
                "explosent en un éclair silencieux de lumière dorée. Mais juste avant que l'explosion ne " +
                "se produise, vous avez pu voir les points que vous avez faits (lancez vos deux dés pour " +
                "le savoir). Chaque point vaut une Pièce d'Or. Et une Pièce d'Or vaut 10 Pièces " +
                "d'Argent. Tout compte fait, il semble bien que vous allez être en mesure de vous " +
                "procurer votre équipement ! (Notez le nombre de Pièces d'Argent dont vous disposez " +
                "sur votre Feuille d'Aventure.) Mais Merlin toussote de nouveau.\n" +
                "— Les armes, maintenant. Et une armure, si tu en veux une. " +
                "Il fouille une fois de plus sa longue robe, et vous tend une autre liste.\n" +
                "— Les armes et les armures coûtent un prix fou, de nos jours...\n" +
                "Vous considérez les deux listes, puis vous regardez Merlin, l'air accablé. Cette mission " +
                "va vous coûter les yeux de la tête ! Il s'agit maintenant de dépenser judicieusement " +
                "votre argent, afin de vous équiper le mieux possible pour mettre le maximum de " +
                "chances de votre côté. Et n'oubliez pas que tous les prix sont donnés en Pièces " +
                "d'Argent, et qu'une Pièce d'Or vaut 10 Pièces d'Argent. " +
                "Réfléchissez bien avant d'acheter quoi que ce soit. Vous possédez déjà une épée " +
                "redoutable, Excalibur Junior. Mais E.J. a parfois des moments d'humeur pendant " +
                "lesquels elle ne se montre pas particulièrement coopérative ! De toute évidence, il " +
                "serait prudent de vous munir d'une arme supplémentaire. Mais attention : vous ne " +
                "pourrez jamais utiliser deux armes à la fois. Si vous disposez de peu de POINTS DE " +
                "VIE, peut-être serait-il sage d'investir dans une armure, bien que ce soit un objet très " +
                "coûteux, et qu'il ne vous resterait pratiquement plus d'argent pour acquérir d'autres " +
                "objets de première nécessité. si VOUS avez accompli avec succès une première mission " +
                "dans Le Château des Ténèbres, vous avez en votre possession le pourpoint en peau de " +
                "dragon. vous pouvez le porter sous une armure, ce qui vous protégera d'autant mieux. " +
                "Il vous faudra certainement accomplir un long trajet, avant de découvrir ce Dragon de " +
                "Bronze déchaîné. Ce serait donc une bonne idée de faire une bonne provision de " +
                "nourriture. à moins que vous n'envisagiez de vous débrouiller en cours de route. Mais " +
                "vous êtes tout à fait libre de choisir ce qui vous semblera le plus utile. Et n'oubliez pas " +
                "de noter tous vos achats dans la case correspondante de votre Feuille d'Aventure.\n" +
                "— Alors, voyons voir, dit Merlin. Tordre est en nous ?... euh... tout est en ordre ?\n" +
                "Dans son impatience à vous voir partir (ce qui lui permettra de s'occuper de sa " +
                "pension), il s'est mis à bafouiller.\n" +
                "— Je crois que oui, répondez-vous sans conviction. Sauf que je ne vois pas vraiment " +
                "où aller...\n" +
                "— Ne t'inquiète pas pour cela, coupe Merlin. J'ai suivi ce stupide monstre sur ma boule " +
                "de cristal, et je sais où il se cache. Dans l'Antre du Dragon. Parfaitement logique, en " +
                "fait. La plupart des Dragons se cachent dans l'Antre du Dragon entre leurs expéditions " +
                "de pillage et leurs multiples exactions. Cet endroit fourmille de Dragons de toutes " +
                "sortes. Et de jeunes filles, bien entendu. Mais il n'y a qu'un seul Dragon de Bronze, " +
                "celui dont tu dois nous débarrasser. Alors ne perds pas ton temps à guerroyer contre " +
                "les autres. A moins qu'ils ne t'attaquent, ce qui sera d'ailleurs probablement le cas. " +
                "Mais je ne sais pas du tout comment me rendre à .Antre du Dragon, protestez-vous. " +
                "— Pas de souci à te faire, réplique allègrement Merlin. Je vais te dessiner une " +
                "carte.\n" +
                "— Vous aviez dit que vous alliez m'apprendre la magie, lui rappelez-vous " +
                "carrément.\n" +
                "— La magie ! s'exclame Merlin en se frappant le front d'une claque retentissante. " +
                "Mais oui, la magie Bien sûr! Heureusement que tu me l'as rappelé Sans un peu de " +
                "magie, tu ne ferais pas de vieux os dans l'Antre du Dragon. " +
                "Se prenant les pieds dans l'ourlet de sa longue robe, il se précipite (dans son " +
                "impatience) vers une bibliothèque de cristal, et il saisit sur un des rayons un énorme " +
                "volume relié en cuir, et qui porte le titre : Magie pour Débutants. Il commence à le " +
                "feuilleter rapidement.\n" +
                "— Tiens-toi tranquille, dit-il. Ne bouge pas. Tu as de quoi écrire ? Alors note : " +
                "Règles pour le bon usage de la Magie.\n" +
                "Règle n° 1. Chaque sort jeté coûte 3 POINTS DE VIE. Qu'il donne un résultat ou non.\n" +
                "Règle n° 2. Aucun sort ne peut être jeté plus de trois fois au cours d'une mission. Il " +
                "est ensuite inopérant, qu'il ait eu un effet ou non.\n" +
                "Règle n° 3. Marche à suivre pour jeter un sort : lancez deux dés. Si le chiffre obtenu est " +
                "égal ou supérieur à 7, il produit l'effet souhaité. Sinon, il est totalement inopérant. vous " +
                "notez ces trois règles le plus vite possible. Elles semblent relativement simples, mais " +
                "un détail vous chiffonne cependant.\n" +
                "— Mais je ne connais aucun sort, dites-vous à Merlin.\n" +
                "Non, bien sûr. Tu ne serais pas obligé de les apprendre, si tu les connaissais. Je vais te " +
                "donner un livre de Sortilèges. Pas celui-ci, ne t'inquiète pas. Il est trop lourd à porter. " +
                "Un petit, qui tiendra facilement dans ton sac à dos. Il ne contient que quelques sorts. " +
                "mais efficaces, je te le garantis. Tu peux y jeter un rapide coup d'œil, si tu le désires, " +
                "avant de te mettre en route.\n\n" +
                "REMARQUE IMPORTANTE POUR PIP " +
                "\n" +
                "Mais à part le sortilège INVISIBILITÉ, tous les sortilèges peuvent être " +
                "utilisés en tous lieux et en toutes circonstances. N'oubliez-pas de bien tenir à " +
                "jour votre feuille d'Aventure, en rayant ceux que vous aurez utilises. " +
                "— Voilà, dit Merlin. Voilà ta magie, tes sortilèges N'oublie pas que tu ne peux utiliser " +
                "chacun d'entre eux que trois fois seulement, à moins, bien entendu, que tu n'en " +
                "découvres un autre au cours de ta mission. C'est possible ; alors, sois attentif. Après " +
                "tout,! la magie est assez simple, à la condition de toujours* avoir en tête une règle " +
                "primordiale : n'utilise jamais un sortilège s'il te reste peu de POINTS DE VIE. Sinon, " +
                "cela peut causer ta perte. Et ne te sers de la magie que lorsque tu en auras vraiment " +
                "besoin. Car c'est un atout précieux qui nécessite de celui qui l'utilise un grand " +
                "discernement. Ce qui explique la rareté des magiciens. Mais tu le découvriras vite : " +
                "les sortilèges ne sont pas toujours efficaces ; ce qui, parfois est " +
                "source de dangers, d'épreuves et de tribulations " +
                "ma pauvre pension, par exemple... Enfin, te voilà prêt à te mettre en route, et il me " +
                "reste à te parler de l'Expérience. " +
                "A chaque fois que tu remporteras un combat, ou que tu trouveras la solution à une " +
                "énigme, tu gagneras 1 point d'EXPÉRlENCE. 20 de ces points donnent droit à 1 " +
                "POINT PERMANENT DE VIE qui s'ajoute au total de POINTS DE VIE. En ce cas, " +
                "mais en ce cas seulement, ton total de POINTS DE VIE pourra être supérieur au total " +
                "de départ. Les POINTS PERMANENTS DE VIE que tu gagneras te seront utiles " +
                "dans tes prochaines missions. Car tu as encore beaucoup de tâches à accomplir... à " +
                "moins, bien sûr que le Dragon de Bronze... Mais, bougonne-t-il, ne pensons pas à " +
                "cette éventualité...\n" +
                "\n" +
                "Puis, Merlin tire de la manche de son ample robe un dernier rouleau de parchemin, " +
                "jauni par l'âge (à moins que ce ne soit par le thé), et maculé des taches habituelles. " +
                "Pour finir, dit-il, voici ta carte. C'est une copie d'une carte très rare et très ancienne que " +
                "j'ai dessinés moi-même. La copie, je veux dire, pas la vieille carte. Ne l'égare pas, " +
                "sinon tu ne saurais pas vers où te diriger. Elle t'indique comment parvenir à l'Antre du " +
                "Dragon. Très peu de gens en connaissent le chemin. En fait, je suis peut-être le seul. " +
                "Mais maintenant, tu partages ce secret. Prépare soigneusement ton voyage, et suis " +
                "attentivement les indications portées sur la carte. Mais une fois dans l'Antre du Dra- " +
                "gon, tu devras te débrouiller seul, j'en ai peur, car personne n'a jamais réussi à en " +
                "établir le plan. Allez, en route, maintenant.\n" +
                "Et Merlin, qui malgré toutes ses étourderies n'en demeure pas moins le plus grand " +
                "magicien d'Avalon, agite les bras en d'étranges figures. Lentement, mais " +
                "inexorablement, lui et sa grotte commencent a s'effacer, pour disparaître bientôt " +
                "complètement.\n" +
                "Vous sentez maintenant que l'on vous pousse dans le dos, Pip. Vous vous retournez, " +
                "plongeant votre regard dans les beaux yeux tendres de Wanda la Vagabonde, votre " +
                "vache favorite dans le petit troupeau que possèdent vos parents d'adoption, John le " +
                "fermier, et Mary la fermière. Et s'il s'agit de Wanda la Vagabonde, c'est que le " +
                "pâturage dans lequel vous vous trouvez s'étend derrière la ferme où vous vivez.\n" +
                "\n" +
                "Comment avez-vous bien pu arriver là ? Seul Merlin pourrait le dire. Mais, en jetant un " +
                "coup d'œil à vos pieds, vous apercevez les divers objets de votre équipement, pour " +
                "lesquels vous avez dépensé votre or dans la Grotte de Cristal. Qui plus est, vous tenez " +
                "dans votre main un rouleau de parchemin jauni par le temps (à moins que ce ne soit " +
                "par le thé de Merlin), sur lequel est dessiné une carte. n'est-ce pas la carte la plus " +
                "étrange que vous ayez jamais vue de votre vie ? Tout à fait différente de celles que " +
                "l'on placarde sur tous les murs des classes de géographie. De simples pointillés qui " +
                "représentent peut-être des routes (ou autre chose). Et des numéros de sections. " +
                "Comment Merlin savait-il où vous seriez lorsque vous dérouleriez la carte ? Mystère ! " +
                "Il a dit que c'était une copie d'une très vieille carte : comment le cartographe " +
                "d'autrefois savait-il où vous seriez? Ou que Wanda la Vagabonde vous pousserait dans " +
                "le dos avec son museau ? Et pourtant, vous êtes bien là, indiqué par un X. Et voilà " +
                "Wanda, grandeur nature. Enfin, presque ! Enfin, c'est la seule piste que vous possédiez " +
                "pour découvrir l'Antre du Dragon. Vous avez donc tout intérêt à vous en servir. " +
                "Choisissez un itinéraire, et suivez-le jusqu'à ce que vous arriviez à une section " +
                "numérotée. Et rendez-vous à la séquence portant ce numéro. N’oubliez pas d'emporter " +
                "votre équipement et vos armes (ainsi que vos sortilèges !) Sur la carte, vous avez " +
                "remarqué que l'entrée de l'Antre du Dragon n'est pas indiquée. Peut-être parce qu'elle " +
                "est secrète. Mais elle doit être là, quelque part, dans l'une de ces sections, par exemple. " +
                "Il va falloir vous mettre en route pour la découvrir, Pip ! Car, où qu'elle soit...\n" +
                "\n" +
                "L'aventure commence !";
    }

    @Override
    protected void beforeLeavingChapter(Pip pip) {
        pip.add(BEGINNER_MAP);
        initializeMoney(pip);
    }

    @Override
    public int getNextChapter() {
        return MARKET;
    }

    private void initializeMoney(Pip pip) {
        pip.add(GoldenCoins.of(pip.roll2Dices().getValue() * DICE_GOLDEN_COIN));
    }

}
