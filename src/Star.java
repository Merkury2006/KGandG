import java.awt.*;

public class Star {
    private int x, y, r;
    private Color c;

    public Star(int x, int y, Color c) {
        this.x = x;
        this.y = y;
        this.c = c;
        this.r = 1 + (int)(Math.random() * 3);
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public Color getColor() { return c; }
    public int getSize() { return r; }

    public void draw(Graphics2D g) {
        g.setColor(c);
        g.fillOval(x - r, y - r, r, r);
    }
}
