import GeomObjects.*;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.Random;

public class DrawPanel extends JPanel {
    private static final int INITIAL_WIDTH = 1200;
    private static final int INITIAL_HEIGHT = 1200;
    private Random random = new Random();
    private Path2D path = new Path2D.Double();
    Graphics2D g2d;

    ArrayList<Cloud>  cloudList;
    Sun sun;
    ArrayList<Fir> firList;
    AppleTree appleTree;
    Home home;
    Lamppost lamppost;
    ArrayList<Bush> bushList;
    Lake lake;

    public DrawPanel() {
        SceneBuilder sceneBuilder = new SceneBuilder(INITIAL_WIDTH, INITIAL_HEIGHT, random);
        this.sun = sceneBuilder.buildSun();
        this.cloudList = sceneBuilder.buildCloudList();
        this.firList = sceneBuilder.buildFirList();
        this.appleTree = sceneBuilder.buildAppleTree();
        this.home = sceneBuilder.buildHome();
        this.lamppost = sceneBuilder.buildLamppost();
        this.bushList = sceneBuilder.buildBushes();
        this.lake = sceneBuilder.buildLake();

        new Timer(16, e -> {
            this.updateClouds();
            lake.updateDucks();
            this.repaint();
        }).start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g2d = (Graphics2D) g;

        int currentWidth = getWidth();
        int currentHeight = getHeight();

        double scaleX = (double) currentWidth / INITIAL_WIDTH;
        double scaleY = (double) currentHeight / INITIAL_HEIGHT;

        int offsetX = 0;
        int offsetY = 0;

        g2d.translate(offsetX, offsetY);
        g2d.scale(scaleX, scaleY);

        DrawUtils.drawBackground(g2d, INITIAL_WIDTH, INITIAL_HEIGHT, INITIAL_HEIGHT / 200,
                INITIAL_WIDTH / 3, new Color(41, 194, 214), new Color(61, 184, 50));

        sun.draw(g2d);

        cloudList.stream().forEach(cloud -> cloud.draw(g2d));

        firList.stream().forEach(fir -> fir.draw(g2d, path));

        appleTree.draw(g2d, random, path);

        home.draw(g2d, random, path);

        lamppost.draw(g2d);

        bushList.forEach(bush -> bush.draw(g2d));

        lake.draw(g2d, random);
    }

    private void updateClouds() {
        for (Cloud cloud : cloudList) {
            cloud.update(INITIAL_WIDTH);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(INITIAL_WIDTH, INITIAL_HEIGHT);
    }
}