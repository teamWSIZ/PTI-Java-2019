package wsi.zajecia6;

import javafx.scene.canvas.GraphicsContext;

public class Bullet implements Sprite {
    double x, y, vx, vy, g;
    boolean alive;

    public Bullet(double x, double y, double vx, double vy, double g) {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.g = g;
        alive = true;
    }

    @Override
    public void move() {
        x += vx;
        y += vy;
        vy -= g;
        if (x>300 || x<0) {
            alive = false;
        }
    }

    @Override
    public void draw(GraphicsContext gc) {
        double bulletVelocityAngle = Math.atan2(vy, vx);
        double lx = 10 * Math.cos(bulletVelocityAngle);
        double ly = 10 * Math.sin(bulletVelocityAngle);
        gc.strokeLine(x - lx, y - ly, x + lx, y + ly);
    }

    @Override
    public boolean isAlive() {
        return alive;
    }

    @Override
    public boolean collidesWith(double x, double y, double r) {
        double dx = x - this.x;
        double dy = y - this.y;
        double distance = Math.sqrt(dx*dx + dy*dy);
        return distance<r;
    }

    @Override
    public void kill() {
        alive = false;
    }

    @Override
    public String toString() {
        return "Bullet{" +
                "x=" + x +
                ", y=" + y +
                ", vx=" + vx +
                ", vy=" + vy +
                ", g=" + g +
                ", alive=" + alive +
                '}';
    }
}
