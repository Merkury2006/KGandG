package org.example.KGandG;


import org.example.KGandG.GeomObjects.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

public class DrawPanel extends JPanel {
    private static final int INITIAL_WIDTH = 800;
    private static final int INITIAL_HEIGHT = 800;

    private Random random = new Random();
    private Graphics2D g2d;
    private SceneBuilder sceneBuilder;
    private TimeManager timeManager;

    private java.util.List<Cloud> cloudList;
    private ArrayList<Star> starList;
    private Sun sun;
    private Moon moon;
    private ArrayList<Fir> firList;
    private AppleTree appleTree;
    private Home home;
    private Lamppost lamppost;
    private ArrayList<Bush> bushList;
    private Lake lake;
    private Background background;

    public DrawPanel() {
        this.timeManager = new TimeManager(random);
        this.sceneBuilder = new SceneBuilder(INITIAL_WIDTH, INITIAL_HEIGHT, random, timeManager);

        this.sun = sceneBuilder.buildSun();
        this.moon = sceneBuilder.buildMoon();
        this.cloudList = sceneBuilder.buildCloudList();
        this.starList = sceneBuilder.buildStarList(70);
        this.firList = sceneBuilder.buildFirList();
        this.appleTree = sceneBuilder.buildAppleTree();
        this.home = sceneBuilder.buildHome();
        this.lamppost = sceneBuilder.buildLamppost();
        this.bushList = sceneBuilder.buildBushes();
        this.lake = sceneBuilder.buildLake();
        this.background = sceneBuilder.buildBackground();

        new Timer(16, e -> {
            this.cloudList.forEach(cloud -> cloud.update(INITIAL_WIDTH));
            this.starList.forEach(Star::update);
            lake.updateDucks();
            this.repaint();
        }).start();

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                timeManager.toggleTime();
                lake.getDuckList().forEach(duck -> duck.setSpeed(timeManager.isDay()));
                repaint();
            }
        });
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


        background.draw(g2d);


        if(timeManager.isDay()) {
            sun.draw(g2d);
            cloudList.stream().forEach(cloud -> cloud.draw(g2d));
        }
        else {
            moon.draw(g2d);
            starList.stream().forEach(star -> star.draw(g2d));
        }

        firList.stream().forEach(fir -> fir.draw(g2d));

        appleTree.draw(g2d);

        home.draw(g2d);

        lamppost.draw(g2d);

        bushList.forEach(bush -> bush.draw(g2d));

        lake.draw(g2d);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(INITIAL_WIDTH, INITIAL_HEIGHT);
    }
}