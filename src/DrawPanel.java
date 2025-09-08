import javax.swing.*;
import java.awt.*;

public class DrawPanel extends JPanel {

    public DrawPanel() {
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D gD = (Graphics2D) g;
        g.drawRect(0, 0, 1000, 1000);
    }
}
