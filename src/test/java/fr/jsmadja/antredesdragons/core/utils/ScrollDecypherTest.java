package fr.jsmadja.antredesdragons.core.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ScrollDecypherTest {

    @Test
    void scrollDecypher() {
        String cypher = "NPJ, FUIFMCFSU, NPJOF FU, N'FUBOU MJF E'BNJUJF BWFD MF NPOTUSF B " +
                "UFUF EF UBVSFBV BGGJSNF RVF TFVMF MB DMFG DPOUFOVF EBOT MF " +
                "DPGGSFU QFVU QFSNFUUSF M'BDDFT B M'BOUSF EFT DSBDIFVST EF " +
                "GFV.";
        String decypher = ScrollDecypher.scrollDecypher(cypher);
        Assertions.assertThat(decypher).isEqualTo("MOI, ETHELBERT, MOINE ET, M'ETANT LIE D'AMITIE AVEC LE MONSTRE A TETE DE TAUREAU AFFIRME QUE SEULE LA CLEF CONTENUE DANS LE COFFRET PEUT PERMETTRE L'ACCES A L'ANTRE DES CRACHEURS DE FEU.");
    }
}
