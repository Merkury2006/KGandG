package GeomObjects;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Lake {
    private int x, y, size, chanceOfAppearanceStone,  chanceOfAppearanceDuck;
    private Color colorOfLake, colorOfStone, colorOfGlare, colorOfWaterLily;
    private final int n = 10;
    private ArrayList<Duck> duckList = new ArrayList<>();
    private boolean ducksInitialized = false;

    public Lake(int x, int y, int size, int chanceOfAppearanceStone, int chanceOfAppearanceDuck, Color colorOfLake, Color colorOfStone, Color colorOfGlare, Color colorOfWaterLily) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.chanceOfAppearanceStone = chanceOfAppearanceStone;
        this.chanceOfAppearanceDuck = chanceOfAppearanceDuck;
        this.colorOfLake = colorOfLake;
        this.colorOfStone = colorOfStone;
        this.colorOfGlare = colorOfGlare;
        this.colorOfWaterLily = colorOfWaterLily;
    }

    public int getSize() {
        return size;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    public void draw(Graphics2D g, Random random) {

        g.setColor(colorOfLake);
        g.fillOval(x - size, y - size, size * 3, size);
        g.setColor(colorOfGlare);
        g.fillOval((int) (x  + size * 0.2), (int) (y - size * 0.6), size / 3 * 4, size / 4);
        g.setColor(colorOfWaterLily);
        g.fillOval((int) (x - size * 0.6), (int) (y - size * 0.8), size / 3 , size / 16);
        g.fillOval((int) (x + size * 0.7), (int) (y - size * 0.8), size / 3 , size / 16);
        g.fillOval((int) (x - size * 0.7), (int) (y - size * 0.4), size / 3 , size / 16);
        g.fillOval((int) (x + size * 0.7), (int) (y - size * 0.4), size / 3 * 2 , size / 8);

        int centerX = x - size + size * 3 / 2;
        int centerY = y - size + size / 2;
        double da = 2 * Math.PI / n;
        int offset = size / 2;
        for (int i = 0; i < n; i++) {
            int curChanceOfAppearanceStone = random.nextInt(100);
            if (curChanceOfAppearanceStone <= chanceOfAppearanceStone) {
                double a = da * i;
                int pointX = centerX + (int) ((double) (size * 3 / 2 + size / 4 / 2) * Math.cos(a));
                if (Math.cos(a) > 0) {
                    pointX += (offset + random.nextInt(10));
                } else if (Math.cos(a) < 0) {
                    pointX -= (offset + random.nextInt(10));
                }

                int pointY = centerY + (int) ((double) (size / 2 + size / 4 / 2) * Math.sin(a));
                g.setColor(colorOfStone);

                g.fillOval(pointX - size / 4 / 2, pointY - size / 4 / 2, size / 4 * 2, size / 4);
            }
        }

        for (Duck duck : duckList) {
            duck.draw(g);
        }
    }

    public void initializedDucks(Random random) {
        if (!ducksInitialized) {
            for (int curX = (int) (x - size * 0.5); curX <= x + size; curX += size / 2) {
                for (int curY = (int) (y - size); curY <= y - size * 0.5; curY += size / 4) {
                    int curChanceOfAppearanceDuck = random.nextInt(100);
                    if (curChanceOfAppearanceDuck <= chanceOfAppearanceDuck) {
                        Duck duck = new Duck(curX + random.nextInt(10), curY + random.nextInt(10), 20, 1, Color.ORANGE, Color.ORANGE, Color.RED, Color.BLACK, Color.ORANGE, Color.BLACK, Color.ORANGE);
                        if (random.nextInt(100) <= 50) {
                            duck.setDirection(true);
                        }
                        else {
                            duck.setDirection(false);
                        }
                        duckList.add(duck);
                    }
                }
            }
        }
        ducksInitialized = true;
    }

    public ArrayList<Duck> getDuckList() {
        return duckList;
    }

    public void updateDucks() {
        for (Duck duck : duckList) {
            duck.update();
        }
    }
}
