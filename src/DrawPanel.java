import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;
import java.util.List;
import java.util.Random;

public class DrawPanel extends JPanel {
        private final int WidthPanel, HeightPanel;

    public DrawPanel(int widthPanel, int heightPanel) {
        this.WidthPanel = widthPanel;
        this.HeightPanel = heightPanel;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        DrawUtils.drawBackground(g2d, WidthPanel, HeightPanel, 5, 400, Color.BLUE, Color.GREEN);
        AppleTree appleTree = new AppleTree(150, 250, 80, 70, Color.RED, new Color(69, 152, 60), new Color(114, 94, 72));
        appleTree.draw(g2d);
        drawHome(g2d, 500, 200, 200);
        drawBush(g2d, 300, 600, 30);

//        Lamppost lamppost = new Lamppost(100, 30, 200, Color.DARK_GRAY, Color.YELLOW);
//        lamppost.draw(g2d);
//        Fir fir = new Fir(300, 500, 50, new Color(69, 152, 60), new Color(114, 94, 72));
//        fir.draw(g2d);
//        List<Star> listOfStars = DrawUtils.getArrayOfStars(0, 0, WidthPanel, HeightPanel / 2, 70, Color.WHITE);
//        for(Star star: listOfStars) {
//            star.draw(g2d);
//        }
//Sun sun = new Sun(200, 100, 50, 90, 15, Color.ORANGE);
//        Moon moon = new Moon(100, 50, 1.5, Color.YELLOW);
//sun.draw(g2d);
//        moon.draw(g2d, Color.BLACK);
    }

    public static void drawHome(Graphics2D g, int x, int y, int size) {
        //Труба
        g.setColor(Color.BLACK);
        g.fillRect(x + size /2, y + size / 8, size / 4, size / 2);

        //Крыша
        Path2D path = new Path2D.Double();
        path.moveTo(x, y);
        path.lineTo(x - (double) (size * 9/8), y + (double) (size * 9/8));
        path.lineTo(x - (double) (size * 5/4), y + size);
        path.lineTo(x, y - size / 4);
        path.lineTo(x + (double) (size * 5/4), y + size);
        path.lineTo(x + (double) (size * 9/8), y + (double) (size * 9/8));
        path.closePath();
        g.setColor(Color.YELLOW);
        g.fill(path);

        Path2D path2 = new Path2D.Double();
        path2.moveTo(x, y);
        path2.lineTo(x - size, y + size);
        path2.lineTo(x + size, y + size);
        path2.closePath();
        g.setColor(Color.RED);
        g.fill(path2);

        //Дом
        g.fillRect(x - size, y + size, size * 2, size);

        //Доп окно
        g.setStroke(new BasicStroke(5));
        g.setColor(Color.WHITE);
        g.fillRect(x - size * 5/16, y + size * 7/16, size * 10/16, size * 10/16);
        g.setColor(Color.BLUE);
        g.fillRect(x - size / 4, y + size / 2, size / 2, size / 2);
        g.setColor(Color.WHITE);
        g.drawLine(x - size / 4, y + size * 3/4, x + size / 4, y + size * 3/4);
        g.drawLine(x, y + size/2, x, y + size);
        g.setStroke(new BasicStroke(1));
        g.setColor(Color.BLACK);


        //Дверь
        g.setColor(Color.YELLOW);
        g.fillRect(x - size * 3/4, y + size * 5/4, size / 2, size * 3/4);
        g.setColor(Color.BLACK);
        g.setStroke(new BasicStroke(10));
        g.setColor(new Color(210, 210, 35));
        g.fillRect(x - size * 11/16, y + size * 21/16, size * 3/8, size * 5/8);
        g.setColor(Color.YELLOW);
        g.drawLine(x - size * 21/32, y + size * 13/8, x - size * 11/32, y + size * 13/8);
        g.setColor(Color.RED);
        g.setStroke(new BasicStroke(1));
        g.fillOval(x - size * 24/64, y + size * 51/32, size / 10, size / 10);

        //Основное окно
        g.setStroke(new BasicStroke(5));
        g.setColor(Color.WHITE);
        g.fillRect(x - size / 16, y + size * 19/16, size * 14/16, size * 10/16);
        g.setColor(Color.BLUE);
        g.fillRect(x, y + size * 5/4, size * 3/4, size / 2);
        g.setColor(Color.WHITE);
        g.drawLine(x, y + size * 3/2, x + size * 3/4,y + size * 3/2);
        g.drawLine(x + size / 4, y + size * 5/4, x + size / 4, y + size * 7/4);
        g.drawLine(x + size / 2, y + size * 5/4, x + size / 2, y + size * 7/4);
        g.setColor(Color.GRAY);
        g.fillRect(x - size / 16, y + size * 7/4, size * 14/16, size / 16); //Подоконник

        g.setStroke(new BasicStroke(1));
        g.setColor(Color.RED);
        g.fillRect(x - size, y + 2 * size, 2 * size, size / 8);
        g.setColor(Color.BLACK);
        g.fillRect(x - size * 13/16, y + size * 2, size * 10/16, size / 16);
        g.fillRect(x - size * 14/16, y + size * 33/16, size * 12/ 16, size / 14);
    }

    public static void drawBush(Graphics2D g, int x, int y, int size) {
        int n = 5;
        g.setColor(new Color(69, 152, 60));
        for (int i = x - size; i <= x + size; i += size) {
            int curX = i;
            int curY = y + size;
            if (curX == x) {
                curY -= size;
            }

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
    }


}
