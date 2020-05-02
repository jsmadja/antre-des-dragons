package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.pages.ManualChoicePage;

public class Page80 extends ManualChoicePage {
    @Override
    public String getText() {
        return "Un peu de persévérance peut vous mener loin. Vous avez repéré une ouverture. Pas " +
                "une porte, juste une ouverture, la porte elle-même a disparu depuis longtemps. Mais " +
                "l'ouverture donne accès à la tour et ruine. Vous tirez votre épée et vous avancez avec " +
                "prudence, tous les sens en éveil, guettant le moindre danger. Pas un bruit ; rien. Vous " +
                "entrez. Une pénombre sinistre règne parmi ces ruines, et il faut un certain temps à vos " +
                "yeux pour s'accommoder. Mais vous constatez bientôt que l'intérieur de la tour est en " +
                "pire état encore que l'extérieur. Des pierres descellées et des tas de gravats jonchent le " +
                "sol. On aperçoit encore les restes d'un escalier en spirale, mais qui ne monte plus très " +
                "haut. Vous voyez l'endroit où il s'est écroulé, à cinq mètres au-dessus de votre tête. " +
                "Vous songez un instant à ressortir, mais étant venu jusque-là, vous décidez d'explorer " +
                "un peu plus avant. Votre épée à la main, vous commencez à circuler avec précautions " +
                "parmi les débris... Une fois de plus, votre persévérance est récompensée ! Vous " +
                "repérez, à moitié dissimulée par les gravats, une trappe en bois pourrissant, cerclée de " +
                "fer rouillé. Un anneau de fer permet de la soulever. Vous saisissez l'anneau d'une " +
                "main ferme et vous tirez. L'anneau vous reste dans la main, mais peu importe : le bois " +
                "est tellement décomposé, le fer tellement rouillé que la trappe tout entière s'effrite et " +
                "votre regard plonge dans une fosse profonde et noire. Trop noire pour que vous " +
                "puissiez voir quoi que ce soit. Rapidement, vous allumez une torche. A sa lumière " +
                "vacillante, vous distinguez des marches de pierre, très raides, qui s'enfoncent dans " +
                "l'obscurité. Une fois de plus vous hésitez, vous demandant si vous ne feriez pas mieux " +
                "de retourner à la lumière du soleil. Mais que trouverez-vous dans le village ? n êtesvous pas Pip, le Pourfendeur de Dragons ? Enfin, Pip le Futur Pourfendeur de " +
                "Dragons, plutôt, courageusement, vous posez le pied sur la première marche. " +
                "Courageusement, vous glissez et vous dévalez l'escalier. Courageusement vous vous " +
                "époussetez une fois arrivé en bas, indemne heureusement. Vous vous trouvez dans un " +
                "couloir souterrain, sombre, humide, sans lumière. Allez-vous le suivre? Oui, bien sûr " +
                "! Cela va de soi, non ? " +
                "Si vous ne désirez pas suivre le couloir, retournez à votre carte et explorez une autre " +
                "partie du village. Si vous vous engagez dans le couloir, rendez-vous au 25.";
    }


    @Override
    public Paths getPossiblesPath() {
        return new Paths(Path.builder().description("Retourner à la carte").page(10).build(), Path.builder().description("S'engager dans le couloir").page(25).build());
    }
}
