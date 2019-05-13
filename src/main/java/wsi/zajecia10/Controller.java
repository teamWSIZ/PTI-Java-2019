package wsi.zajecia10;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import lombok.AllArgsConstructor;

@AllArgsConstructor
class Planet {
    double x, y, vx, vy;
    double dt;

    // zmien pozycje i predkosci przy podanej sile dzialajacej do srodka
    void evolve(double f) {
        double r = getR();
        double fx = x / r * f;
        double fy = y / r * f;

        x += vx * dt;
        y += vy * dt;
        vx += fx * dt;
        vy += fy * dt;
    }

    double getR() {
        return Math.sqrt(x * x + y * y);
    }

}

//dialogi w javafx:
//https://code.makery.ch/blog/javafx-dialogs-official/
public class Controller {
    int x = 0;
    @FXML private Canvas canvas;
    private GraphicsContext gc;
    Planet planet;

    double cx = 400;
    double cy = 400;
    double radius = 300;
    double alpha = 0;
    double dalpha = 0.005;

    @FXML
    public void initialize() {
        gc = canvas.getGraphicsContext2D(); //wyciągamy context z pola typu canvas
        planet = new Planet(200, 0, 0.5, 20, 0.00001);
    }

    public void start() {
        gc.setFill(Color.rgb(20, 30, 30, 0.6));
        gc.strokeRoundRect(10, 10, 50, 50, 10, 10);

        int FPS = 60;
        Timeline animacja = new Timeline(new KeyFrame(Duration.millis(1000 / FPS),
                event -> {
                    //Narysuj całą planszę na nowo
//                    gc.clearRect(0,0,800,800);
                    drawSimpleCircle();
                    drawPlanet();
                }));
        animacja.setCycleCount(Timeline.INDEFINITE);
        animacja.play();

    }

    private void drawPlanet() {
        double r = planet.getR();
        for (int i = 0; i < 2000; i++) {
            planet.evolve(- 100000. / (r * r));
        }
        gc.fillOval(planet.x + cx, planet.y + cy, 10,10);

    }

    private void drawSimpleCircle() {
        gc.setStroke(Color.DARKOLIVEGREEN);
        gc.strokeOval(cx, cy, 8, 8);
        gc.setStroke(Color.BLUE);
        gc.fillOval(cx + radius * Math.cos(alpha), cy + radius * Math.sin(alpha), 10, 10);
        alpha += dalpha;
    }



}
