package GeomObjects;

import java.awt.*;

public class Bush {
    private final int n = 5;
    private int x, y, size;
    private Color color;

    public Bush(int x, int y, int size, Color color) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
    }

    public void draw(Graphics2D g) {
        g.setColor(color);
        for (int i = x - size; i <= x + size; i += size) {
            int curX = i;
            int curY = y + size;
            if (curX == x) {
                curY -= size;
            }

            double da = 2 * Math.PI / n;
            for (int j = 0; j < n; j++) {
                double a = da * j;
                double x1 = curX + (double) size / 2 * Math.cos(a);
                double y1 = curY + (double) size / 2 * Math.sin(a);
                double x2 = curX + size * Math.cos(a);
                double y2 = curY + size * Math.sin(a);
                g.fillOval((int) ((x1 + x2) / 2) - size, (int) ((y1 + y2) / 2) - size, size + size, size + size);
            }
        }
    }
}
