package GeomObjects;

import java.awt.*;

public class Moon {
    private int center, r;
    private double coefficient;
    private Color color;

    public Moon(int center, int r, double coefficient, Color color) {
        this.center = center;
        this.r = r;
        this.coefficient = coefficient;
        this.color = color;
    }

    public void draw(Graphics2D g, Color backgroundColor) {
        g.setColor(color);
        g.fillOval(center - r, center - r, (int) coefficient * (r + r), (int) coefficient * (r+ r));
        g.setColor(backgroundColor);
        g.fillOval((center - r / 2), center - r, (int) coefficient * (r + r) , (int) coefficient * (r + r));
    }
}
