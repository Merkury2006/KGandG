import GeomObjects.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.Random;

public class DrawPanel extends JPanel {
    private static final int INITIAL_WIDTH = 1200;
    private static final int INITIAL_HEIGHT = 1200;
    private boolean colorsNeedUpdate = true;

    private Random random = new Random();
    private Path2D path = new Path2D.Double();
    private Graphics2D g2d;
    private SceneBuilder sceneBuilder;
    private TimeManager timeManager;

    private ArrayList<Cloud>  cloudList;
    private ArrayList<Star>  starList;
    private Sun sun;
    private Moon moon;
    private ArrayList<Fir> firList;
    private AppleTree appleTree;
    private Home home;
    private Lamppost lamppost;
    private ArrayList<Bush> bushList;
    private Lake lake;

    public DrawPanel() {
        this.timeManager = new TimeManager();
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

        new Timer(16, e -> {
            this.cloudList.forEach(cloud -> cloud.update(INITIAL_WIDTH));
            lake.updateDucks();
            this.repaint();
            this.starList.forEach(Star::update);
        }).start();

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                timeManager.toggleTime();
                colorsNeedUpdate = true;
                repaint();
            }
        });
    }


    private void updateColorsForTime(){
        sun.setC(timeManager.getSunColor());

        moon.setColor(timeManager.getMoonColor());
        moon.setSkyColor(timeManager.getSkyColor());

        for (int i = 0; i < cloudList.size(); i ++) {
            Cloud cloud = cloudList.get(i);
            cloud.setC(timeManager.getCloudColor(i));
        }

        for (int i = 0; i < starList.size(); i ++) {
            Star star = starList.get(i);
            star.setC(timeManager.getStarColor(i));
        }

        for (int i = 0; i < firList.size(); i ++) {
            Fir fir = firList.get(i);
            TimeManager.FirColors firColors = timeManager.getFirColors(i);
            fir.setColorTrunk(firColors.getTrunkColor());
            fir.setColorTree(firColors.getTreeColor());
        }

        appleTree.setColorTrunk(timeManager.getAppleTreeColors().getTrunkColor());
        appleTree.setColorCrown(timeManager.getAppleTreeColors().getTreeColor());
        appleTree.getAppleList().forEach(apple -> apple.setColor(timeManager.getAppleTreeColors().getAppleColor()));

        home.setColorOfHome(timeManager.getHomeColors().getColorOfHome());
        home.setColorOfDoor(timeManager.getHomeColors().getColorOfDoor());
        home.setColorOfDoorHandle(timeManager.getHomeColors().getColorOfDoorHandle());
        home.setColorOfPipe(timeManager.getHomeColors().getColorOfPipe());
        home.setColorOfRoof(timeManager.getHomeColors().getColorOfRoof());
        home.setColorOfRungs(timeManager.getHomeColors().getColorOfRungs());
        home.setColorOfShutters(timeManager.getHomeColors().getColorOfShutters());
        home.setColorOfWindows(timeManager.getHomeColors().getColorOfWindows());
        home.setColorOfInsideOfDoor(timeManager.getHomeColors().getColorOfInsideOfDoor());
        home.setColorOfWindowSill(timeManager.getHomeColors().getColorOfWindowSill());

        for (int i = 0; i < home.getFlowersOnGarden().size(); i ++) {
            Flower flower = home.getFlowersOnGarden().get(i);
            TimeManager.FlowerColors flowerColors = timeManager.getFlowerColors(i);
            flower.setColorOfStem(flowerColors.getColorOfStem());
            flower.setColorOfPetals(flowerColors.getColorOfPetals());
            flower.setColorOfCenterFlower(flowerColors.getColorOfCenterFlower());
        }

        for (int i = 0; i < home.getFlowersOnWindowsill().size(); i ++) {
            Flower flower = home.getFlowersOnWindowsill().get(i);
            TimeManager.FlowerColors flowerColors = timeManager.getFlowerColors(i);
            flower.setColorOfStem(flowerColors.getColorOfStem());
            flower.setColorOfPetals(flowerColors.getColorOfPetals());
            flower.setColorOfCenterFlower(flowerColors.getColorOfCenterFlower());
        }

        home.getFence().setColor(timeManager.getFenceColor());

        lamppost.setColorLamp(timeManager.getLamppostColors().getColorLamp());
        lamppost.setColorPost(timeManager.getLamppostColors().getColorPost());

        for (int i = 0; i < bushList.size(); i ++) {
            Bush bush = bushList.get(i);
            bush.setColor(timeManager.getBushColor(i));
        }


        lake.setColorOfLake(timeManager.getLakeColors().getColorOfLake());
        lake.setColorOfGlare(timeManager.getLakeColors().getColorOfGlare());
        lake.setColorOfWaterLily(timeManager.getLakeColors().getColorOfWaterLily());

        for (int i = 0; i < lake.getStoneList().size(); i ++) {
            Stone stone = lake.getStoneList().get(i);
            stone.setColor(timeManager.getStoneColor(i));
        }

        for (int i = 0; i < lake.getDuckList().size(); i ++) {
            Duck duck = lake.getDuckList().get(i);
            duck.setColorOfBody(timeManager.getDuckColors(i).getColorOfBody());
            duck.setColorOfBeak(timeManager.getDuckColors(i).getColorOfBeak());
            duck.setColorOfEye(timeManager.getDuckColors(i).getColorOfEye());
            duck.setColorOfHead(timeManager.getDuckColors(i).getColorOfHead());
            duck.setColorOfInsideOfEye(timeManager.getDuckColors(i).getColorOfInsideOfEye());
            duck.setColorOfNeck(timeManager.getDuckColors(i).getColorOfNeck());
            duck.setColorOfWing(timeManager.getDuckColors(i).getColorOfWing());
        }

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

        if (colorsNeedUpdate) {
            updateColorsForTime();
            colorsNeedUpdate = false;
        }

        DrawUtils.drawBackground(g2d, INITIAL_WIDTH, INITIAL_HEIGHT, INITIAL_HEIGHT / 200, INITIAL_WIDTH / 3,
                timeManager.getSkyColor(), timeManager.getGroundColor());


        if(timeManager.isDay()) {
            sun.draw(g2d);
            cloudList.stream().forEach(cloud -> cloud.draw(g2d));
        }
        else {
            moon.draw(g2d);
            starList.stream().forEach(star -> star.draw(g2d));
        }

        firList.stream().forEach(fir -> fir.draw(g2d, path));

        appleTree.draw(g2d, random, path);

        home.draw(g2d, random, path);

        lamppost.draw(g2d);

        bushList.forEach(bush -> bush.draw(g2d));

        lake.draw(g2d, random);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(INITIAL_WIDTH, INITIAL_HEIGHT);
    }
}