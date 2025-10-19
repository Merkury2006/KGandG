package org.example.KGandG.GeomObjects;
import java.awt.*;

public class Apple {
    public interface Factory {
        Apple create(int x, int y, int size, int indexApple);
    }
    public interface ColorProvider {
        Color getColor();
    }
    private int x, y, size;
    private ColorProvider colorProvider;

    public Apple(int x, int y, int size, ColorProvider colorProvider) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.colorProvider = colorProvider;
    }

    public void draw(Graphics2D g){
        g.setColor(colorProvider.getColor());
        g.fillOval(x, y, size, size);
    }


}
