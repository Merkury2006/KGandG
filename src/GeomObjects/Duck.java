package GeomObjects;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;

public class Duck {
    private int x, y, size;
    private int speed;
    private Color colorOfBeak, colorOfNeck, colorOfHead, colorOfEye, colorOfInsideOfEye, colorOfBody, colorOfWing;
    private boolean facingRight;
    private int minX, maxX;

    public Duck(int x, int y, int size, int speed, Color colorOfBeak, Color colorOfNeck, Color colorOfHead, Color colorOfEye, Color colorOfInsideOfEye, Color colorOfBody, Color colorOfWing) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.speed = speed;
        this.colorOfBeak = colorOfBeak;
        this.colorOfNeck = colorOfNeck;
        this.colorOfHead = colorOfHead;
        this.colorOfEye = colorOfEye;
        this.colorOfInsideOfEye = colorOfInsideOfEye;
        this.colorOfBody = colorOfBody;
        this.colorOfWing = colorOfWing;
    }

    public void setColorOfBeak(Color colorOfBeak) {
        this.colorOfBeak = colorOfBeak;
    }

    public void setColorOfNeck(Color colorOfNeck) {
        this.colorOfNeck = colorOfNeck;
    }

    public void setColorOfHead(Color colorOfHead) {
        this.colorOfHead = colorOfHead;
    }

    public void setColorOfEye(Color colorOfEye) {
        this.colorOfEye = colorOfEye;
    }

    public void setColorOfInsideOfEye(Color colorOfInsideOfEye) {
        this.colorOfInsideOfEye = colorOfInsideOfEye;
    }

    public void setColorOfBody(Color colorOfBody) {
        this.colorOfBody = colorOfBody;
    }

    public void setColorOfWing(Color colorOfWing) {
        this.colorOfWing = colorOfWing;
    }

    public void setFacingRight(boolean facingRight) {
        this.facingRight = facingRight;
    }

    public void setDirection(boolean facingRight) {
        this.facingRight = facingRight;
    }

    public void setBounds(int minX, int maxX) {
        this.minX = minX;
        this.maxX = maxX;
    }

    public void update() {
        if (facingRight) {
            x += speed;
            if (x > maxX) {
                facingRight = false;
            }
        } else {
            x -= speed;
            if (x < minX) {
                facingRight = true;
            }
        }
    }
    
    public void draw(Graphics2D g) {
        if (facingRight) {
            drawTowardsRight(g);
        }
        else {
            drawTowardsLeft(g);
        }
    }
    
    private void  drawTowardsLeft(Graphics2D g) {
        
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


    private void drawTowardsRight(Graphics2D g) {
       drawMirror(g);
    }

    private void drawMirror(Graphics2D g) {
        AffineTransform original = g.getTransform();
        g.translate(x + size * 1.5, 0);
        g.scale(-1, 1);
        g.translate(-x - size * 1.5, 0);
        drawTowardsLeft(g);
        g.setTransform(original);
    }
}
