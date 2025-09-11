import java.awt.*;
import java.awt.geom.Path2D;
import java.util.Random;

public class AppleTree {
    private final int n = 5;
    private int x, y, size, chanceOfAppearanceApple;
    Color colorApple, colorCrown, colorTrunk;

    public AppleTree(int x, int y, int size, int chanceOfAppearanceApple, Color colorApple, Color colorCrown, Color colorTrunk) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.chanceOfAppearanceApple = chanceOfAppearanceApple;
        this.colorApple = colorApple;
        this.colorCrown = colorCrown;
        this.colorTrunk = colorTrunk;
    }

    public void draw(Graphics2D g) {
        Random random = new Random();

        //Отрисовка ствола дерева
        Path2D path = new Path2D.Double();
        path.moveTo(x, y);
        path.curveTo(x - (double) size / 4, y + size, x - size, y + size * 2 , x - size * 0.9, y + size * 4);
        path.lineTo(x + size * 0.9, y + size * 4);
        path.moveTo(x, y);
        path.curveTo(x + (double) size / 4, y + size, x + size, y + size * 2 , x + size * 0.9, y + size * 4);
        path.closePath();

        g.setColor(colorTrunk);
        g.fill(path);

        //Отрисовка кроны дерева и яблок
        for (int t = 0; t < 2; t ++) {
            for (int i = x - size; i <= x + size; i += size) {
                int curX = i;
                int curY = y + size;
                if (curX == x) {
                    curY -= size;
                }

                if (t == 0) {
                    g.setColor(colorCrown);
                }
                else {
                    g.setColor(colorApple);
                }

                double da = 2 * Math.PI / n;
                for (int j = 0; j < n; j++) {
                    double a = da * j;
                    double x1 = curX + (double) size / 2 * Math.cos(a);
                    double y1 = curY + (double) size / 2 * Math.sin(a);
                    double x2 = curX + size * Math.cos(a);
                    double y2 = curY + size * Math.sin(a);
                    if (t == 0) {
                        g.fillOval((int) ((x1 + x2) / 2) - size, (int) ((y1 + y2) / 2) - size, size + size, size + size);
                    }
                    else {
                        int[] arrX = new int[]{(int) x1, (int) x2};
                        int[] arrY = new int[]{(int) y1, (int) y2};
                        for (int k = 0; k < 2; k++) {
                            int curChanceOfAppearanceApple = random.nextInt(100);
                            if (curChanceOfAppearanceApple <= chanceOfAppearanceApple) {
                                int curCoordOfX = arrX[k] + random.nextInt(size / 20);
                                int curCoordOfY = arrY[k] + random.nextInt(size / 20);
                                g.fillOval(curCoordOfX, curCoordOfY, size / 10, size / 10);
                            }
                        }
                    }
                }
            }
        }
    }
}
