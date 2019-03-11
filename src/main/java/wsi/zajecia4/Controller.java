package wsi.zajecia4;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller {
    @FXML private TextField tf1;
    @FXML private TextField tf2;
    int x = 0;
    public void klikeeed() {
        x = x+1;
        int liczbaN = Integer.valueOf(tf1.getText());
        liczbaN += 10;
        System.out.println("przycisk został naciśnięty.. " + x + " razy");
        tf2.setText("" + liczbaN * (liczbaN+1)/2 );
    }
}
