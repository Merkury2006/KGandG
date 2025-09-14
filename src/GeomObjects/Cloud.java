package GeomObjects;

import java.awt.*;

public class Cloud {
    private int x, y, r;
    private int speed;
    private Color c;
    private double angle = 0;
    private double amplitude;
    private double period;


    public Cloud(int x, int y, int r, int speed, Color c) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.speed = speed;
        this.c = c;
        this.amplitude = 5;
        this.period = 0.02 + Math.random() * 0.03;
    }

    public void draw(Graphics2D g) {
        int currentY = y + (int)(amplitude * Math.sin(angle));
        g.setColor(c);
        g.fillOval(x - r, currentY - r, r + r, r + r);
        g.fillOval((int) (x - 1.7 * r), (int) (currentY - 0.5 * r), (int) (r + 0.4 * r), (int) (r + 0.4 * r));
        g.fillOval((int) (x + 0.3 * r), (int) (currentY - 0.5 * r), (int) (r + 0.4 * r), (int) (r + 0.4 * r));
    }

    public void update() {
        angle += period;
        x += speed;
        int verticalMovement = (int)(amplitude * Math.sin(angle));
        if (x > 1400) {
            x = -100;
        }
    }


}
