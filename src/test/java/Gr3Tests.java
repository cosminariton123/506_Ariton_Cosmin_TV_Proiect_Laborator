import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/*
public class Gr3Tests {
    /*
    Equivalence partitioning
Intrare n

Domeniul pt n
N1 = {n | n < 1000}
N2 = {n | n >=1000 && n <=99999}
N3 = {n | n > 99999}

Iesiri:
I1 = {"DA"}
I2 = {"NU"}
I3 = {"Numarul nu este valid"}

Clasele
C1 = {n | n in N1 si iesirea I3} -----> n = 0
C21 = {n| n in N2 si iesirea I1} -----> n = 6533
C22 = {n| n in N2 si iesirea I2} -----> n = 6532
C3 = {n | n in N3 si iesirea I3} -----> n = 123456

     */
    /*
    @Test
    void equivalence(){
        Assertions.assertEquals("Numarul nu este valid", Main.calculeaza(0));
        Assertions.assertEquals("DA", Main.calculeaza(6533));
        Assertions.assertEquals("NU", Main.calculeaza(6532));
        Assertions.assertEquals("Numarul nu este valid", Main.calculeaza(123456));
    }

    /*
    Boundaries

    999, 1000, 99999, 100000
    alte valori speciale: 2000

     */
    /*
    @Test
    void boundaries(){
        Assertions.assertEquals("Numarul nu este valid", Main.calculeaza(999));
        Assertions.assertEquals("NU", Main.calculeaza(1000));
        Assertions.assertEquals("NU", Main.calculeaza(99999));
        Assertions.assertEquals("DA", Main.calculeaza(2000));
        Assertions.assertEquals("Numarul nu este valid", Main.calculeaza(100000));
        Assertions.assertEquals("Numarul nu este valid", Main.calculeaza(234));
        Assertions.assertEquals("NU", Main.calculeaza(2340));
        Assertions.assertEquals("Numarul nu este valid", Main.calculeaza(213232));
    }

}

cause-effect graphing.
@Test
    void gce(){
        Assertions.assertEquals("Numarul nu este valid", main.calculeaza(687));
        Assertions.assertEquals("DA", main.calculeaza(5321));
        Assertions.assertEquals("NU", main.calculeaza(4000));
    }

     */
