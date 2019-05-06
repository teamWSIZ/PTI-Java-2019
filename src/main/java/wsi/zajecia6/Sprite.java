package wsi.zajecia6;

import javafx.scene.canvas.GraphicsContext;

public interface Sprite {
    void move();
    void draw(GraphicsContext gc);
    boolean isAlive();
    boolean collidesWith(double x, double y, double r);
    void kill();
}
