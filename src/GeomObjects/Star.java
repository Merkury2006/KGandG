package GeomObjects;

import java.awt.*;

public class Star {
    private int x, y, r;
    private Color c;
    private float phase, speed;

    public Star(int x, int y) {
        this.x = x;
        this.y = y;
        this.r = 1 + (int)(Math.random() * 3);
        this.phase = (float) (Math.random() * 2 * Math.PI);
        this.speed = 0.05f + (float) Math.random() * 0.03f;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public Color getColor() { return c; }

    public void setC(Color c) {
        this.c = c;
    }

    public void draw(Graphics2D g) {
        float intensity = 0.3f + 0.7f * (float) ((Math.sin(phase) + 1) / 2);
        int currentRadius = (int) (r * intensity);
        g.setColor(new Color(c.getRed(), c.getGreen(), c.getBlue(), (int) (255 * intensity)));
        g.fillOval(x - currentRadius, y - currentRadius, currentRadius * 2, currentRadius * 2);
    }

    public void update() {
        phase += speed;
        if (phase > 2 * Math.PI) {
            phase -= 2 * Math.PI;
        }
    }
}
