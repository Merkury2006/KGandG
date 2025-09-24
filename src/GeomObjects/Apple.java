package GeomObjects;

import java.awt.*;

public class Apple {
    private int x, y, size;
    private Color color;

    public Apple(int x, int y, int size, Color color) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Apple(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
    }

    public void draw(Graphics2D g){
        g.setColor(color);
        g.fillOval(x, y, size, size);
    }


}
