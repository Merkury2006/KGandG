import GeomObjects.Star;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class DrawUtils {

    public static void drawBackground(Graphics2D g, int widthPanel, int heightPanel, int amplitude, int period, Color skyColor, Color groundColor) {
        int centerY = heightPanel / 2;
        g.setColor(Color.BLACK);

        Polygon bottomPoly = new Polygon();
        Polygon topPoly = new Polygon();
        for (int x = 0; x < widthPanel; x++) {
            double radians = 2 * Math.PI * x / period;
            int y = centerY - (int) (amplitude * Math.sin(radians));
            bottomPoly.addPoint(x, y);
            topPoly.addPoint(x, y);
        }

        bottomPoly.addPoint(widthPanel, heightPanel);
        bottomPoly.addPoint(0, heightPanel);

        topPoly.addPoint(widthPanel, 0);
        topPoly.addPoint(0, 0);

        g.setColor(groundColor);
        g.fill(bottomPoly);

        g.setColor(skyColor);
        g.fill(topPoly);
    }
}
