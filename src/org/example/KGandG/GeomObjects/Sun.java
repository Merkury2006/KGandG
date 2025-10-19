package org.example.KGandG.GeomObjects;

import java.awt.*;

public class Sun {
    public interface ColorProvider{
        Color getColor();
    }
    private final int n = 8;
    private int x, y, r, R;
    private ColorProvider colorProvider;

    public Sun(int x, int y, int r, int r1, ColorProvider colorProvider) {
        this.x = x;
        this.y = y;
        this.r = r;
        R = r1;
        this.colorProvider = colorProvider;
    }

    public void draw(Graphics2D g) {
        g.setColor(colorProvider.getColor());
        g.fillOval(x - r, y - r, r + r, r + r);
        double da = 2 * Math.PI / n;
        for (int i = 0; i < n; i ++) {
            double a = da * i;
            double x1 = x + r * Math.cos(a);
            double y1 = y + r * Math.sin(a);
            double x2 = x + R * Math.cos(a);
            double y2 = y + R * Math.sin(a);
            g.setStroke(new BasicStroke((float) r / 10));
            g.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
        }
    }
}
