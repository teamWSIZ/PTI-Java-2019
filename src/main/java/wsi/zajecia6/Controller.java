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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

import static javafx.scene.input.MouseEvent.MOUSE_CLICKED;
import static javafx.scene.input.MouseEvent.MOUSE_MOVED;


//dialogi w javafx:
//https://code.makery.ch/blog/javafx-dialogs-official/
public class Controller {
    int x = 0;
    @FXML private TextField tf1;
    @FXML private TextField tf2;
    @FXML private TextField wynikiWyborow;
    @FXML private Canvas canvas;
    private GraphicsContext gc ;


    private List<Sprite> sprites; //wszystkie obiekty animacji


    double cannonAngle = 45;
    double cannonX = 0;
    double cannonY = 200;
    double cannonLength = 70;




    @FXML
    public void initialize() {
        //uruchamiana przy włączaniu aplikacji
        System.out.println("second");
        gc = canvas.getGraphicsContext2D(); //wyciągamy context z pola typu canvas
        sprites = new ArrayList<>();
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
//        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
//        stage.getIcons().add(new Image("missile.png")); // To add an icon
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

        canvas.addEventHandler(MOUSE_CLICKED, t -> {
            targetX = (int)t.getX();
            targetY = (int)t.getY();
        });

        canvas.addEventHandler(MOUSE_MOVED, t-> {
            mouseMovedCounter++;
            System.out.println("mm: " + mouseMovedCounter);
            targetX = (int)t.getX();
            targetY = (int)t.getY();
        });

        //pozwala na reagowanie na klawisze podczas animacji na canvas
        canvas.addEventFilter(MouseEvent.ANY, (e) -> canvas.requestFocus());

        canvas.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode() == KeyCode.UP) cannonAngle += Math.PI/120;
            if (event.getCode() == KeyCode.DOWN) cannonAngle -= Math.PI/120;

            if (event.getCode() == KeyCode.SPACE) {
                System.out.println("FIRE !!!!!!!!!!!!!!");
                //tu wejdzie logika tworzenia pocisku
                double v = 1.;
                double bulletVx = v * Math.cos(cannonAngle);
                double bulletVy = - v * Math.sin(cannonAngle);

                sprites.add(new Bullet(cannonX, cannonY, bulletVx, bulletVy, -0.01));
            }
            event.consume();
        });

        int FPS = 30;

        // TODO: dzialko MSTA, strzelajace na spacji
        Timeline animacja = new Timeline(new KeyFrame(Duration.millis(1000 / FPS),
                event -> {
                    //Narysuj całą planszę na nowo
                    gc.clearRect(0, 0, 800, 800);

                    angle += 0.03;
                    drawTarget();
                    drawProgressBar();
                    drawCannon();
                    drawBullet();
                    for(Sprite s : sprites) {
                        s.move();
                    }
                    for(Sprite s : sprites) {
                        s.draw(gc);
                    }


                    //...
                }));
        animacja.setCycleCount(Timeline.INDEFINITE);
        animacja.play();


    }

    private void drawBullet() {

    }

    private void drawCannon() {
        gc.strokeLine(cannonX, cannonY,
                cannonX + cannonLength * Math.cos(cannonAngle),
                cannonY - cannonLength * Math.sin(cannonAngle));
    }
}
