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
        AppleTree appleTree = new AppleTree(150, 300, 20, 70, Color.RED, new Color(69, 152, 60), new Color(114, 94, 72));
        appleTree.draw(g2d);
        Home home = new Home(500, 200, 200, Color.BLACK, Color.YELLOW, Color.RED, Color.WHITE, Color.BLUE, Color.YELLOW, new Color(159, 156, 58), Color.RED, Color.GRAY, Color.GRAY);
        home.draw(g2d);
        Bush bush = new Bush(300, 600, 30, new Color(69, 152, 60));
        bush.draw(g2d);
        Lake lake = new Lake(500, 1000, 200, 90, new Color(73, 144, 75),  Color.GRAY, new Color(31, 170, 230, 70), new Color(51, 174, 55));
        lake.draw(g2d);
        Lamppost lamppost = new Lamppost(700, 500, 200, Color.DARK_GRAY, Color.YELLOW);
        lamppost.draw(g2d);
        Fir fir = new Fir(600, 500, 50, new Color(69, 152, 60), new Color(114, 94, 72));
        fir.draw(g2d);
        List<Star> listOfStars = DrawUtils.getArrayOfStars(0, 0, WidthPanel, HeightPanel / 2, 70, Color.WHITE);
        for(Star star: listOfStars) {
            star.draw(g2d);
        }
        Sun sun = new Sun(400, 100, 50, 90, 15, Color.ORANGE);
        Moon moon = new Moon(100, 50, 1.5, Color.YELLOW);
        Cloud cloud = new Cloud(500, 50, 50, Color.WHITE);
        cloud.draw(g2d);
        sun.draw(g2d);
        moon.draw(g2d, Color.BLACK);
    }

}
