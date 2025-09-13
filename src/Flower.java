import java.awt.*;

public class Flower {
    private final int n = 5;
    private int x, y, size;
    private Color colorOfStem, colorOfPetals, colorOfCenterFlower;

    public Flower(int x, int y, int size, Color colorOfStem, Color colorOfPetals, Color colorOfCenterFlower) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.colorOfStem = colorOfStem;
        this.colorOfPetals = colorOfPetals;
        this.colorOfCenterFlower = colorOfCenterFlower;
    }



    public void draw(Graphics2D g) {
        int n = 5;

        //Стебель
        g.setColor(colorOfStem);
        g.setStroke(new BasicStroke(5));
        g.drawLine((int) (x - (double) size / 2), (int) (y - (double) size / 2), (int) (x - (double) size / 2), y + size);


        //Лепестки
        g.setColor(colorOfPetals);
        g.setStroke(new BasicStroke(1));
        double da = 2 * Math.PI / n;
        for (int j = 0; j < n; j++) {
            double a = da * j;
            double x1 = x + (double) size / 2 * Math.cos(a);
            double y1 = y + (double) size / 2 * Math.sin(a);
            g.fillOval((int) (x1 - size), (int) (y1 - size), size, size);
        }

        //Центр цветка
        g.setColor(colorOfCenterFlower);
        g.fillOval(x - size, y - size, size, size);

    }
}
