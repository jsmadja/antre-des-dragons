package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.GoNextChapter;
import fr.jsmadja.antredesdragons.core.entities.Pip;
import fr.jsmadja.antredesdragons.core.inventory.Item;

public class Chapter152 extends GoNextChapter {
    @Override
    public int getNextChapter() {
        return 151;
    }

    @Override
    protected void beforeLeavingChapter(Pip pip) {
        super.beforeLeavingChapter(pip);
        pip.add(Item.MAGIC_WAND);
    }

    @Override
    public String getText() {
        return "Il se produit une chose vraiment étrange : maintenant que le Monstre est mort, " +
                "l'obscurité se dissipe, vous permettant de distinguer ce qui vous entoure. Comme si, de " +
                "son vivant, le Monstre avait absorbé la lumière. Et, en effet, une zone d'obscurité " +
                "demeure sur le sol. Lorsque vous y plongez la main, vous sentez au bout des doigts " +
                "une peau velue, des serres ; vous devinez la forme d'un corps. Il semblerait que vous " +
                "ayez exterminé une sorte de Monstre des Ténèbres. Vraiment bizarre. Mais assez " +
                "philosophé. La salle dans laquelle vous vous trouvez (il s'agit véritablement d'une " +
                "salle, et non d'une caverne), est plutôt Spartiate d'aspect. Il y a un tas de foin dans un " +
                "coin, où devait sans doute dormir le Monstre des Ténèbres avant que vous ne " +
                "l'endormiez à jamais. A part cela et une écuelle, rien d'autre. A l'exception de la " +
                "baguette magique, bien sur.\n" +
                "Cette baguette, prolongée d'une petite courroie en cuir à une extrémité, est accrochée à " +
                "un clou sur le mur ouest. Elle est en ébène et se termine par une pointe en jade. En la " +
                "touchant, vous ressentez le frémissement électrique révélateur d'un puissant pouvoir " +
                "magique, mais vous avez beau l'agiter ou la pointer, vous n'obtenez aucun résultat " +
                "tangible. N'importe, une baguette magique est une baguette magique, et la magie c'est " +
                "la magie. Vous la glissez donc dans votre sac, espérant qu'elle vous sera peut-être " +
                "utile par la suite. Une seule issue permet de quitter la salle. Elle s'ouvre sur un passage " +
                "étroit orienté vers l'est. Vous le suivez sur une courte distance et vous arrivez bientôt " +
                "devant une porte qui s'ouvre sans difficulté. Vous êtes maintenant dans une galerie " +
                "orientée nord-sud. Derrière vous, la porte s'est refermée, et semble avoir complètement " +
                "disparu dans la paroi rocheuse. Vous décidez de poursuivre votre chemin vers le nord.\n" +
                "Rendez-vous au [151].";
    }
}
