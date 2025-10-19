package org.example.KGandG.GeomObjects;

import java.awt.*;

public class Flower {
    public interface ColorProvider {
        Color getColorOfStem();
        Color getColorOfPetals();
        Color getColorOfCenterFlower();
    }

    public interface Factory {
        Flower create(int x, int y, int size, int flowerIndex);
    }

    private final int n = 5;
    private int x, y, size;
    private ColorProvider colorProvider;

    public Flower(int x, int y, int size, ColorProvider colorProvider) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.colorProvider = colorProvider;
    }

    public void draw(Graphics2D g) {
        int n = 5;

        //Стебель
        g.setColor(colorProvider.getColorOfStem());
        g.setStroke(new BasicStroke((float) (size / 2.5)));
        g.drawLine((int) (x - (double) size / 2), (int) (y - (double) size / 2), (int) (x - (double) size / 2), y + size);


        //Лепестки
        g.setColor(colorProvider.getColorOfPetals());
        g.setStroke(new BasicStroke(1));
        double da = 2 * Math.PI / n;
        for (int j = 0; j < n; j++) {
            double a = da * j;
            double x1 = x + (double) size / 2 * Math.cos(a);
            double y1 = y + (double) size / 2 * Math.sin(a);
            g.fillOval((int) (x1 - size), (int) (y1 - size), size, size);
        }

        //Центр цветка
        g.setColor(colorProvider.getColorOfCenterFlower());
        g.fillOval(x - size, y - size, size, size);

    }
}
