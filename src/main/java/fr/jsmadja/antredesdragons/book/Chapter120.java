package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.dices.Dice;
import fr.jsmadja.antredesdragons.dices.HitRollRange;
import fr.jsmadja.antredesdragons.dices.Roll;
import fr.jsmadja.antredesdragons.entities.Entity;
import fr.jsmadja.antredesdragons.entities.Foe;
import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.fight.Attack;
import fr.jsmadja.antredesdragons.chapters.Execution;
import fr.jsmadja.antredesdragons.chapters.Chapter;
import fr.jsmadja.antredesdragons.stuff.Item;
import fr.jsmadja.antredesdragons.ui.Events;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static fr.jsmadja.antredesdragons.fight.Attack.Status.TOUCHED;
import static fr.jsmadja.antredesdragons.ui.Events.fightEvent;
import static fr.jsmadja.antredesdragons.ui.Events.statusEvent;
import static java.text.MessageFormat.format;

public class Chapter120 extends Chapter {

    private Foe minotaure;
    private int initialPipHealthPoints;
    private Pip pip;

    @Override
    public String getText() {
        return "Le passage est orienté plein est pendant un certain caps, puis il s'incurve, d'abord vers " +
                "le nord-est et ensuite, presque à angle droit, vers le nord. Vous percevez une étrange " +
                "odeur, qui évoque un peu celle de l étable chez vos parents adoptifs mais plus " +
                "pénétrante, où flotte, si l'on peut dire, comme une menace. Vous poursuivez " +
                "néanmoins votre chemin. PIP n'est pas un aventurier pour rien ! Pendant que des idées " +
                "fantasques vous traversent l\"esprit, vous atteignez l'extrémité du passage et vous " +
                "pénétrez dans une autre caverne. Vous remarquez une issue dans la paroi nord, et une " +
                "autre à l'est. Trois grands coffres cerclés de cuivre, et une petite cassette assortie, sont " +
                "posés sur le sol, à environ cinq mêtres devant vous. Cet endroit serait intéressant et " +
                "amusant à explorer à loisir, si ce n'était un petit détail. Entre vous et les coffres (sans " +
                "parler des issues) se dresse un personnage de deux mètres de haut, bardé de muscles, et " +
                "qui tient une épée nue. Mais ce n'est pas l'épée que vous regardez pour le moment, si " +
                "menaçante soit-elle : vous fixez la tête du personnage qui est celle d'un taureau... Vous " +
                "êtes entré dans la grotte du Minotaure !\n" +
                "Halte ! mugit le Minotaure, grattant le sol de son pied droit Personne ne passe par ici !\n" +
                "Ne criez pas si fort, monstre stupide ! retorquez- vous, plus téméraire peut-être que " +
                "vous ne l'êtes en " +
                "réalité. Je n'ai nulle intention de m'en prendre à vous. J'essaye simplement de trouver " +
                "le Dragon de Bronze.\n" +
                "Toi ? ricane le Minotaure. Un brimborion de ton espèce, à la recherche du Dragon de " +
                "Bronze ?\n" +
                "Je ne suis pas un brimborion, répondez-vous avec dignité. Je m'appelle Pip. Peut-être " +
                "avez-vous entendu parler de moi ?\n" +
                "Le Minotaure secoue son énorme tête en soufflant par les naseaux.\n" +
                "Ma foi, non.\n" +
                "Alors, reprenez-vous, peut-être avez-vous entendu parler de l'homme qui m'a envoyé, " +
                "Merlin, le plus grand magicien d'Avalon.\n" +
                "Merlin ? Je l'aurais cru mort de vieillesse.\n" +
                "Tout ce qu'il y a de vivant, répondez-vous vivement, partant du principe que de bonnes " +
                "paroles valent mieux que la bagarre, surtout quand on doit affronter un être aussi " +
                "coriace que le Minotaure.\n" +
                "Et tu le connais ? Personnellement ?\n" +
                "Bien sûr\n! " +
                "Le Minotaure cesse de gratter le sol du pied.\n" +
                "Tu crois que tu pourrais le persuader de s'occuper de ma tête ?\n" +
                "Qu'est-ce qu'elle a, votre tête ? demandez-vous, pensant que le monstre est peut-être " +
                "affligé de migraines.\n" +
                "C'est une tête de taureau, répond le Minotaure. Tu ne l'avais pas remarqué ?\n" +
                "Eh bien... si, avouez-vous.\n" +
                " " +
                "Le Minotaure s'assied sur un des coffres et il appuie son épée contre son genou. " +
                "Tristement il laisse pendre son énorme tête de taureau.\n" +
                "Comme la plupart des gens, fait-il remarquer. Il relève la tête. Tu ne t'imagines tout de " +
                "même pas que je suis né comme ça ? Et avant que vous ayez pu répondre, il continue. " +
                "Non, bien sûr. J'étais un enfant parfaitement normal, un bel enfant, comme " +
                "je vivais à Athènes, un petit village grec dont tu n\"as peut-être pas entendu parler. Ma " +
                "tête est devenue comme ça parce que je mangeais trop de hamburgers, je crois. Je ne " +
                "suis pas vraiment sûr, maisc'est la seule raison que je puisse trouver. Tous mes amis se " +
                "sont détournés de moi, et si le Roi de Crète a eu la gentillesse de m'employer un " +
                "certain temps comme gardien de son labyrinthe, le salaire était ridicule, alors j'ai fini " +
                "par démissionner pour venir me cacher ici. Penses-tu que Merlin pourrait me guérir ?\n" +
                "J'en suis persuadé, répondez-vous. Il est très doué pour changer la forme des choses.\n" +
                "Si tu pouvais obtenir de lui qu'il s'occupe de moi. dit le Minotaure, je t'en serais " +
                "éternellement reconnaissant.\n" +
                "Me laisseriez-vous passer à travers votre grotte sans me faire de mal ? demandez-vous " +
                "d'un ton circonspect.\n" +
                "Impossible. Toute personne qui entre ici doit se battre contre moi, c'est la tradition. " +
                "Mais nous pouvons nous livrer à un simulacre de combat, sans armes. Le premier qui " +
                "prend 10 POINTS DE VIE a l'autre sera le vainqueur. Si tu gagnes, tu pourras " +
                "traverser ; je te laisserai même chercher dans ces coffres un objet utile. Si tu perds, tu " +
                "devras retourner tout droit auprès de Merlin et t'arranger pour qu'il s'occupe de ma tête. " +
                "Es-tu d'accord ?\n" +
                "Tout à fait d'accord ! dites-vous, avec un certain soulagement. Alors, on se bat " +
                "maintenant ?\n" +
                "Allons-y ! répond le Minotaure tout excité, en se levant d'un bond.\n" +
                "Lancez deux dés pour connaître l'issue du combat. Le Minotaure a besoin d'un 6 pour " +
                "frapper, exactement comme vous puisqu'il s'agit d'un combat à mains nues. Le premier " +
                "coup de dés désigne celui qui frappera le premier. Si vous êtes vainqueur, rendez-vous au [126]. Sinon, rendez-vous au [133]. ";
    }

