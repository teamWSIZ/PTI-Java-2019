package wsi.zajecia1;

public class A {
    public static void main(String[] args) {
        System.out.println("cześć Hello!");

        int x = 5;
        int y = 5;
        System.out.println(x*y);        //120

        System.out.println("Krok " + y); //Krok 12

        String a = "abra";
        String b = "kadabra";
        String c = a + " " + b;
        System.out.println(c);
        System.out.println(c.toUpperCase());

        if (x == 10) {
            System.out.println("x jest równe 10");
        } else {
            System.out.println("x nie jest równe 10");
        }

        if (x * y < 100) {
            System.out.println("iloczyn x i y nie jest za duży");
        }

        if (x<10 && y<10) {
            System.out.println("x i y są mniejsze od 10");
        }

    }
}
