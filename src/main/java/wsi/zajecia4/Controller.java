package wsi.zajecia4;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller {
    @FXML private TextField tf1;
    @FXML private TextField tf2;
    int x = 0;
    public void klikeeed() {
        x = x+1;
        int liczbaN = 0;
        String s = tf1.getText();
        try {
            liczbaN = Integer.valueOf(s);
        } catch (NumberFormatException e) {
            System.out.println("tu ma byc liczba a nie [" + s + "]");
        }
        liczbaN += 10;
        System.out.println("przycisk został naciśnięty.. " + x + " razy");
        tf2.setText("" + liczbaN * (liczbaN+1)/2 );
    }
}
