import java.awt.*;
import java.awt.geom.Path2D;

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

    public Home(int x, int y, int size, Color colorOfPipe, Color colorOfRoof, Color colorOfHome, Color colorOfShutters,
                Color colorOfWindows, Color colorOfDoor, Color colorOfInsideOfDoor, Color colorOfDoorHandle,
                Color colorOfWindowSill, Color colorOfRungs) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.colorOfPipe = colorOfPipe;
        this.colorOfRoof = colorOfRoof;
        this.colorOfHome = colorOfHome;
        this.colorOfShutters = colorOfShutters;
        this.colorOfWindows = colorOfWindows;
        this.colorOfDoor = colorOfDoor;
        this.colorOfInsideOfDoor = colorOfInsideOfDoor;
        this.colorOfDoorHandle = colorOfDoorHandle;
        this.colorOfWindowSill = colorOfWindowSill;
        this.colorOfRungs = colorOfRungs;
    }

    public void draw(Graphics2D g) {
        //Труба
        g.setColor(colorOfPipe);
        g.fillRect(x + size /2, y + size / 8, size / 4, size / 2);

        //Крыша
        g.setColor(colorOfRoof);
        Path2D path = new Path2D.Double();
        path.moveTo(x, y);
        path.lineTo(x - (double) (size * 9/8), y + (double) (size * 9/8));
        path.lineTo(x - (double) (size * 5/4), y + size);
        path.lineTo(x, y - size / 4);
        path.lineTo(x + (double) (size * 5/4), y + size);
        path.lineTo(x + (double) (size * 9/8), y + (double) (size * 9/8));
        path.closePath();
        g.fill(path);


        //Дом
        g.setColor(colorOfHome);
        Path2D path2 = new Path2D.Double();
        path2.moveTo(x, y);
        path2.lineTo(x - size, y + size);
        path2.lineTo(x + size, y + size);
        path2.closePath();
        g.fill(path2);
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

        //Ступеньки
        g.setStroke(new BasicStroke(1));
        g.setColor(colorOfHome);
        g.fillRect(x - size, y + 2 * size, 2 * size, size / 8);
        g.setColor(colorOfRungs);
        g.fillRect(x - size * 13/16, y + size * 2, size * 10/16, size / 16);
        g.fillRect(x - size * 14/16, y + size * 33/16, size * 12/ 16, size / 14);
    }
}
