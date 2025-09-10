import java.awt.*;

public class Cloud {
    private int x, y, r;
    private Color c;

    public Cloud(int x, int y, int r,Color c) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.c = c;
    }

    public void draw(Graphics2D g) {
        g.setColor(c);
        g.fillOval(x - r, y - r, r + r, r + r);
        g.fillOval((int) (x - 1.7 * r), (int) (y - 0.5 * r), (int) (r + 0.4 * r), (int) (r + 0.4 * r));
        g.fillOval((int) (x + 0.3 * r), (int) (y - 0.5 * r), (int) (r + 0.4 * r), (int) (r + 0.4 * r));
    }

}
