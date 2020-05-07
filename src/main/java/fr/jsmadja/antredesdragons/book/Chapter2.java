package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.chapters.Execution;
import fr.jsmadja.antredesdragons.chapters.GoNextChapter;
import fr.jsmadja.antredesdragons.stuff.Item;

public class Chapter2 extends GoNextChapter {
    @Override
    public int getNextChapter() {
        return 4;
    }

    @Override
    public String getText() {
        return "Voici, explique Merlin, Excalibur Junior. C'est une épée très spéciale. Je l'ai forgée " +
                "moi-même, et je suis donc bien placé pour le savoir. Elle est la réplique exacte de " +
                "l'épée du roi Arthur. La réplique exacte. en plus petit. Et elle parle, contrairement à " +
                "Excalibur d'Arthur. Sans arrêt, quelquefois. Dis bonjour à Pip, E.J. " +
                "â votre grande surprise, l'épée déclare docilement : bonjour, Pip. " +
                "Dans un état proche de l'ébahissement, vous tendez la main et vous saisissez l'épée. " +
                "Elle est parfaitement équilibrée, légère, mais certainement redoutable.\n" +
                "—Ouaoh ! vous exclamez-vous, usant d'une expression peu courante à l'époque du roi " +
                "Arthur. " +
                "Mais Merlin semble la comprendre.\n" +
                "—Ouaoh, comme tu dis ! commente-t-il. Quand tu te serviras de cette épée, il te " +
                "suffira d'obtenir un 4 avec tes deux dés pour frapper un adversaire. Ça fait partie de la " +
                "magie. Et ce n'est pas tout : tu pourras ajouter 5 points aux Points de Dommage que tu " +
                "lui causeras. Ça aussi, ça fait partie de la magie.\n" +
                "—vous avez E.J. bien en main ? Alors, rendez-vous au [4]";
    }

    @Override
    public Execution execute(Pip pip) {
        pip.addAndEquip(Item.EXCALIBUR_JUNIOR);
        return super.execute(pip);
    }
}
