package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.ManualChoiceChapter;
import fr.jsmadja.antredesdragons.core.entities.Pip;

public class Chapter65 extends ManualChoiceChapter {
    @Override
    public Paths getPossiblesPath(Pip pip) {
        return new Paths(
                Path.builder().description("S'aventurer dans le bois").chapter(5).build(),
                Path.builder().chapter(21).build(),
                Path.builder().chapter(58).build(),
                Path.builder().chapter(155).build());
    }

    @Override
    public String getText() {
        return "Vous avez parcouru, non sans peine, des kilomètres en direction du nord-est, pour " +
                "arriver là. Et maintenant que vous y êtes, vous vous demandez peut-être pourquoi vous " +
                "vous êtes donné tout ce mal. Les verdoyantes prairies et les champs fertiles d'Avalon " +
                "ont peu à peu cédé la place à un pays plus rude, plus sauvage et vous êtes maintenant à " +
                "l'orée d'un bois sombre. menaçant. Ce qui vous frappe le plus, c'est un silence " +
                "oppressant. En général, les oiseaux gazouillent sans fin dans les bois, et de petits " +
                "animaux se faufilent dans les taillis. Mais ici, rien ne bouge, et le seul bruit que vous " +
                "perceviez, ce sont les battements precipités de votre cœur. Allez-vous avancer dans le " +
                "bois, Pip ?\n" +
                "Si vous décidez de ne pas entrer dans le bois, et de revenir sur vos pas, consultez la " +
                "carte que vous a donnée Merlin, et choisissez une nouvelle direction en commençant à " +
                "l'endroit marqué d'un X. Si vous décidez de prendre le risque de vous aventurer dans " +
                "le bois, rendez-vous au [5].";
    }
}
