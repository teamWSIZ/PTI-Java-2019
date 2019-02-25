package wsi.zajecia3;

/**
 * Temat: implemetacje funkcji, testy automatyczne
 */


class QuadraticEquationSolver {
    //zwraca mniejsze z rozwiązań równania kwadratowego a*x^2 + b*x+c=0
    double solve(double a, double b, double c) {
        return -1;
    }
}


public class A {

    static void testRownanieKwadratowe1(QuadraticEquationSolver solver) {
        double wynik = solver.solve(1,0,-1);
        if (Math.abs(wynik - (-1.0)) > 1e-5) {
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
        double wynik = solver.solve(1,0,0);
        if (!Double.isNaN(wynik)) {
            throw new RuntimeException("Zły wynik");
        }
    }



    public static void main(String[] args) {
        QuadraticEquationSolver solver = new QuadraticEquationSolver();
        testRownanieKwadratowe1(solver);
        testRownanieKwadratowe4(solver);
    }

}
