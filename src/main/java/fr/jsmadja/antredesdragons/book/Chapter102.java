package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.dices.Dice;
import fr.jsmadja.antredesdragons.dices.HitRollRange;
import fr.jsmadja.antredesdragons.entities.Foe;
import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.fight.Fight;
import fr.jsmadja.antredesdragons.chapters.Execution;
import fr.jsmadja.antredesdragons.chapters.ManualChoiceChapter;

public class Chapter102 extends ManualChoiceChapter {
    @Override
    public Paths getPossiblesPath(Pip pip) {
        return new Paths(
                Path.builder().description("Aller au sud").chapter(108).build(),
                Path.builder().description("Aller au nord-ouest").chapter(99).build(),
                Path.builder().description("Aller à l'est").chapter(112).build()
        );
    }

    @Override
    public String getText() {
        return "Le tunnel vous conduit sain et sauf dans une petite grotte, apparemment vide. Vous y " +
                "remarquez trois issues.\n" +
                "L'une, au sud, menant au [108].\n" +
                "Une autre, au nord-ouest, menant au [99].\n" +
                "La troisième, à l'est, menant au [112]." +
                "" +
                "Du coin de l'œil, vous percevez un bref frémissement ! Vous pivotez sur vous-même, " +
                "mais il n'y a rien. Un autre frémissement. Vous vous tournez de nouveau. Toujours " +
                "rien. Quelque chose vous effleure le bras gauche, le glaçant jusqu'aux os. Pendant une " +
                "fraction de seconde, vous plongez votre regard dans les yeux luisants, évanescents, " +
                "d'un Esprit. Puis la créature disparaît aussitôt. Un Esprit ? Ces apparitions sont " +
                "redoutables. On ne peut les combattre qu'avec des sortilèges. Les armes classiques ne " +
                "leur infligent aucun dommage L'Esprit vous attaque, Pip ! Ce simple effleurement " +
                "vous coûte 10 POINTS DE VIE. (S'il vous a ôté la vie. rendez-vous au [14].) Il vous " +
                "faut user de vos sortilèges ! L'Esprit dispose de 25 POINTS DE VIE. Il ripostera avec " +
                "succès s'il sort 6 ou plus aux dés, vous infligeant 3 Points de Dommage à chaque " +
                "effleurement.\n" +
                "Si vous tuez l'Esprit, vous pouvez quitter la grotte " +
                "par l'issue de votre choix. " +
                "Si l'Esprit vous tue, rendez-vous au [14].";
    }

    @Override
    public Execution execute(Pip pip) {
        Foe foe = Foe.builder()
                .name("Esprit")
                .dice(new Dice())
                .initialHealthPoints(25)
                .hitRollRange(new HitRollRange(6))
                .constantHitDamage(3)
                .immuneToPhysicalDamages(true)
                .build();
        foe.attacks(10, pip);

        new Fight(pip, foe).start();

        if (pip.isDead()) {
            return pip.goToChapter(14);
        }

        return super.execute(pip);
    }
}
