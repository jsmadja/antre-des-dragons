package fr.jsmadja.antredesdragons;

class AntreDesDragons {
    private Dice dice = new Dice();
    private Pip pip = new Pip(dice);

    Pip getPip() {
        return pip;
    }
}
