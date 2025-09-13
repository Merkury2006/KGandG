import java.awt.*;
import java.awt.geom.AffineTransform;

public class Fence {
    private int x, y, width, height;
    private Color color;

    public Fence(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public  void draw(Graphics2D g) {
        g.setColor(color);
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
