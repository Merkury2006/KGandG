package org.example.KGandG.GeomObjects;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;


public class Lake {
    public interface ColorProvider {
        Color getColorOfLake();
        Color getColorOfGlare();
        Color getColorOfWaterLily();
    }

    private int x, y, size, chanceOfAppearanceStone,  chanceOfAppearanceDuck;
    private ColorProvider colorProvider;

    private final int n = 10;
    private ArrayList<Duck> duckList = new ArrayList<>();
    private ArrayList<Stone> stoneList = new ArrayList<>();
    private Stone.Factory stoneFactory;
    private Duck.Factory duckFactory;

    public Lake(int x, int y, int size, int chanceOfAppearanceStone, int chanceOfAppearanceDuck, ColorProvider colorProvider, Stone.Factory stoneFactory, Duck.Factory duckFactory) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.chanceOfAppearanceStone = chanceOfAppearanceStone;
        this.chanceOfAppearanceDuck = chanceOfAppearanceDuck;
        this.colorProvider = colorProvider;
        this.stoneFactory = stoneFactory;
        this.duckFactory = duckFactory;
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

    public ArrayList<Stone> getStoneList() {
        return stoneList;
    }

    public ArrayList<Duck> getDuckList() {
        return duckList;
    }

    public void initializedStones(Random random){
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
                stoneList.add(stoneFactory.create(pointX - size / 4 / 2, pointY - size / 4 / 2, size / 4 * 2, size / 4, i));
            }
        }
    }

    public void initializedDucks(Random random) {
        int duckIndex = 0;
        for (int curX = (int) (x - size * 0.5); curX <= x + size; curX += size / 2) {
            for (int curY = (int) (y - size * 0.5); curY >= (y - size); curY -= size / 4) {
                int curChanceOfAppearanceDuck = random.nextInt(100);
                if (curChanceOfAppearanceDuck <= chanceOfAppearanceDuck) {
                    Duck duck = duckFactory.create(curX + random.nextInt(size / 10), curY + random.nextInt(size / 10), (int) (size / 6.5), 1, duckIndex);
                    if (random.nextInt(100) <= 50) {
                        duck.setDirection(true);
                    }
                    else {
                        duck.setDirection(false);
                    }
                    duckList.add(duck);
                    duckIndex ++;
                }
            }
        }
    }

    public void sortedDuckList(){
        duckList.sort(Comparator.comparingInt(Duck::getY));
    }


    public void updateDucks() {
        for (Duck duck : duckList) {
            duck.update();
        }
    }

    public void draw(Graphics2D g) {
        g.setColor(colorProvider.getColorOfLake());
        g.fillOval(x - size, y - size, size * 3, size);
        g.setColor(colorProvider.getColorOfGlare());
        g.fillOval((int) (x  + size * 0.2), (int) (y - size * 0.6), size / 3 * 4, size / 4);
        g.setColor(colorProvider.getColorOfWaterLily());
        g.fillOval((int) (x - size * 0.6), (int) (y - size * 0.8), size / 3 , size / 16);
        g.fillOval((int) (x + size * 0.7), (int) (y - size * 0.8), size / 3 , size / 16);
        g.fillOval((int) (x - size * 0.7), (int) (y - size * 0.4), size / 3 , size / 16);
        g.fillOval((int) (x + size * 0.7), (int) (y - size * 0.4), size / 3 * 2 , size / 8);

        stoneList.forEach(stone -> stone.draw(g));

        duckList.forEach(duck -> duck.draw(g));
    }
}
