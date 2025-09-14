import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private final DrawPanel dp;

    public MainWindow() throws HeadlessException {
        long seed = System.currentTimeMillis();
        this.dp = new DrawPanel(seed);
        this.add(dp);
        this.pack();
    }
}
