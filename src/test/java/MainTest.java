import org.junit.jupiter.api.*;

import java.util.Arrays;

public class MainTest {

    /*

    Problema aleasa este:
    https://www.pbinfo.ro/probleme/4402/ciocolata1
    Cu precizarea ca "se garanteaza ca exista intotdeauna solutie" este cu referire la sir pentru c = 2, daca toate
        celelalte conditii de existenta sunt asigurate(inclusiv N <= 2 pentru c = 2)
    In rest, se vor intoarce intregi cu valori negative ce semnifica o eroare astfel:
        -1 pentru erori cu privire la c pentru apartenenta la multimea indicata
        -2 pentru erori cu privire la n pentru apartenenta la intervalul indicat
        -3 pentru erori cu privire la elementele sirului
        -4 pentru erori cu privire la n < 2 pentru c = 2, caz ce apare indirect din
            "fiecare fată trebuie să consume cel puțin o tabletă de ciocolată" cand este considerata problema 2
    Mai mult, verificarile vor fi executate in ordinea descrisa anterior, verificarea pentru eroarea -4 nefiind
        executata daca c = 1

    Equivalence partitioning

    Intrare
    c un intreg pozitiv
    n un intreg pozitiv
    un sir de numere naturale nenule mai mici sau egale cu 10_000. Notare: "sir"

    Domeniu pt c
    C1 = {1}
    C2 = {2}
    C3 = {c | c nu in {1, 2}}

    Domeniu pt n
    N1 = {n | n < 1}
    N2 = {n | n > 1 && n <= 100_000}
    N3 = {n | n > 100_000}
    N4 = {1}

    Domeniu pt sir
    SIR1 = {x | x > 0, x < 10_000, k >= 2 in numere_naturale, x = xk, sum(xi) > sum(xi+1) cu i in numere_naturale in [1, k]}; sir ce garanteaza solutie
    SIR2 = {x | x > 0, x < 10_000, k >= 2 in numere_naturale, x = xk, sum(xi) = sum(xi+1) cu i in numere_naturale in [1, k]}; sir ce garanteaza solutie
    SIR3 = {x | x > 0, x < 10_000}; sir cu un singur numar ce respecta intervalul specificat; sirul nu garanteaza existenta unei solutii, dar este disjunct cu c = 2
    SIR4 = {x | exista x a.i x <= 0, k in numere_naturale, x = xk}
    SIR5 = {x | exista x a.i x >= 10_000, k in numere_naturale, x = xk}
    Cum problema garanteaza solutie si nu se precizeaza nimic despre tratarea diferita a sirurilor ce nu au solutie
        atunci nu determina clase de echivalenta suplimentare
    Intregul n determina lungimea sirului de numere "sir" si nu se precizeaza nimic despre tratarea diferita a sirurilor
        de lungime diferita deci nu determina clase de echivalenta suplimentare

    Iesiri
    I1 = {-1}
    I2 = {-2}
    I3 = {-3}
    I4 = {-4}
    I5 = {x | x > 0, x respecta cerinta}
    I6 = {0}


    Clasele
    CL3 = {(c, n, sir) | c in C3 si iesirea I1} --------> c = 4, n = 3, sir = (1, 2, 3)

    CL11 = {(c, n, sir) | c in C1, n in N1 si iesirea I2} --------> c = 1, n = -5, sir = (1, 2, 3)
    CL21 = {(c, n, sir) | c in C2, n in N1 si iesirea I2} --------> c = 2, n = -5, sir = (1, 2, 3)
    CL13 = {(c, n, sir) | c in C1, n in N3 si iesirea I2} --------> c = 1, n = 200_000, sir = (1, 2, 3)
    CL23 = {(c, n, sir) | c in C2, n in N3 si iesirea I2} --------> c = 2, n = 200_000, sir = (1, 2, 3)

    CL114 = {(c, n, sir) | c in C1, n in N1, sir in SIR4, si iesirea I3} --------> c = 1, n = 6, sir = (-1, 2, 3, 4, 5, 6)
    CL115 = {(c, n, sir) | c in C1, n in N1, sir in SIR5, si iesirea I3} --------> c = 1, n = 6, sir = (20_000, 2, 3, 4, 5, 6)
    CL214 = {(c, n, sir) | c in C2, n in N1, sir in SIR4, si iesirea I3} --------> c = 2, n = 6, sir = (-1, 2, 3, 4, 5, 6)
    CL215 = {(c, n, sir) | c in C2, n in N1, sir in SIR5, si iesirea I3} --------> c = 2, n = 6, sir = (20_000, 2, 3, 4, 5, 6)
    CL144 = {(c, n, sir) | c in C1, n in N4, sir in SIR4, si iesirea I3} --------> c = 1, n = 1, sir = (-1,)
    CL145 = {(c, n, sir) | c in C1, n in N4, sir in SIR5, si iesirea I3} --------> c = 1, n = 1, sir = (20_000,)
    CL244 = {(c, n, sir) | c in C2, n in N4, sir in SIR4, si iesirea I3} --------> c = 2, n = 1, sir = (-1,)
    CL245 = {(c, n, sir) | c in C2, n in N4, sir in SIR5, si iesirea I3} --------> c = 2, n = 1, sir = (20_000,)

    CL241 = {(c, n, sir) | c in C2, n in N4, sir in SIR3 si iesirea I4} --------> c = 2, n = 1, sir = (1,)

    CL121 = {(c, n, sir) | c in C1, n in N2, sir in SIR1, si iesirea I5} --------> c = 1, n = 6, sir = (1, 2, 3, 4, 5, 7)
    CL122 = {(c, n, sir) | c in C1, n in N2, sir in SIR2, si iesirea I5} --------> c = 1, n = 6, sir = (1, 2, 3, 4, 5, 6)
    CL143 = {(c, n, sir) | c in C1, n in N4, sir in SIR3, si iesirea I5} --------> c = 1, n = 1, sir = (2,)

    CL121 = {(c, n, sir) | c in C1, n in N2, sir in SIR1, si iesirea I5} --------> c = 2, n = 6, sir = (1, 2, 3, 4, 5, 7)
    CL122 = {(c, n, sir) | c in C1, n in N2, sir in SIR2, si iesirea I5} --------> c = 2, n = 6, sir = (1, 2, 3, 4, 5, 6)

     */

