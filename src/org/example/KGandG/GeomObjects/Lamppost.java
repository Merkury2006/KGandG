package org.example.KGandG.GeomObjects;

import java.awt.*;

public class Lamppost {
    public interface ColorProvider {
        Color getColorOfPost();
        Color getColorOfLamp();
    }
    private int x, y, size;
    private ColorProvider colorProvider;

    public Lamppost(int x, int y, int size, ColorProvider colorProvider) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.colorProvider = colorProvider;
    }

    public void draw(Graphics2D g) {
        g.setColor(colorProvider.getColorOfPost());
        g.fillRect(x - size / 4, y, size / 4, size / 32);
        g.fillRect(x, y, size / 16, size);
        g.setColor(colorProvider.getColorOfLamp());
        g.fillOval((int) (x - size / 3.5), y, size / 6, size / 16);
    }
}
