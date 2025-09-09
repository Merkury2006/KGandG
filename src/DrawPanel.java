import javax.swing.*;
import java.awt.*;

public class DrawPanel extends JPanel {

    public DrawPanel() {
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D gD = (Graphics2D) g;
        Sun sun = new Sun(200, 100, 50, 90, 15, Color.ORANGE);
        sun.draw(gD);
    }

}