    @Test
    void equivalencePartitioning() {
        Assertions.assertEquals(-1, Main.ciocolata(4, 3, Arrays.asList(1, 2, 3)));

        Assertions.assertEquals(-2, Main.ciocolata(1, -5, Arrays.asList(1, 2, 3)));
        Assertions.assertEquals(-2, Main.ciocolata(2, -5, Arrays.asList(1, 2, 3)));
        Assertions.assertEquals(-2, Main.ciocolata(1, 200_000, Arrays.asList(1, 2, 3)));
        Assertions.assertEquals(-2, Main.ciocolata(2, 200_000, Arrays.asList(1, 2, 3)));

        Assertions.assertEquals(-3, Main.ciocolata(1, 6, Arrays.asList(-1, 2, 3, 4, 5, 6)));
        Assertions.assertEquals(-3, Main.ciocolata(1, 6, Arrays.asList(20_000, 2, 3, 4, 5, 6)));
        Assertions.assertEquals(-3 , Main.ciocolata(2, 6, Arrays.asList(-1, 2, 3, 4, 5, 6)));
        Assertions.assertEquals(-3, Main.ciocolata(2, 6, Arrays.asList(20_000, 2, 3, 4, 5, 6)));
        Assertions.assertEquals(-3, Main.ciocolata(1, 1, Arrays.asList(-1)));
        Assertions.assertEquals(-3, Main.ciocolata(1, 1, Arrays.asList(20_000)));
        Assertions.assertEquals(-3, Main.ciocolata(2, 1, Arrays.asList(-1)));
        Assertions.assertEquals(-3, Main.ciocolata(2, 1, Arrays.asList(20_000)));

        Assertions.assertEquals(-4, Main.ciocolata(2, 1, Arrays.asList(1)));

        Assertions.assertEquals(1, Main.ciocolata(1, 6, Arrays.asList(1, 2, 3, 4, 5, 7)));
        Assertions.assertEquals(1, Main.ciocolata(1, 6, Arrays.asList(1, 2, 3, 4, 5, 6)));
        Assertions.assertEquals(2, Main.ciocolata(1, 1, Arrays.asList(2)));

        Assertions.assertEquals(3, Main.ciocolata(2, 6, Arrays.asList(1, 2, 3, 4, 5, 7)));
        Assertions.assertEquals(0, Main.ciocolata(2, 6, Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @Test
    void verificaProblema2_1() {
        Assertions.assertEquals(3, Main.ciocolata(2, 5, Arrays.asList(14, 4, 25, 2, 9)));
    }

    @Test
    void verificaProblema2_2() {
        Assertions.assertEquals(1, Main.ciocolata(2, 11, Arrays.asList(3, 7, 3, 12, 4, 9, 4, 2, 6, 5, 17)));
        }

}
