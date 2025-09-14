package GeomObjects;

import java.awt.*;
import java.awt.geom.Path2D;

public class Fir {
    private int x, y, size;
    private Color colorTree, colorTrunk;

    public Fir(int x, int y, int size, Color colorTree, Color colorTrunk) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.colorTree = colorTree;
        this.colorTrunk = colorTrunk;
    }

    public void draw(Graphics2D g, Path2D path) {
        path.moveTo(x, y);
        path.lineTo(x - size, y + size);
        path.lineTo(x + size, y + size);

        path.moveTo(x, y + size * 0.7);
        path.lineTo(x - size * 1.5, y + size * 2);
        path.lineTo(x + size * 1.5, y + size * 2);

        path.moveTo(x, y + size * 1.7);
        path.lineTo(x - size * 2, y + size * 3);
        path.lineTo(x + size * 2, y + size * 3);

        path.closePath();

        g.setColor(colorTree);
        g.fill(path);
        path.reset();
        g.setColor(colorTrunk);
        g.fillRect((int) (x - size * 0.3), y + size * 3, (int) (size * 0.6), (int) (size * 0.4));
    }

}
