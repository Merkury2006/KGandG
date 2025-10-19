package org.example.KGandG.GeomObjects;

import java.awt.*;
import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.Random;

public class Home {
    public interface ColorProvider{
        Color getColorOfPipe();
        Color getColorOfRoof();
        Color getColorOfHome();
        Color getColorOfShutters();
        Color getColorOfWindows();
        Color getColorOfDoor();
        Color getColorOfInsideOfDoor();
        Color getColorOfDoorHandle();
        Color getColorOfWindowSill();
        Color getColorOfRungs();
    }
    private int x, y, size;
    private ColorProvider colorProvider;

    private ArrayList<Flower> flowersOnWindowsill = new ArrayList<>();
    private ArrayList<Flower> flowersOnGarden = new ArrayList<>();
    private Fence fence;
    private Flower.Factory flowerFactory;

    private Path2D path = new Path2D.Double();

    public Home(int x, int y, int size, ColorProvider colorProvider, Flower.Factory flowerFactory) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.colorProvider = colorProvider;
        this.flowerFactory = flowerFactory;
    }

    public void initFence(Fence.ColorProvider colorProvider) {
        this.fence = new Fence(x - size * 2/16, y + size * 34/16, size * 18/16, size / 6, colorProvider);
    }

    public ArrayList<Flower> getFlowersOnWindowsill() {
        return flowersOnWindowsill;
    }

    public ArrayList<Flower> getFlowersOnGarden() {
        return flowersOnGarden;
    }

    public Fence getFence() {
        return fence;
    }

    public void initFlowersOnWindowsill() {
        for (int curX = x + size/16, i = 0; curX <= x + size * 13/16; curX += size / 5, i ++) {
            flowersOnWindowsill.add(flowerFactory.create(curX, y + size * 54 / 32, size / 20, i));
        }
    }

    public void initFlowersOnGarden(Random random) {
        int curIndex = 0;
        for (int curX = x; curX <= x + size * 15/16; curX += size / 5) {
            for (int curY = y + size * 33/16; curY <= y + size * 36/16; curY += size / 10) {
                flowersOnGarden.add(flowerFactory.create(curX + random.nextInt(size / 20), curY + random.nextInt(size / 20), size / 20, curIndex));
                curIndex ++;
            }
        }
    }

    public void draw(Graphics2D g) {
        //Труба
        g.setColor(colorProvider.getColorOfPipe());
        g.fillRect(x + size /2, y + size / 8, size / 4, size / 2);

        //Крыша
        g.setColor(colorProvider.getColorOfRoof());
        path.moveTo(x, y);
        path.lineTo(x - (double) (size * 9/8), y + (double) (size * 9/8));
        path.lineTo(x - (double) (size * 5/4), y + size);
        path.lineTo(x, y - size / 4);
        path.lineTo(x + (double) (size * 5/4), y + size);
        path.lineTo(x + (double) (size * 9/8), y + (double) (size * 9/8));
        path.closePath();
        g.fill(path);
        path.reset();


        //Дом
        g.setColor(colorProvider.getColorOfHome());
        path.moveTo(x, y);
        path.lineTo(x - size, y + size);
        path.lineTo(x + size, y + size);
        path.closePath();
        g.fill(path);
        path.reset();
        g.fillRect(x - size, y + size, size * 2, size);

        //Доп окно
        g.setColor(colorProvider.getColorOfShutters());
        g.setStroke(new BasicStroke((float) size / 40));
        g.fillRect(x - size * 5/16, y + size * 7/16, size * 10/16, size * 10/16);
        g.setColor(colorProvider.getColorOfWindows());
        g.fillRect(x - size / 4, y + size / 2, size / 2, size / 2);
        g.setColor(colorProvider.getColorOfShutters());
        g.drawLine(x - size / 4, y + size * 3/4, x + size / 4, y + size * 3/4);
        g.drawLine(x, y + size/2, x, y + size);
        g.setStroke(new BasicStroke(1));


        //Дверь
        g.setColor(colorProvider.getColorOfDoor());
        g.fillRect(x - size * 3/4, y + size * 5/4, size / 2, size * 3/4);
        g.setStroke(new BasicStroke((float) size / 20));
        g.setColor(colorProvider.getColorOfInsideOfDoor());
        g.fillRect(x - size * 11/16, y + size * 21/16, size * 3/8, size * 5/8);
        g.setColor(colorProvider.getColorOfDoor());
        g.drawLine(x - size * 21/32, y + size * 13/8, x - size * 11/32, y + size * 13/8);
        g.setColor(colorProvider.getColorOfDoorHandle());
        g.setStroke(new BasicStroke(1));
        g.fillOval(x - size * 24/64, y + size * 51/32, size / 10, size / 10);

        //Основное окно
        g.setStroke(new BasicStroke((float) size / 40));
        g.setColor(colorProvider.getColorOfShutters());
        g.fillRect(x - size / 16, y + size * 19/16, size * 14/16, size * 10/16);
        g.setColor(colorProvider.getColorOfWindows());
        g.fillRect(x, y + size * 5/4, size * 3/4, size / 2);
        g.setColor(colorProvider.getColorOfShutters());
        g.drawLine(x, y + size * 3/2, x + size * 3/4,y + size * 3/2);
        g.drawLine(x + size / 4, y + size * 5/4, x + size / 4, y + size * 7/4);
        g.drawLine(x + size / 2, y + size * 5/4, x + size / 2, y + size * 7/4);

        //Подоконник
        g.setColor(colorProvider.getColorOfWindowSill());
        g.fillRect(x - size / 16, y + size * 7/4, size * 14/16, size / 16);
        flowersOnWindowsill.forEach(flower -> flower.draw(g));

        //Ступеньки
        g.setStroke(new BasicStroke(1));
        g.setColor(colorProvider.getColorOfHome());
        g.fillRect(x - size, y + 2 * size, 2 * size, size / 8);
        g.setColor(colorProvider.getColorOfRungs());
        g.fillRect(x - size * 13/16, y + size * 2, size * 10/16, size / 16);
        g.fillRect(x - size * 14/16, y + size * 33/16, size * 12/ 16, size / 14);


        //Цветочная площадка
        g.setColor(new Color(105, 80, 52));
        g.fillRect(x - size * 2/16, y + size * 34/16, size * 18/16, size / 6);
        flowersOnGarden.forEach(flower -> flower.draw(g));
        fence.draw(g);
    }
}
