import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;

public class Duck {
    private int x, y, size;
    private Color colorOfBeak, colorOfNeck, colorOfHead, colorOfEye, colorOfInsideOfEye, colorOfBody, colorOfWing;

    public Duck(int x, int y, int size, Color colorOfBeak, Color colorOfNeck, Color colorOfHead, Color colorOfEye, Color colorOfInsideOfEye, Color colorOfBody, Color colorOfWing) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.colorOfBeak = colorOfBeak;
        this.colorOfNeck = colorOfNeck;
        this.colorOfHead = colorOfHead;
        this.colorOfEye = colorOfEye;
        this.colorOfInsideOfEye = colorOfInsideOfEye;
        this.colorOfBody = colorOfBody;
        this.colorOfWing = colorOfWing;
    }

    public void  drawTowardsLeft(Graphics2D g) {
        //Клюв
        g.setColor(colorOfBeak);
        Path2D path = new Path2D.Double();
        path.moveTo(x, y);
        path.lineTo(x + 0.5 * size, y + 0.3 * size);
        path.lineTo(x + 0.5 * size, y - 0.3 * size);
        path.closePath();
        g.fill(path);

        //Шея
        g.setColor(colorOfNeck);
        path.moveTo(x + 1.3 * size, y + 0.1 * size);
        path.curveTo(x + 0.5 * size, y + size, x - size * 0.5, y + 1.5 * size, x + size, y  + 2 * size);
        path.curveTo(x + size, y  + 2 * size, x + size * 0.2, y + 1.5 * size, x + 0.8 * size, y + size);
        path.lineTo(x + 1.4 * size, y + 0.1 * size);
        path.closePath();
        g.fill(path);


        //Голова
        g.setColor(colorOfHead);
        g.fillOval((int) (x + 0.4 * size), (int) (y - 0.5 * size), size, size);
        g.setColor(colorOfEye);
        g.fillOval((int) (x + 0.6 * size), (int) (y - 0.3 * size), size / 2, size / 2);
        g.setColor(colorOfInsideOfEye);
        g.fillOval((int) (x + 0.75 * size), (int) (y - 0.15 * size), size / 6, size / 6);

        //Туловище
        g.setColor(colorOfBody);
        g.fillOval((int) (x + size * 0.2), (int) (y + 1.1 * size), size * 3, size);


        //Крыло
        g.setColor(colorOfWing);
        g.fillOval((int) (x + size), (int) (y + 1.4 * size), size * 2, size / 3);
    }


    public void drawTowardsRight(Graphics2D g) {
        drawMirror(g);
    }

    private void drawMirror(Graphics2D g) {
        AffineTransform original = g.getTransform();
        AffineTransform mirror = new AffineTransform();
        mirror.translate(x, y);
        mirror.scale(-1, 1);
        mirror.translate(-x, -y);
        g.setTransform(mirror);
        drawTowardsLeft(g);
        g.setTransform(original);
    }
}
