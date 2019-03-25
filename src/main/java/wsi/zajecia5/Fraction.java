package wsi.zajecia5;

public class Fraction {

    public static void main(String[] args) {


        double x =1;
        for (int i = 0; i < 100; i++) {
            System.out.println(x);
            x = 1. / (1 + x);
        }
    }
}
