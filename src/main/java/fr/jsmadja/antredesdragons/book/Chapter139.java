package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.chapters.ManualChoiceChapter;

public class Chapter139 extends ManualChoiceChapter {
    @Override
    public Paths getPossiblesPath(Pip pip) {
        return new Paths(
                Path.builder().description("Aller vers le nord-ouest").chapter(141).build(),
                Path.builder().description("Aller vers le nord").chapter(151).build(),
                Path.builder().description("Aller vers le nord-est").chapter(154).build()
        );
    }

    @Override
    public String getText() {
        return "On entend un ronronnement de machine. Une vibration vous parcourt le corps. " +
                "Pendant un instant vous vous sentez étourdi, désorienté. Une spirale de lumière jaillit " +
                "de la plaque, sous vos pieds, et s'ecroule autour de vous. La tête vous tourne, le vertige " +
                "s'amplifie... Puis, c'est l'obscurité. Vous vous retrouvez dans un couloir souterrain en " +
                "pierres maçonnées, bien éclairé par des torches disposées dans des appliques fixées sur " +
                "les parois à intervalles réguliers. La caverne de métal a disparu. En fait vous vous " +
                "retrouvez face à trois couloirs orientés vers le nord-ouest, le nord et le nord-est. Tous " +
                "trois sont obscurs, et ne vous inspirent guère confiance Dans le couloir nord-ouest,  " +
                "vous remarquez les premières marches d'un escalier qui semble s'enfoncer " +
                "profondément dans le roc. Il vous faut prendre rapidement une décision. Allez-vous " +
                "vous diriger :\n" +
                "vers le nord-ouest ? Rendez-vous au 141\n" +
                "vers le nord ? Rendez-vous au 151\n" +
                "vers le nord-est ? Rendez-vous au 154";
    }
}
