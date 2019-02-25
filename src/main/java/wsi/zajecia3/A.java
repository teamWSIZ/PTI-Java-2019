package wsi.zajecia3;

/**
 * Temat: implemetacje funkcji, testy automatyczne
 */


/**
 * Zadanie domowe
 * napisać klasę BucketSolver, która będzie z funkcji value(double x) wyliczała wartość funkcji danej
 * przez:
 *
 * f(x) =
 *    -x   dla x<0
 *    0    dla 0<=x<2
 *    x-2    dla x>=2
 *
 * oraz napisać testy sprawdzające czy funkcja działa dobrze...
 */

class QuadraticEquationSolver {
    //zwraca mniejsze z rozwiązań równania kwadratowego a*x^2 + b*x+c=0
    double solve(double a, double b, double c) {
        //return -1; //tu sprónować napisać funkcję która poda rozwiązanie równania kwadratowego
        //wg algorytmu z https://pl.wikipedia.org/wiki/R%C3%B3wnanie_kwadratowe
//        Math.sqrt(2);
        // Żebiemy disa <3
        double dddd = b*b - 4*a*c;
        double x1 = 0;  //tu wpisać wzory z wikipedii
        double x2 = 0;

        //sprawdzic ktory jest mniejszy
        // napisac return x_mniejszy
        return 0; //tu wpisać odpowiedni wynik
    }
}


class BucketSolver {
    double value(double x) {
        //napisać tak, by zwracało wartości jak w zadaniu powyżej....

        return 0;
    }
}


public class A {

    static void testRownanieKwadratowe1(QuadraticEquationSolver solver) {
        double wynik = solver.solve(1, 0, -1);
        double expected = -1;
        //1e-5   to to samo co 0.00001
        if (Math.abs(wynik - expected) > 1e-5) {
            throw new RuntimeException("Zły wynik");
        }
    }

    static void testRownanieKwadratowe2(QuadraticEquationSolver solver) {
        double wynik = solver.solve(1,-2,0);
        if (Math.abs(wynik - 0.0)>1e-5) {
            throw new RuntimeException("Zły wynik");
        }
    }

    static void testRownanieKwadratowe3(QuadraticEquationSolver solver) {
        double wynik = solver.solve(1,0,0);
        if (Math.abs(wynik - 0.0)>1e-5) {
            throw new RuntimeException("Zły wynik");
        }
    }

    static void testRownanieKwadratowe4(QuadraticEquationSolver solver) {
        double wynik = solver.solve(1,0,1);
        if (!Double.isNaN(wynik)) {
            throw new RuntimeException("Zły wynik");
        }
    }

    //tu dopisać testy dla BucketSolver
    static void testBucket1(BucketSolver solver) {
        double wynik = solver.value(1);
        double expected = 0;
        if (Math.abs(wynik - expected)>1e-5) {
            throw new RuntimeException("Zły wynik");
        }
    }


    public static void main(String[] args) {
        QuadraticEquationSolver solver = new QuadraticEquationSolver();
        testRownanieKwadratowe1(solver);
        testRownanieKwadratowe2(solver);
        testRownanieKwadratowe3(solver);
        testRownanieKwadratowe4(solver);

        BucketSolver solver1 = new BucketSolver();
        ///odpalić testy solver1'a
    }

}