    @Override
    public Execution execute(Pip pip) {
        this.pip = pip;
        this.minotaure = Foe.builder().name("Minotaure").dice(new Dice()).hitRollRange(new HitRollRange(6)).initialHealthPoints(10).build();
        this.initialPipHealthPoints = pip.getCurrentHealthPoints();
        HitRollRange initialPipHitRollRange = pip.getHitRollRange();
        Optional<Item> equipedWeapon = pip.getEquipedWeapon();
        if (equipedWeapon.isPresent()) {
            pip.unequip(equipedWeapon.get());
            pip.setHitRollRange(new HitRollRange(6));
        }

        List<Entity> opponents = getOrderedOpponents(pip);
        while (!this.isOver()) {
            opponents.forEach(attacker -> {
                Entity other = attacker == minotaure ? pip : minotaure;
                if (!other.isDead()) {
                    this.attack(attacker, other);
                }
                Events.statusEvent(attacker.toString());
            });
        }
        if (equipedWeapon.isPresent()) {
            pip.equip(equipedWeapon.get());
            pip.setHitRollRange(initialPipHitRollRange);
        }
        if (minotaure.isDead()) {
            return pip.goToChapter(126);
        }
        return pip.goToChapter(133);
    }

    private List<Entity> getOrderedOpponents(Pip pip) {
        List<Entity> opponents = new ArrayList<>();
        Roll pipOrderRoll = pip.roll2Dices();
        Roll foeOrderRoll = minotaure.roll2Dices();
        if (pipOrderRoll.isGreaterThan(foeOrderRoll)) {
            opponents.add(pip);
            opponents.add(minotaure);
        } else {
            opponents.add(minotaure);
            opponents.add(pip);
        }
        return opponents;
    }

    private void attack(Entity attacker, Entity target) {
        fightEvent(format("{0} attaque {1}", attacker.getName(), target.getName()));
        Attack physicalAttack = attacker.createPhysicAttack(target);
        if (physicalAttack.getStatus() == TOUCHED) {
            int damagePoints = physicalAttack.getDamagePoints();
            fightEvent(format("{0} fait {1} points de dégâts à {2}", attacker.getName(), damagePoints, target.getName()));
            target.wounds(damagePoints);
            if (target.isDead()) {
                fightEvent(format("{0} est mort", target.getName()));
            }
        } else {
            fightEvent(format("{0} rate son attaque vers {1}", attacker.getName(), target.getName()));
        }
        statusEvent(target.toString());
    }

    private boolean isOver() {
        return this.minotaure.isDead() || (this.initialPipHealthPoints - this.pip.getCurrentHealthPoints()) >= 10;
    }

}
