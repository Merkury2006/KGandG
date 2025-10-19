package org.example.KGandG.GeomObjects;

import java.awt.*;
import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.Random;

public class AppleTree {
    public interface ColorProvider {
        Color getColorOfCrown();
        Color getColorOfTrunk();
    }

    private final int n = 5;
    private int x, y, size, chanceOfAppearanceApple;
    private ColorProvider colorProvider;

    private ArrayList<Apple> appleList = new ArrayList<>();
    private Apple.Factory appleFactory;

    private Path2D path = new Path2D.Double();

    public AppleTree(int x, int y, int size, int chanceOfAppearanceApple, ColorProvider colorProvider, Apple.Factory appleFactory) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.chanceOfAppearanceApple = chanceOfAppearanceApple;
        this.colorProvider = colorProvider;
        this.appleFactory = appleFactory;
    }


    public ArrayList<Apple> getAppleList() {
        return appleList;
    }

    public void initializedApples(Random random) {
        for (int i = x - size; i <= x + size; i += size) {
            int curX = i;
            int curY = y + size;
            if (curX == x) {
                curY -= size;
            }

            int index = 0;
            double da = 2 * Math.PI / n;
            for (int j = 0; j < n; j++) {
                double a = da * j;
                int[] arrX = new int[]{(int) (curX + (double) size / 2 * Math.cos(a)), (int) (curX + size * Math.cos(a))};
                int[] arrY = new int[]{(int) (curY + (double) size / 2 * Math.sin(a)), (int) (curY + size * Math.sin(a))};
                for (int k = 0; k < 2; k++) {
                    int curChanceOfAppearanceApple = random.nextInt(100);
                    if (curChanceOfAppearanceApple <= chanceOfAppearanceApple) {
                        appleList.add(appleFactory.create(arrX[k] + random.nextInt(size / 20), arrY[k] + random.nextInt(size / 20), size / 10, index ++));
                    }
                }
            }
        }
    }

    public void draw(Graphics2D g) {
        //Отрисовка ствола дерева
        path.moveTo(x, y);
        path.curveTo(x - (double) size / 4, y + size, x - size, y + size * 2 , x - size * 0.9, y + size * 4);
        path.lineTo(x + size * 0.9, y + size * 4);
        path.moveTo(x, y);
        path.curveTo(x + (double) size / 4, y + size, x + size, y + size * 2 , x + size * 0.9, y + size * 4);
        path.closePath();

        g.setColor(colorProvider.getColorOfTrunk());
        g.fill(path);
        path.reset();

        //Отрисовка кроны деревa
        for (int i = x - size; i <= x + size; i += size) {
            int curX = i;
            int curY = y + size;
            if (curX == x) {
                curY -= size;
            }
            g.setColor(colorProvider.getColorOfCrown());

            double da = 2 * Math.PI / n;
            for (int j = 0; j < n; j++) {
                double a = da * j;
                double x1 = curX + (double) size / 2 * Math.cos(a);
                double y1 = curY + (double) size / 2 * Math.sin(a);
                double x2 = curX + size * Math.cos(a);
                double y2 = curY + size * Math.sin(a);
                g.fillOval((int) ((x1 + x2) / 2) - size, (int) ((y1 + y2) / 2) - size, size + size, size + size);
            }
        }

        //Отрисовка яблок
        appleList.forEach(apple -> apple.draw(g));
    }
}
