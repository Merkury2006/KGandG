package org.example.KGandG.GeomObjects;

import java.awt.*;

public class Background {
    public interface ColorProvider{
        Color getColorOfSky();
        Color getColorOfGround();
    }
    private int width;
    private int height;
    private int amplitude;
    private int period;
    private ColorProvider colorProvider;

    public Background(int width, int height, int amplitude, int period, ColorProvider colorProvider) {
        this.width = width;
        this.height = height;
        this.amplitude = amplitude;
        this.period = period;
        this.colorProvider = colorProvider;
    }

    public void draw(Graphics2D g) {
        int centerY = height / 2;
        g.setColor(Color.BLACK);

        Polygon bottomPoly = new Polygon();
        Polygon topPoly = new Polygon();
        for (int x = 0; x < width; x++) {
            double radians = 2 * Math.PI * x / period;
            int y = centerY - (int) (amplitude * Math.sin(radians));
            bottomPoly.addPoint(x, y);
            topPoly.addPoint(x, y);
        }

        bottomPoly.addPoint(width, height);
        bottomPoly.addPoint(0, height);

        topPoly.addPoint(width, 0);
        topPoly.addPoint(0, 0);

        g.setColor(colorProvider.getColorOfGround());
        g.fill(bottomPoly);

        g.setColor(colorProvider.getColorOfSky());
        g.fill(topPoly);
    }
}
