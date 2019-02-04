import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        System.out.println("hi");
        int x = 10;
        int y = 10;
        System.out.println(x * y);
        String s = "Abra kadabra!";
        System.out.println(s);
        System.out.println(s.toUpperCase());
        System.out.println(s.startsWith("Abra"));
        System.out.println(s.startsWith("War"));

        if (x * y > 100) {
            System.out.println("Iloczyn jest duży");
        } else {
            System.out.println("Iloczyn nie jest duży");
        }
        Scanner ss = new Scanner(System.in);
//        x = ss.nextInt();
//        y = ss.nextInt();
//        System.out.println(x * y);

        //Zadanie 1_1
        //napisac program wczytujący liczby całkowite "a" i "b",
        // i rozwiązujący równanie a * x = b   (czyli x = b/a, jeśli a!=0)
        // (podpowiedź: wykorzystać Scanner do wczytywania liczb,
        //  oraz instrukcje if ... else ... by właściwie obsłużyć przypadek
        //  a=0
        int a, b;
        System.out.print(" podaj a: ");
        a = ss.nextInt(); //wczytało z klawiatury liczbę całkowitą i przypisało do a
        System.out.print(" podaj b: ");
        b = ss.nextInt(); //wczytało z klawiatury liczbę całkowitą i przypisało do b
        if (a==0) {
            System.out.println("uwaga! a=0 !!!");
        } else {
            System.out.println(" wynik x = " + (b/a));
        }
    }
}
