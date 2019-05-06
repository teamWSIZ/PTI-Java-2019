package wsi.zajecia6;

public class BulletTest {
    public static void main(String[] args) {
        Bullet b = new Bullet(10,10,-1,5,1);

        for (int i = 0; i < 20; i++) {
            System.out.println(b);
            b.move();
        }


    }
}
