package wsi.zajecia6;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static javafx.scene.input.MouseEvent.MOUSE_CLICKED;
import static javafx.scene.input.MouseEvent.MOUSE_MOVED;


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
        //uruchamiana przy włączaniu aplikacji
        System.out.println("second");
        gc = img.getGraphicsContext2D(); //wyciągamy context z pola typu canvas
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
        gc.setFill(Color.rgb(20,30,30,0.6));
        gc.setStroke(Color.BLUEVIOLET);

        gc.fillRect(10,10,100,100);
        gc.strokeRoundRect(10, 10, 50, 50, 10, 10);
        gc.fillOval(70, 10, 50, 20);

        Font f = gc.getFont();
        Font nowy = new Font(f.getName(), 30);
        gc.setFont(nowy);

        gc.strokeText("♛ ♖ ♗ ♞ ♟ ♟ ♟", 10, 40);
        System.out.println(gc.getFont());



        for (int i = 0; i < 40; i++) {
            gc.strokeLine(0,0,100,100 + i * 10);
        }

        int size = 40;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if ((i+j)%2==0) {
                    gc.fillRect(i* size, j*size, size, size);
                }
            }
        }

        gc.drawImage(new Image("missile.png"), 100,200 );
    }

    int mouseMovedCounter = 0;
    int targetX = 0;
    int targetY = 0;
    double angle;

    void drawTarget() {
        gc.strokeRect(targetX - 10, targetY - 10, 20, 20);
        gc.strokeLine(targetX-10,targetY, targetX+10,targetY);
        gc.strokeLine(targetX,targetY-10, targetX,targetY+10);
    }

    void drawProgressBar() {
        double r = 30;
        double dx = Math.sin(angle) * r;
        double dy = Math.cos(angle) * r;
        gc.strokeLine(targetX + dx, targetY + dy, targetX-dx, targetY-dy);
    }

    public void animate() {
        gc.setFill(Color.rgb(20,30,30,0.6));
        gc.setStroke(Color.BLUEVIOLET);
        gc.strokeRoundRect(10, 10, 50, 50, 10, 10);

        img.addEventHandler(MOUSE_CLICKED, t -> {
            targetX = (int)t.getX();
            targetY = (int)t.getY();
        });

        img.addEventHandler(MOUSE_MOVED, t-> {
            mouseMovedCounter++;
            System.out.println("mm: " + mouseMovedCounter);
            targetX = (int)t.getX();
            targetY = (int)t.getY();
        });

        int FPS = 60;

        //Zadanie: znalezc 20 klatek animacji postaci...
        //np. z LoL
        //np. zaczynajac szukac tu: https://www.deviantart.com/leagueoflegends

        Timeline animacja = new Timeline(new KeyFrame(Duration.millis(1000 / FPS),
                event -> {
//                    System.out.println("event animacji odpalony " + new Date());
                    //Narysuj całą planszę na nowo
                    gc.clearRect(0, 0, 800, 800);

                    angle += 0.03;
                    drawTarget();
                    drawProgressBar();

                    //...
                }));
        animacja.setCycleCount(Timeline.INDEFINITE);
        animacja.play();


    }
}
