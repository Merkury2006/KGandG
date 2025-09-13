import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private final DrawPanel dp;

    public MainWindow(int widthWindow, int heightWindow) throws HeadlessException {
        this.setSize(widthWindow, heightWindow);
        this.dp = new DrawPanel();
        this.add(dp);
        this.pack();
    }
}
