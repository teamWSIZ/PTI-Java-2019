package wsi.zajecia5;

import java.util.Arrays;

public class A {
    public static void main(String[] args) {
        //zadanie: pokroić napis typu csv na tablicę napisów
        String s = "10,1,1,-1,0,12,-10";
        String[] ss = s.split(","); //to jest tablica
        for(String x : ss) {
            System.out.println(x);
        }
        //wstęp do tablic w Java
        System.out.println(Arrays.toString(ss));
        System.out.println(ss.length);  //liczba elementow
        System.out.println(ss[0]);  //odczyt pierwszego elementu
        ss[1] = "111";  //przypisanie
        System.out.println(Arrays.toString(ss));
    }
}
