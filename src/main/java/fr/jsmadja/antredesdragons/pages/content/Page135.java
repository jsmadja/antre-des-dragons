package fr.jsmadja.antredesdragons.pages.content;

import fr.jsmadja.antredesdragons.dices.Roll;
import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.pages.types.Execution;
import fr.jsmadja.antredesdragons.pages.types.ManualChoicePage;

public class Page135 extends ManualChoicePage {
    @Override
    public Paths getPossiblesPath() {
        return new Paths(
                Path.builder().description("Aller dans le passage 114").page(114).build(),
                Path.builder().description("Aller dans le passage 128").page(128).build(),
                Path.builder().description("Aller dans le passage 137").page(137).build());
    }

    @Override
    public Execution execute(Pip pip) {
        Roll roll = pip.roll2Dices();
        if (roll.isBetween(2, 4)) {
            pip.goToPage(14);
        }
        return super.execute(pip);
    }

    @Override
    public String getText() {
        return "Le coffre n° 3 contient un rouleau sur lequel est écrit : " +
                "NPJ, FUIFMCFSU, NPJOF FU, N'FUBON MJF E'BNJUJF BWFD MF NPOTUSF B " +
                "UFUF EF UBVSFBV BGGJSNF RVF TFVMF MB DMFG DPOUFOVF EBOT MF " +
                "DPGGSFU QFVU QFSNFUUSF M'BDDFT B M'BOUSF EFT DSBDIFVST EF " +
                "GFV.\n" +
                "Ce qui n'éclaire guère votre lanterne, à moins que vous ne parveniez à déchiffrer " +
                "le code. Peut-être trouverez-vous quelque chose pour vous aider dans le coffre N° " +
                "1. Vous l'ouvrez d'un geste rapide et vous êtes aussitôt mordu par un gros " +
                "Serpent. Lancez deux dés pour savoir si le poison est mortel. " +
                "Si vous faites de 2 à 4, le poison se répand dans vos veines comme un acide. " +
                "Tordez-vous de douleur durant un instant, puis rendez-vous calmement au 14. " +
                "Si vous faites de 5 à 12, vous jouissez d'une immunité naturelle. Rejetez ce " +
                "Serpent imbécile dans son coffre et essayez de décoder le message. Comme le " +
                "Minotaure l'avait prédit, les autres coffres ont disparu. Les passages depuis la " +
                "grotte du Minotaure conduisent au 114, au 128 et au 137. Faites votre choix !";
    }
}
