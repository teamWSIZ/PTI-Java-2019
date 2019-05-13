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
    void evolve() {
        //zamiast prostej metody Eulera, dokladniejsza https://en.wikipedia.org/wiki/Midpoint_method
        double rr = getR();
        double ff = getF(x, y);
        double ffx = x / rr * ff;
        double ffy = y / rr * ff;

        double x1 = x + vx * dt / 2;
        double y1 = y + vy * dt / 2;
        double vx1 = vx + ffx * dt / 2;
        double vy1 = vy  + ffy * dt / 2;

        double rrr = Math.sqrt(x1*x1+y1*y1);
        double fff = getF(x1, y1);
        double fx = x1 / rrr * fff;
        double fy = y1 / rrr * fff;

        x += dt / 2 * vx1;
        y += dt / 2 * vy1;
        vx += dt / 2 * fx;
        vy += dt / 2 * fy;
    }

    double getR() {
        return Math.sqrt(x * x + y * y);
    }

    double getF(double xx, double yy) {
        double rr = Math.sqrt(xx*xx + yy*yy);
        return - 100000. / (rr * rr);
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
        planet = new Planet(200, 0, 0.5, 10, 0.0001);
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
            planet.evolve();
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
