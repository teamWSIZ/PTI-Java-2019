package wsi.zajecia5;

import java.util.Random;

public class ProbPi {
    public static void main(String[] args) {
        Random r = new Random();

        int cnt = 0;
        int full = (int)1e8;
        for (int i = 0; i < full; i++) {
            double x = r.nextDouble();
            double y = r.nextDouble();
            if (Math.sqrt(x*x + y*y)<1) cnt++;
        }

        System.out.println(4. * cnt / full);


    }
}
