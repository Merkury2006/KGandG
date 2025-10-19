package org.example.KGandG.GeomObjects;

import java.awt.*;
import java.awt.geom.Path2D;

public class Fir {
    public interface ColorProvider{
        Color getColorOfTree();
        Color getColorOfTrunk();
    }
    private int x, y, size;
    private ColorProvider colorProvider;

    private Path2D path = new Path2D.Double();

    public Fir(int x, int y, int size, ColorProvider colorProvider) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.colorProvider = colorProvider;
    }

    public void draw(Graphics2D g) {
        path.moveTo(x, y);
        path.lineTo(x - size, y + size);
        path.lineTo(x + size, y + size);

        path.moveTo(x, y + size * 0.7);
        path.lineTo(x - size * 1.5, y + size * 2);
        path.lineTo(x + size * 1.5, y + size * 2);

        path.moveTo(x, y + size * 1.7);
        path.lineTo(x - size * 2, y + size * 3);
        path.lineTo(x + size * 2, y + size * 3);

        path.closePath();

        g.setColor(colorProvider.getColorOfTree());
        g.fill(path);
        path.reset();
        g.setColor(colorProvider.getColorOfTrunk());
        g.fillRect((int) (x - size * 0.3), y + size * 3, (int) (size * 0.6), (int) (size * 0.4));
    }

}
