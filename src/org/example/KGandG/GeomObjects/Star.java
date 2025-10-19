package org.example.KGandG.GeomObjects;

import java.awt.*;

public class Star {
    public interface ColorProvider{
        Color getColor();
    }
    private int x, y, r;
    private ColorProvider colorProvider;
    private float phase, speed;

    public Star(int x, int y, ColorProvider colorProvider) {
        this.x = x;
        this.y = y;
        this.colorProvider = colorProvider;
        this.r = 1 + (int)(Math.random() * 3);
        this.phase = (float) (Math.random() * 2 * Math.PI);
        this.speed = 0.05f + (float) Math.random() * 0.03f;
    }

    public int getX() { return x; }
    public int getY() { return y; }

    public void update() {
        phase += speed;
        if (phase > 2 * Math.PI) {
            phase -= 2 * Math.PI;
        }
    }

    public void draw(Graphics2D g) {
        float intensity = 0.3f + 0.7f * (float) ((Math.sin(phase) + 1) / 2);
        int currentRadius = (int) (r * intensity);
        g.setColor(new Color(colorProvider.getColor().getRed(), colorProvider.getColor().getGreen(), colorProvider.getColor().getBlue(), (int) (255 * intensity)));
        g.fillOval(x - currentRadius, y - currentRadius, currentRadius * 2, currentRadius * 2);
    }
}
