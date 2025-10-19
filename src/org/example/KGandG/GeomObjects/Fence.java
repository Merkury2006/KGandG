package org.example.KGandG.GeomObjects;

import java.awt.*;

public class Fence {
    public interface ColorProvider {
        Color getColor();
    }
    private int x, y, width, height;
    private ColorProvider colorProvider;

    public Fence(int x, int y, int width, int height, ColorProvider colorProvider) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.colorProvider = colorProvider;
    }

    public  void draw(Graphics2D g) {
        g.setColor(colorProvider.getColor());
        g.setStroke(new BasicStroke((float) width / 16));
        for (int curX = x; curX <= x + width; curX += width / 4) {
            g.drawLine(curX, y, curX, y + height);
        }
        g.setStroke(new BasicStroke((float) width /32));
        for (int curY = y; curY <= y + height; curY += height / 2) {
            g.drawLine(x, curY, x + width, curY);
        }
    }
}
