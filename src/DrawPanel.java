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

        DrawUtils.drawBackground(g2d, WidthPanel, HeightPanel, 5, 400, Color.BLACK, Color.GRAY);
        List<Star> listOfStars = DrawUtils.getArrayOfStars(0, 0, WidthPanel, HeightPanel / 2, 70, Color.WHITE);
        for(Star star: listOfStars) {
            star.draw(g2d);
        }
        //Sun sun = new Sun(200, 100, 50, 90, 15, Color.ORANGE);
        Moon moon = new Moon(100, 50, 1.5, Color.YELLOW);
        //sun.draw(g2d);
        moon.draw(g2d, Color.BLACK);
    }


}
