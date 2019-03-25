package wsi.zajecia5;

import java.math.BigInteger;
import java.util.Arrays;

public class B {
    public static void main(String[] args) {
        int[] w = new int[]{1, 4, 6, 2, 8, 10, 11};     //tablica int-ów

        System.out.println("element trzeci [3]: " + w[3]);  //dostęp do elementów tablicy

        w[0] = 11;  //zmiana elmentu

        System.out.println(w.length);   //liczba elementów
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);

        //suma elementów tablicy:
        int suma = 0;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = 0; i < w.length; i++) {
            suma += w[i];
            max = Math.max(max, w[i]);
            min = Math.min(min, w[i]);
        }
        System.out.println("suma = " + suma);

        Arrays.sort(w);
        System.out.println(Arrays.toString(w));

        /// znaleźć drugą najmniejszą liczbę w tablicy




    }
}
