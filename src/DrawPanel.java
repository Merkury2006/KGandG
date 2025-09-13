import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;
import java.util.List;
import java.util.Random;

public class DrawPanel extends JPanel {

    public DrawPanel() {
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int widthPanel = getWidth();
        int heightPanel = getHeight();
        DrawUtils.drawBackground(g2d, widthPanel, heightPanel, heightPanel / 200, widthPanel / 3, Color.BLUE, Color.GREEN);
        AppleTree appleTree = new AppleTree(widthPanel / 4, heightPanel / 4, widthPanel / 16, 70, Color.RED, new Color(69, 152, 60), new Color(114, 94, 72));
        appleTree.draw(g2d);
        Home home = new Home(widthPanel / 2, heightPanel / 4, widthPanel / 8, Color.BLACK, Color.YELLOW, Color.RED, Color.WHITE, Color.BLUE, Color.YELLOW, new Color(159, 156, 58), Color.RED, Color.GRAY, Color.GRAY);
        home.draw(g2d);
        Bush bush = new Bush(widthPanel / 2, heightPanel / 2, widthPanel / 128, new Color(69, 152, 60));
        bush.draw(g2d);
        Lake lake = new Lake(500, 1000, 200, 90, new Color(73, 144, 75),  Color.GRAY, new Color(31, 170, 230, 70), new Color(51, 174, 55));
        lake.draw(g2d);
        Duck duck = new Duck(550, 850, 20, Color.ORANGE, new Color(81, 129, 75), new Color(81, 129, 75), Color.WHITE, Color.BLACK, new Color(121, 99, 67), new Color(159, 139, 73));
        duck.drawTowardsRight(g2d);
        Flower flower = new Flower(500, 800, 10, Color.GREEN, Color.RED, Color.YELLOW);
        flower.draw(g2d);
        Lamppost lamppost = new Lamppost(700, 500, 200, Color.DARK_GRAY, Color.YELLOW);
        lamppost.draw(g2d);
        Fir fir = new Fir(600, 500, 50, new Color(69, 152, 60), new Color(114, 94, 72));
        fir.draw(g2d);
//        List<Star> listOfStars = DrawUtils.getArrayOfStars(0, 0, WidthPanel, HeightPanel / 2, 70, Color.WHITE);
//        for(Star star: listOfStars) {
//            star.draw(g2d);
//        }
        Sun sun = new Sun(400, 100, 50, 90, 15, Color.ORANGE);
//        Moon moon = new Moon(100, 50, 1.5, Color.YELLOW);
        Cloud cloud = new Cloud(500, 50, 50, Color.WHITE);
        cloud.draw(g2d);
        sun.draw(g2d);
//        moon.draw(g2d, Color.BLACK);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1200, 1200);
    }
}
