package GeomObjects;

import java.awt.*;

public class Moon {
    private int center, r;
    private Color color;
    private Color skyColor;

    public Moon(int center, int r, Color color, Color skyColor) {
        this.center = center;
        this.r = r;
        this.color = color;
        this.skyColor = skyColor;
    }

    public Moon(int center, int r) {
        this.center = center;
        this.r = r;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setSkyColor(Color skyColor) {
        this.skyColor = skyColor;
    }

    public void draw(Graphics2D g) {
        g.setColor(color);
        g.fillOval(center - r, center - r,  2 * r,  2 * r);
        g.setColor(skyColor);
        g.fillOval(center - r / 2, center - r, 2 * r,  2 * r);
    }
}
