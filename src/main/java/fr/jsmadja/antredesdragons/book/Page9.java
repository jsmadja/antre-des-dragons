package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.pages.ManualChoicePage;

public class Page9 extends ManualChoicePage {
    @Override
    public Paths getPossiblesPath() {
        return new Paths(
                Path.builder().description("Partager mon repas").page(36).build(),
                Path.builder().description("Refuser de partager mon repas").page(22).build()
        );
    }

    @Override
    public String getText() {
        return "Vous avez l'impression d'avoir parcouru des kilomètres, avec le village toujours en " +
                "vue, mais cependant toujours aussi éloigné. Vous êtes maintenant épuisé, affamé, et " +
                "vous décidez donc de vous reposer et de manger une partie de vos provisions. Vous " +
                "vous écartez de la piste et vous vous asseyez dans l'herbe, adossé à une souche " +
                "d'arbre près d'un taillis. Un clair ruisseau où vous pouvez boire coule à proximité. Le " +
                "village reste en vue, ni plus près, ni plus loin. Au moment où vous ouvrez votre sac, " +
                "une voix déclare derrière vous : « Bon demain, Votre Honneur ». Vous vous levez " +
                "d'un bond, prêt à tirer votre épée, mais vous hésitez. Un petit homme minuscule, " +
                "habillé de brun et de vert, a émergé du taillis et il vous regarde, les yeux noirs et " +
                "pétillants. Il ne porte aucune arme et ne semble guère dangereux. « Votre cassecroûte est bien appétissant, Votre Honneur, dit le petit homme. Une bouchée ou " +
                "deux ne ferait pas de mal à un pauvre diable qui n'a pas mangé depuis une " +
                "semaine.»\n" +
                "Proposez-vous au minuscule affamé de partager votre repas avec lui ? Rendez-vous " +
                "alors au [36]. Lui faites-vous remarquez poliment que vous avez un long voyage en " +
                "perspective et que vous aurez besoin pour vous-même de vos provisions ? Rendez-vous dans ce cas au [22].";
    }
}
