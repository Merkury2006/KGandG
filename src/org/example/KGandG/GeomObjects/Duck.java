package org.example.KGandG.GeomObjects;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;

public class Duck {
    public interface Factory {
        Duck create(int x, int y, int size, double speed, int duckIndex);
    }
    public interface ColorProvider{
        Color getColorOfBeak();
        Color getColorOfNeck();
        Color getColorOfHead();
        Color getColorOfEye();
        Color getColorOfInsideOfEye();
        Color getColorOfBody();
        Color getColorOfWing();
    }

    private double x;
    private int y, size;
    private double baseSpeed;
    private double currentSpeed;
    private ColorProvider colorProvider;

    private boolean facingRight;
    private int minX, maxX;

    private Path2D path;

    public int getY() {
        return y;
    }


    public Duck(int x, int y, int size, double speed, ColorProvider colorProvider) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.baseSpeed = speed;
        this.currentSpeed = baseSpeed;
        this.colorProvider = colorProvider;
    }

    public void setSpeed(boolean isDay) {
        if (isDay) {
            this.currentSpeed = baseSpeed;
        }
        else {
            this.currentSpeed = baseSpeed / 2;
        }
    }

    public double getSpeed() {
        return currentSpeed;
    }

    public void setDirection(boolean facingRight) {
        this.facingRight = facingRight;
    }

    public void setBounds(int minX, int maxX) {
        this.minX = minX;
        this.maxX = maxX;
    }

    public void update() {
        if (facingRight) {
            x += currentSpeed;
            if (x > maxX) {
                facingRight = false;
            }
        } else {
            x -= currentSpeed;
            if (x < minX) {
                facingRight = true;
            }
        }
    }
    
    public void draw(Graphics2D g) {
        if (facingRight) {
            drawTowardsRight(g);
        }
        else {
            drawTowardsLeft(g);
        }
    }
    
    private void  drawTowardsLeft(Graphics2D g) {
        path = new Path2D.Double();
        //Клюв
        g.setColor(colorProvider.getColorOfBeak());
        path.moveTo(x, y);
        path.lineTo(x + 0.5 * size, y + 0.3 * size);
        path.lineTo(x + 0.5 * size, y - 0.3 * size);
        path.closePath();
        g.fill(path);

        path = new Path2D.Double();
        //Шея
        g.setColor(colorProvider.getColorOfNeck());
        path.moveTo(x + 1.3 * size, y + 0.1 * size);
        path.curveTo(x + 0.5 * size, y + size, x - size * 0.5, y + 1.5 * size, x + size, y  + 2 * size);
        path.curveTo(x + size, y  + 2 * size, x + size * 0.2, y + 1.5 * size, x + 0.8 * size, y + size);
        path.lineTo(x + 1.4 * size, y + 0.1 * size);
        path.closePath();
        g.fill(path);

        //Голова
        g.setColor(colorProvider.getColorOfHead());
        g.fillOval((int) (x + 0.4 * size), (int) (y - 0.5 * size), size, size);
        g.setColor(colorProvider.getColorOfEye());
        g.fillOval((int) (x + 0.6 * size), (int) (y - 0.3 * size), size / 2, size / 2);
        g.setColor(colorProvider.getColorOfInsideOfEye());
        g.fillOval((int) (x + 0.75 * size), (int) (y - 0.15 * size), size / 6, size / 6);

        //Туловище
        g.setColor(colorProvider.getColorOfBody());
        g.fillOval((int) (x + size * 0.2), (int) (y + 1.1 * size), size * 3, size);


        //Крыло
        g.setColor(colorProvider.getColorOfWing());
        g.fillOval((int) (x + size), (int) (y + 1.4 * size), size * 2, size / 3);
    }


    private void drawTowardsRight(Graphics2D g) {
       drawMirror(g);
    }

    private void drawMirror(Graphics2D g) {
        AffineTransform original = g.getTransform();
        g.translate(x + size * 1.5, 0);
        g.scale(-1, 1);
        g.translate(-x - size * 1.5, 0);
        drawTowardsLeft(g);
        g.setTransform(original);
    }
}
