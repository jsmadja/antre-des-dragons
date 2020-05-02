package fr.jsmadja.antredesdragons.utils;

import java.util.stream.Collectors;

public class ScrollDecypher {
    //     private String scrollText = "NPJ, FUIFMCFSU, NPJOF FU, N'FUBON MJF E'BNJUJF BWFD MF NPOTUSF B\n" +
    //            "UFUF EF UBVSFBV BGGJSNF RVF TFVMF MB DMFG DPOUFOVF EBOT MF " +
    //            "DPGGSFU QFVU QFSNFUUSF M'BDDFT B M'BOUSF EFT DSBDIFVST EF " +
    //            "GFV.";
    public static void scrollDecypher(String scrollText) {
        System.out.println(scrollText.chars().mapToObj(letterIntCode -> {
            char letter = (char) letterIntCode;
            return Character.toString(letter == ' ' || letter == ',' || letter == '\'' || letter == '.' ? letter : (char) (letterIntCode - 1));
        }).collect(Collectors.joining()));
    }

    public static void main(String[] args) {
        String s = "NPJ, FUIFMCFSU, NPJOF FU, N'FUBON MJF E'BNJUJF BWFD MF NPOTUSF B " +
                "UFUF EF UBVSFBV BGGJSNF RVF TFVMF MB DMFG DPOUFOVF EBOT MF " +
                "DPGGSFU QFVU QFSNFUUSF M'BDDFT B M'BOUSF EFT DSBDIFVST EF " +
                "GFV.";
        scrollDecypher(s);
    }

}
