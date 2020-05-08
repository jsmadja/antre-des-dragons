package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.ManualChoiceChapter;
import fr.jsmadja.antredesdragons.core.entities.Pip;

public class Chapter90 extends ManualChoiceChapter {
    @Override
    public Paths getPossiblesPath(Pip pip) {
        return new Paths(
                Path.builder().description("Retourner à la carte du village").chapter(10).build(),
                Path.builder().description("Entrer dans le passage").chapter(86).build()
        );
    }

    @Override
    public String getText() {
        return "Ll était évident que vous alliez prendre ce risque. Le passage tournicote dans tous les " +
                "sens. Comme il est trés étroit et bas de plafond, vous êtes la plupart du temps plié en  " +
                "deux et vos coudes raclent les parois. Vous finissez par atteindre une impasse, où vous " +
                "butez contre un mur nu. Ce passage ne peut pas se terminer ainsi ! Non, bien sûr, c'est " +
                "impossible. Vous tàtonnez contre le mur jusqu'à ce que vous trouviez à nouveau un " +
                "drôle de petit bouton et, quand vous le tournez, le mur tout entier pivote dans un long " +
                "grincement. (N'est-ce pas excitant ?) Vous vous apprêtez à avancer quand E.J. " +
                "chuchote :\n" +
                "N'entre pas là-dedans ! Vous hésitez.\n" +
                "Pourquoi pas ? chuchotez-vous à votre tour.\n" +
                "J'ai vécu plus d'aventures que toi, reprend EJ sentencieuse. Il se passe toujours quelque " +
                "chose de désagréable quand on émerge d'un passage secret. Toujours. C'est une sorte de " +
                "Loi de la Nature, comme la pesanteur ou l'excès inexplicable de pièce détachées quand " +
                "vous démontez et remontez une pendule. N'entre pas là-dedans, ou tu vas te retrouvez " +
                "au [14], c'est tout vu.\n" +
                "Mais qu'est-ce que je dois faire alors ? demandez-vous.\n" +
                "Retourne à ta carte et explore une autre partie du village. Une partie moins dangereuse, " +
                "insiste E.J d'un ton pressant.\n" +
                "Alors, qu'allez-vous faire ? Retourner à la carte du village ? Si vous décidez de " +
                "négliger les conseils d'E.J., vous sortez du passage. Rendez-vous au [86].";
    }
}
