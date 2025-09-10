import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;

public class DrawPanel extends JPanel {

    public DrawPanel() {
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D gD = (Graphics2D) g;
        Sun sun = new Sun(200, 100, 50, 90, 15, Color.ORANGE);
        Moon moon = new Moon(50, 40, 1.5, Color.YELLOW);
        //sun.draw(gD);
        moon.draw(gD, Color.BLACK);
    }

}
