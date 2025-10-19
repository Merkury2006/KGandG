package org.example.KGandG.GeomObjects;

import java.awt.*;

public class Cloud {
    public interface ColorProvider{
        Color getColor();
    }

    private int x, y, r;
    private int speed;
    private double angle = 0;
    private double amplitude;
    private double period;
    private ColorProvider colorProvider;


    public Cloud(int x, int y, int r, int speed, ColorProvider colorProvider) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.speed = speed;
        this.amplitude = 5;
        this.period = 0.02 + Math.random() * 0.03;
        this.colorProvider = colorProvider;
    }

    public void update(int width) {
        angle += period;
        x += speed;
        int verticalMovement = (int)(amplitude * Math.sin(angle));
        if (x > width * 1.15) {
            x = -width/12;
        }
    }

    public void draw(Graphics2D g) {
        int currentY = y + (int)(amplitude * Math.sin(angle));
        g.setColor(colorProvider.getColor());
        g.fillOval(x - r, currentY - r, r + r, r + r);
        g.fillOval((int) (x - 1.7 * r), (int) (currentY - 0.5 * r), (int) (r + 0.4 * r), (int) (r + 0.4 * r));
        g.fillOval((int) (x + 0.3 * r), (int) (currentY - 0.5 * r), (int) (r + 0.4 * r), (int) (r + 0.4 * r));
    }
}
