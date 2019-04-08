package wsi.zajecia6;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

//dialogi w javafx:
//https://code.makery.ch/blog/javafx-dialogs-official/
public class Controller {
    int x = 0;
    @FXML private TextField tf1;
    @FXML private TextField tf2;
    @FXML private TextField wynikiWyborow;
    @FXML private Canvas img;
    private GraphicsContext gc ;

    @FXML
    public void initialize() {
        System.out.println("second");
        gc = img.getGraphicsContext2D();
    }

    public void findWinner() {
        String wpisano = wynikiWyborow.getText();
        System.out.println(wpisano);
    }

    public void klikeeed() {
        x = x+1;
        int liczbaN = 0;
        String s = tf1.getText();
        try {
            liczbaN = Integer.valueOf(s);
        } catch (NumberFormatException e) {
            String message = "Expecting an integer, found [" + s + "]";

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("неправильный ввод");
            alert.setHeaderText("Wrong input in the text filed encountered");
            alert.setContentText(message);

            alert.showAndWait();
        }
        liczbaN += 10;
        System.out.println();
        tf2.setText("" + liczbaN * (liczbaN+1)/2 );
    }

    public void alertuj(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.WARNING);


        ImageView view = new ImageView(new Image("missile.png"));
        view.setFitHeight(100);
        view.setFitWidth(100);
        alert.setGraphic(view);

        alert.setTitle("Missile alert");
        alert.setHeaderText("Rockets are heading to your location; take cover now!");
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image("missile.png")); // To add an icon
        alert.showAndWait();
    }

    public void draw() {
        gc.setFill(Color.AQUA);
        gc.fillRect(10,10,100,100);
        gc.setStroke(Color.BLUEVIOLET);
        gc.strokeRoundRect(10, 10, 50, 50, 10, 10);
        gc.fillOval(70, 10, 50, 20);
        gc.strokeText("Hello Canvas", 150, 20);
        gc.lineTo(400,30);
        gc.strokeLine(30,60,40,20);

        gc.drawImage(new Image("missile.png"), 100,200 );
    }
}
