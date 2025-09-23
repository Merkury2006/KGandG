import GeomObjects.*;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.Random;

public class DrawPanel extends JPanel {
    private static final int INITIAL_WIDTH = 600;
    private static final int INITIAL_HEIGHT = 600;
    private final long seed;
    private Random random;
    private Path2D path = new Path2D.Double();

    ArrayList<Cloud>  cloudList = new ArrayList<>();
    Sun sun;
    ArrayList<Fir> firList = new ArrayList<>();
    AppleTree appleTree;
    Home home;
    Lamppost lamppost;
    Bush bush1;
    Bush bush2;
    Lake lake;

    public DrawPanel(long seed) {
        this.seed = seed;
        this.random = new Random(seed);



        sun = new Sun(INITIAL_WIDTH / 12, INITIAL_HEIGHT / 12, INITIAL_WIDTH / 24, INITIAL_WIDTH / 17, new Color(221, 240, 14));

        for (int curX = INITIAL_WIDTH / 4; curX <= INITIAL_WIDTH / 1.2; curX += INITIAL_WIDTH / 4) {
            cloudList.add(new Cloud(curX, INITIAL_HEIGHT / 24 + random.nextInt(INITIAL_HEIGHT / 6), INITIAL_WIDTH / 24 + random.nextInt(INITIAL_WIDTH / 24), 1,
                    new Color(213, 224, 227)));
        }

        for (int curX = 0; curX <= INITIAL_WIDTH; curX += INITIAL_WIDTH / 8) {
            firList.add(new Fir(curX, (int) (INITIAL_HEIGHT / 2.4 - random.nextInt(INITIAL_HEIGHT / 17)), INITIAL_WIDTH / 24 + random.nextInt(INITIAL_WIDTH / 60), new Color(52, 130, 33), new Color(74, 77, 43)));
        }

        appleTree = new AppleTree(INITIAL_WIDTH / 4, (int) (INITIAL_HEIGHT / 3.4), INITIAL_WIDTH / 12, 70,
                new Color(222, 29, 51), new Color(38, 148, 57), new Color(74, 65, 44));

        home = new Home((int) (INITIAL_WIDTH / 1.5), INITIAL_HEIGHT / 4 ,INITIAL_WIDTH / 6, new Color(78, 84, 80),
                new Color(226, 229, 25), new Color(227, 71, 36), new Color(232, 232, 232),
                new Color(27, 106, 196), new Color(226, 229, 25), new Color(159, 156, 58),
                new Color(227, 71, 36), new Color(160, 161, 163), new Color(49, 50, 51));

        home.initFlowersOnWindowsill();
        home.initFlowersOnGarden(random);

        home.getFlowersOnGarden().forEach(flower -> {
            flower.setColorOfCenterFlower(Color.YELLOW);
            flower.setColorOfPetals(Color.RED);
            flower.setColorOfStem(Color.GREEN);
        });

        home.getFlowersOnWindowsill().forEach(flower -> {
            flower.setColorOfCenterFlower(Color.YELLOW);
            flower.setColorOfPetals(Color.BLUE);
            flower.setColorOfStem(Color.GREEN);
        });

        home.getFence().setColor(new Color(38, 38, 34));

        lamppost = new Lamppost((int) (INITIAL_WIDTH / 1.142857), (int) (INITIAL_HEIGHT / 2.4), INITIAL_WIDTH / 4, new Color(76, 77, 76), new Color(161, 173, 29));

        bush1 = new Bush((int) (INITIAL_WIDTH / 2.18), (int) (INITIAL_HEIGHT / 1.714), INITIAL_WIDTH / 32, new Color(50, 127, 63));
        bush2 = new Bush(INITIAL_WIDTH / 12, (int) (INITIAL_HEIGHT / 1.714), INITIAL_WIDTH / 25, new Color(50, 127, 63));

        lake = new Lake(INITIAL_WIDTH / 3, (int) (INITIAL_HEIGHT / 1.090909), INITIAL_WIDTH / 6, 90, 30,
                new Color(48, 84, 42), new Color(82, 81, 78), new Color(47, 96, 102),
                new Color(27, 117, 47));

        lake.initializedDucks(random);

        lake.getDuckList().forEach(duck -> {
            duck.setBounds((int) (lake.getX() - lake.getSize() * 0.7), (int) (lake.getX() + lake.getSize() * 1.5));
            duck.setColorOfBody(Color.RED);
            duck.setColorOfBeak(Color.ORANGE);
            duck.setColorOfEye(Color.WHITE);
            duck.setColorOfHead(Color.RED);
            duck.setColorOfInsideOfEye(Color.BLACK);
            duck.setColorOfNeck(Color.ORANGE);
            duck.setColorOfWing(Color.ORANGE);
        });



        new Timer(16, e -> {
            this.updateClouds();
            lake.updateDucks();
            this.repaint();
        }).start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        random.setSeed(seed);
        int currentWidth = getWidth();
        int currentHeight = getHeight();

        double scaleX = (double) currentWidth / INITIAL_WIDTH;
        double scaleY = (double) currentHeight / INITIAL_HEIGHT;
        double scale = Math.max(scaleX, scaleY);

        int scaledWidth = (int)(INITIAL_WIDTH * scale);
        int scaledHeight = (int)(INITIAL_HEIGHT * scale);
        int offsetX = (currentWidth - scaledWidth) / 2;
        int offsetY = (currentHeight - scaledHeight) / 2;

        g2d.translate(offsetX, offsetY);
        g2d.scale(scale, scale);

        DrawUtils.drawBackground(g2d, INITIAL_WIDTH, INITIAL_HEIGHT, INITIAL_HEIGHT / 200,
                INITIAL_WIDTH / 3, new Color(41, 194, 214), new Color(61, 184, 50));

        sun.draw(g2d);

        cloudList.stream().forEach(cloud -> cloud.draw(g2d));

        firList.stream().forEach(fir -> fir.draw(g2d, path));

        appleTree.draw(g2d, random, path);

        home.draw(g2d, random, path);

        lamppost.draw(g2d);

        bush1.draw(g2d);

        bush2.draw(g2d);

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