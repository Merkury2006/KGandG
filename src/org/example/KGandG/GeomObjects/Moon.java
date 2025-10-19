package org.example.KGandG.GeomObjects;

import java.awt.*;

public class Moon {
    public interface ColorProvider{
        Color getColorOfMoon();
        Color getColorOfSky();
    }
    private int center, r;
    private ColorProvider colorProvider;

    public Moon(int center, int r, ColorProvider colorProvider) {
        this.center = center;
        this.r = r;
        this.colorProvider = colorProvider;
    }

    public void draw(Graphics2D g) {
        g.setColor(colorProvider.getColorOfMoon());
        g.fillOval(center - r, center - r,  2 * r,  2 * r);
        g.setColor(colorProvider.getColorOfSky());
        g.fillOval(center - r / 2, center - r, 2 * r,  2 * r);
    }
}
