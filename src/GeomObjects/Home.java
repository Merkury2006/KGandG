package GeomObjects;

import java.awt.*;
import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.Random;

public class Home {
    private int x, y, size;
    private Color colorOfPipe;
    private Color colorOfRoof;
    private Color colorOfHome;
    private Color colorOfShutters;
    private Color colorOfWindows;
    private Color colorOfDoor;
    private Color colorOfInsideOfDoor;
    private Color colorOfDoorHandle;
    private Color colorOfWindowSill;
    private Color colorOfRungs;

    private ArrayList<Flower> flowersOnWindowsill = new ArrayList<>();
    private ArrayList<Flower> flowersOnGarden = new ArrayList<>();
    private Fence fence;

    public Home(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
        fence = new Fence(x - size * 2/16, y + size * 34/16, size * 18/16, size / 6);
    }



    public void setColorOfPipe(Color colorOfPipe) {
        this.colorOfPipe = colorOfPipe;
    }

    public void setColorOfRoof(Color colorOfRoof) {
        this.colorOfRoof = colorOfRoof;
    }

    public void setColorOfHome(Color colorOfHome) {
        this.colorOfHome = colorOfHome;
    }

    public void setColorOfShutters(Color colorOfShutters) {
        this.colorOfShutters = colorOfShutters;
    }

    public void setColorOfWindows(Color colorOfWindows) {
        this.colorOfWindows = colorOfWindows;
    }

    public void setColorOfDoor(Color colorOfDoor) {
        this.colorOfDoor = colorOfDoor;
    }

    public void setColorOfInsideOfDoor(Color colorOfInsideOfDoor) {
        this.colorOfInsideOfDoor = colorOfInsideOfDoor;
    }

    public void setColorOfDoorHandle(Color colorOfDoorHandle) {
        this.colorOfDoorHandle = colorOfDoorHandle;
    }

    public void setColorOfWindowSill(Color colorOfWindowSill) {
        this.colorOfWindowSill = colorOfWindowSill;
    }

    public void setColorOfRungs(Color colorOfRungs) {
        this.colorOfRungs = colorOfRungs;
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

    public void draw(Graphics2D g, Random random, Path2D path) {


        //Труба
        g.setColor(colorOfPipe);
        g.fillRect(x + size /2, y + size / 8, size / 4, size / 2);

        //Крыша
        g.setColor(colorOfRoof);
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
        g.setColor(colorOfHome);
        path.moveTo(x, y);
        path.lineTo(x - size, y + size);
        path.lineTo(x + size, y + size);
        path.closePath();
        g.fill(path);
        path.reset();
        g.fillRect(x - size, y + size, size * 2, size);

        //Доп окно
        g.setColor(colorOfShutters);
        g.setStroke(new BasicStroke((float) size / 40));
        g.fillRect(x - size * 5/16, y + size * 7/16, size * 10/16, size * 10/16);
        g.setColor(colorOfWindows);
        g.fillRect(x - size / 4, y + size / 2, size / 2, size / 2);
        g.setColor(colorOfShutters);
        g.drawLine(x - size / 4, y + size * 3/4, x + size / 4, y + size * 3/4);
        g.drawLine(x, y + size/2, x, y + size);
        g.setStroke(new BasicStroke(1));


        //Дверь
        g.setColor(colorOfDoor);
        g.fillRect(x - size * 3/4, y + size * 5/4, size / 2, size * 3/4);
        g.setStroke(new BasicStroke((float) size / 20));
        g.setColor(colorOfInsideOfDoor);
        g.fillRect(x - size * 11/16, y + size * 21/16, size * 3/8, size * 5/8);
        g.setColor(colorOfDoor);
        g.drawLine(x - size * 21/32, y + size * 13/8, x - size * 11/32, y + size * 13/8);
        g.setColor(colorOfDoorHandle);
        g.setStroke(new BasicStroke(1));
        g.fillOval(x - size * 24/64, y + size * 51/32, size / 10, size / 10);

        //Основное окно
        g.setStroke(new BasicStroke((float) size / 40));
        g.setColor(colorOfShutters);
        g.fillRect(x - size / 16, y + size * 19/16, size * 14/16, size * 10/16);
        g.setColor(colorOfWindows);
        g.fillRect(x, y + size * 5/4, size * 3/4, size / 2);
        g.setColor(colorOfShutters);
        g.drawLine(x, y + size * 3/2, x + size * 3/4,y + size * 3/2);
        g.drawLine(x + size / 4, y + size * 5/4, x + size / 4, y + size * 7/4);
        g.drawLine(x + size / 2, y + size * 5/4, x + size / 2, y + size * 7/4);

        //Подоконник
        g.setColor(colorOfWindowSill);
        g.fillRect(x - size / 16, y + size * 7/4, size * 14/16, size / 16);
        flowersOnWindowsill.forEach(flower -> flower.draw(g));

        //Ступеньки
        g.setStroke(new BasicStroke(1));
        g.setColor(colorOfHome);
        g.fillRect(x - size, y + 2 * size, 2 * size, size / 8);
        g.setColor(colorOfRungs);
        g.fillRect(x - size * 13/16, y + size * 2, size * 10/16, size / 16);
        g.fillRect(x - size * 14/16, y + size * 33/16, size * 12/ 16, size / 14);


        //Цветочная площадка
        g.setColor(new Color(105, 80, 52));
        g.fillRect(x - size * 2/16, y + size * 34/16, size * 18/16, size / 6);
        flowersOnGarden.forEach(flower -> flower.draw(g));
        fence.draw(g);
    }

    public void initFlowersOnWindowsill() {
        for (int curX = x + size/16; curX <= x + size * 13/16; curX += size / 5) {
            flowersOnWindowsill.add(new Flower(curX, y + size * 54 / 32, size / 20));
        }
    }

    public void initFlowersOnGarden(Random random) {
        for (int curX = x; curX <= x + size * 15/16; curX += size / 5) {
            for (int curY = y + size * 33/16; curY <= y + size * 36/16; curY += size / 10) {
                flowersOnGarden.add(new Flower(curX + random.nextInt(size / 20), curY + random.nextInt(size / 20), size / 20));
            }
        }
    }
}
