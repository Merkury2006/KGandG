import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private final int WidthWindow, HeightWindow;
    private final DrawPanel dp;

    public MainWindow(int widthWindow, int heightWindow) throws HeadlessException {
        this.WidthWindow = widthWindow;
        this.HeightWindow = heightWindow;
        this.dp = new DrawPanel(WidthWindow, HeightWindow);
        this.setSize(WidthWindow, HeightWindow);
        this.add(dp);
    }
}
