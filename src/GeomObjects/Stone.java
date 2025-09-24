package GeomObjects;

import java.awt.*;

public class Stone {
    private int x, y, width, height;
    private Color color;

    public Stone(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Stone(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void draw(Graphics2D g){
        g.setColor(color);
        g.fillOval(x, y, width, height);
    }
}
