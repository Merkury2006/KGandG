package org.example.KGandG.GeomObjects;

import java.awt.*;

public class Stone {
    public interface Factory {
        Stone create(int x, int y, int width, int height, int stoneIndex);
    }

    public interface ColorProvider{
        Color getColor();
    }

    private int x, y, width, height;
    private ColorProvider colorProvider;

    public Stone(int x, int y, int width, int height, ColorProvider colorProvider) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.colorProvider = colorProvider;
    }

    public void draw(Graphics2D g){
        g.setColor(colorProvider.getColor());
        g.fillOval(x, y, width, height);
    }
}
