package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.pages.GoPage;

public class Page45 extends GoPage {
    @Override
    protected int getNextPage() {
        return 10;
    }

    @Override
    public String getText() {
        return "Comme c'est étrange : cette demeure ressemble à une chaumière, elle a la forme d'une " +
                "chaumière et la taille d'une chaumière, mais maintenant que vous en etes proche, vous " +
                "constatez que ce n'est pas une chaumière, mais un énorme rocher coiffé d'un toit de " +
                "chaume. Vous pourriez passer l'éternité entière à essayer de comprendre ce prodige. " +
                "Mais il est sans doute plus intelligent de reprendre votre carte, et d'aller faire un tour " +
                "ailleurs.";
    }
}
